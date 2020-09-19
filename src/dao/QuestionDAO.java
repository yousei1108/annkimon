package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Question;

/**
 * questionテーブルに関する、DAOクラス<br>
 * 提供するメソッドは、問題の全取得( ユーザー毎 )、問題の新規登録、問題の更新、問題の削除
 * @author yousei
 */

public class QuestionDAO {

	private final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost/annkimon?characterEncoding=UTF-8&serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "Yousei8239";
	Connection con = null;


	//--------------------------------------------------------------------
	//                      allQuestionSelect
	//--------------------------------------------------------------------
	//ユーザー毎の問題を全て選択し、問題のリストを返すメソッド。
	//検索に使用されるのは、ユーザー名のみ。
	//使用する際は、ユーザー名をString型で引数として、指定する。
	//ユーザー名は、ログイン時に保存しているセッションから取得すればよい。
	//返り値は、List< Question >型の、ArrayList を返す。
	//--------------------------------------------------------------------

	/**
	 * ユーザー名を引数に、データベースを検索し、問題の一覧をリストにして返す
	 * @param userName 問題を作成したユーザー名
	 * @return 問題の内容をQuestionインスタンスに保存し、それをリスト化したもの<br>
	 			Questionインスタンスには、int id , String category , String answer ,<br>
	 			Time created_at , String hintList[] が格納される。
	 */
	public List<Question> allQuestionSelect( String userName ) {

		List<Question> questionList = new ArrayList<Question>();

		try {

			Class.forName(DRIVER_NAME);
			con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql = "select * from question where user_name = ?";

			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setString( 1, userName );

			ResultSet rs = pstmt.executeQuery();

			while( rs.next() ) {

				Question question = new Question();
				question.setId( rs.getInt( "id" ) );
				question.setCategory( rs.getString("category") );
				question.setAnswer( rs.getString("answer") );
				question.setCreated_at( rs.getTime("created_at") );

				String hint_1 = rs.getString( "hint_1" );
				String hint_2 = rs.getString( "hint_2" );
				String hint_3 = rs.getString( "hint_3" );

				question.getHintList()[0] = hint_1;
				question.getHintList()[1] = hint_2;
				question.getHintList()[2] = hint_3;

				questionList.add( question );

			}
		}
		catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}catch( SQLException e ) {
			e.printStackTrace();
		}
		finally {
			try{
				con.close();
			}catch( SQLException e ) {
				e.printStackTrace();
			}
		}

		return questionList;
	}
	//----------------------------------------------------------ここまで


	//------------------------------------------------------------------
	//                      insertQuestion
	//------------------------------------------------------------------
	//ユーザーから入力された、問題をデータベースに保存するメソッド。
	//使用する際は、引数に問題の String category , String answer , User user ,
	//String hintList[] を格納した、Question インスタンスを引数とする。
	//返り値は、 SQL にて実行された行数を int型 で返す。
	//------------------------------------------------------------------

	/**
	 * 引数に指定した問題情報を、データベースに登録する。
	 * @param imputQuestion 登録したい問題情報( String category , String answer , String hintList[] を格納しておく)
	 * @return SQL実行による、変更行数
	 */
	public int insertQuestion( Question imputQuestion ) {

		int resultColumn = 0;

		try {

			Class.forName( DRIVER_NAME );
			con = DriverManager.getConnection( JDBC_URL, DB_USER, DB_PASS );

			String sql = "insert into question( category , answer , hint_1 , hint_2 , hint_3 ) values( ?,?,?,?,? ) ";

			PreparedStatement pstmt = con.prepareStatement( sql );

			pstmt.setString( 1 , imputQuestion.getCategory() );
			pstmt.setString( 2 , imputQuestion.getAnswer() );
			pstmt.setString( 3 , imputQuestion.getHintList()[0] );
			pstmt.setString( 4 , imputQuestion.getHintList()[1] );
			pstmt.setString( 5 , imputQuestion.getHintList()[2] );

			resultColumn = pstmt.executeUpdate();

		}
		catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}catch( SQLException e ) {
			e.printStackTrace();
		}
		finally {
			try{
				con.close();
			}catch( SQLException e ) {
				e.printStackTrace();
			}
		}

		return resultColumn;
	}
	//------------------------------------------------------ここまで


	//--------------------------------------------------------------
	//                     deleteQuestion
	//--------------------------------------------------------------
	//ユーザーが指定した、問題のIDによって、問題をデータベースから
	//削除するメソッド。
	//問題の一覧テーブルなどから、ユーザーが選択した問題のIDを
	//Questionインスタンスに保存し、それを引数とする。
	//返り値は、 SQL にて実行された行数を int型 で返す。
	//--------------------------------------------------------------

	/**
	 * 引数に指定した、問題のIDを検索値として、データベースから該当のレコードを削除する。
	 * @param questionId 削除する問題のID
	 * @return SQL実行による、変更行数
	 */
	public int deleteQuestion( int questionId ) {

		int resultColumn = 0;

		try {

		Class.forName( DRIVER_NAME );
		con = DriverManager.getConnection( JDBC_URL, DB_USER, DB_PASS );

		String sql = "delete from question where id = ?";

		PreparedStatement pstmt = con.prepareStatement( sql );

		pstmt.setInt( 1 ,  questionId );

		resultColumn = pstmt.executeUpdate();

		}catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}catch( SQLException e ) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch( SQLException e ) {
				e.printStackTrace();
			}
		}

		return resultColumn;
	}
	//-----------------------------------------------------ここまで


	//-------------------------------------------------------------
	//                      updateQuestion
	//-------------------------------------------------------------
	//ユーザーが選択した問題のカテゴリー、答え、ヒントを編集するメソッド。
	//それぞれのデータを格納した、Questionインスタンスを引数とする。
	//更に、Questionインスタンスには、変更したい問題のIDを格納しておき
	//それをデータベースでの、検索値とする。（該当の問題のデータを更新する)
	//返り値には、 SQL を実行した行数を int型 で返す。
	//-------------------------------------------------------------

	/**
	 * 引数のQuestionインスタンスから、idを取得し、それに合致する問題のレコードを<br>
	 * 引数のQuestionインスタンスからのパラメーターで更新する
	 * @param imputQuestion 更新したい問題の情報( String category , String answer , String hintList[] )
	 *  + 更新を行う id を格納
	 * @return SQL実行による、変更行数
	 */
	public int updateQuestion( Question imputQuestion ) {

		int resultColumn = 0;

		try {

			Class.forName( DRIVER_NAME );
			con = DriverManager.getConnection( JDBC_URL, DB_USER, DB_PASS );

			String sql = "update question set category = ? , answer = ? , hint_1 = ? , hint_2 = ? , hint_3 = ? where id = ?";

			PreparedStatement pstmt = con.prepareStatement( sql );

			pstmt.setString( 1 , imputQuestion.getCategory() );
			pstmt.setString( 2 , imputQuestion.getAnswer() );
			pstmt.setString( 3 , imputQuestion.getHintList()[0] );
			pstmt.setString( 4 , imputQuestion.getHintList()[1] );
			pstmt.setString( 5 , imputQuestion.getHintList()[2] );
			pstmt.setInt   ( 6 , imputQuestion.getId() );

			resultColumn = pstmt.executeUpdate();

		}catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}catch( SQLException e ) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch( SQLException e ) {
				e.printStackTrace();
			}
		}

		return resultColumn;
	}

	//---------------------------------------------------ここまで
}
