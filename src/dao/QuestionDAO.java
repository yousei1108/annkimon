package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Question;

public class QuestionDAO extends DAO<Question> {

	@Override
	public List<Question> executeQueryStart() {
		// TODO 自動生成されたメソッド・スタブ
		List<Question> questionList = null;

		try {
			mysqlGetConnection();

			if( sql != null ) {
				createStatement();
			}

			for( SQLParameter param : parameterList ) {
				param.setParameter( pstmt );
			}
			parameterList.clear();

			questionList = resultSetStore( pstmt.executeQuery() );

		}catch ( SQLException e) {
			e.printStackTrace();
		}catch ( ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
				pstmt.close();
			}catch ( SQLException e) {
				e.printStackTrace();
			}
		}
		return questionList;

	}

	@Override
	public int executeUpdateStart() {
		// TODO 自動生成されたメソッド・スタブ
		int result = 0;

		try {
			mysqlGetConnection();

			if( sql != null ) {
				createStatement();
			}

			for( SQLParameter param : parameterList ) {
				param.setParameter( pstmt );
			}
			parameterList.clear();

			result = pstmt.executeUpdate();

		}catch( SQLException e ){
			e.printStackTrace();
		}catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pstmt.close();
			}catch ( SQLException  e ) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	protected List<Question> resultSetStore(ResultSet rs) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		List<Question> questionList = new ArrayList<Question>();

		while( rs.next() ) {

			Question question = new Question();

			question.setId( rs.getInt( "id" ) );
			question.setCategory( rs.getString("category") );
			question.setCorrectAnswer( rs.getString("correct_answer") );
			question.setCreated_at( rs.getTimestamp("created_at") );
			question.setUserName( rs.getString( "user_name" ) );

			String hint_1 = rs.getString( "hint_1" );
			String hint_2 = rs.getString( "hint_2" );
			String hint_3 = rs.getString( "hint_3" );

			question.addHint_1(hint_1);
			question.addHint_2(hint_2);
			question.addHint_3(hint_3);

			questionList.add( question );

		}
		return questionList;
	}



}
