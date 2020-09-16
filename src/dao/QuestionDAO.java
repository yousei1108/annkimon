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

	public List<Question> allQuestionSelect( Question imputQuestion ) {

		List<Question> questionList = new ArrayList<Question>();
		Connection con = null;

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
				question.setHintList( new ArrayList<String>() );
				question.getHintList().add( rs.getString( "hint_1" ) );
				question.getHintList().add( rs.getString( "hint_2" ) );
				question.getHintList().add( rs.getString( "hint_3" ) );
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

}
