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

	public List<Question> allQuestionSelect( Question imputQuestion ) {

		List<Question> questionList = new ArrayList<Question>();

		try {

			Class.forName(DRIVER_NAME);
			con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql = "select * from question where user_name = ?";

			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setString(1, imputQuestion.getUser().getUserName());

			ResultSet rs = pstmt.executeQuery();

			while( rs.next() ) {

				Question question = new Question();
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

}
