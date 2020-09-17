package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Question;

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
	public int deleteQuestion( Question imputQuestion ) {

		int resultColumn = 0;

		try {

		Class.forName( DRIVER_NAME );
		con = DriverManager.getConnection( JDBC_URL, DB_USER, DB_PASS );

		String sql = "delete from question where id = ?";

		PreparedStatement pstmt = con.prepareStatement( sql );

		pstmt.setInt( 1 ,  imputQuestion.getId() );

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
