package dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import beans.Question;

public class QuestionDAOService {

	QuestionDAO dao = new QuestionDAO();

	public List<Question> selectQuestions( String userName ){

		dao.setSql( "select * from questions where user_name = ?" );
		dao.setString( 1 , userName );
		return dao.executeQueryStart();

	}

	public List<Question> selectQuestionsByCategory( String userName , String category ){

		dao.setSql( "select * from questions where user_name = ? and category = ?" );
		dao.setString( 1 , userName );
		dao.setString( 2 , category );
		return dao.executeQueryStart();

	}

	public List<Question> selectQuestionsById( int questionId ){

		dao.setSql( "select * from questions where id = ?" );
		dao.setInt( 1 , questionId );
		return dao.executeQueryStart();

	}

	public int insertQuestion( Question question ) {

		dao.setSql( "insert into questions( category , correct_answer , user_name , hint_1 , hint_2 , hint_3 ) values( ?,?,?,?,?,? ) " );
		dao.setString( 1 , question.getCategory() );
		dao.setString( 2 , question.getCorrectAnswer() );
		dao.setString( 3 , question.getUserName());
		dao.setString( 4 , question.getHint_1() );
		dao.setString( 5 , question.getHint_2() );
		dao.setString( 6 , question.getHint_3() );
		return dao.executeUpdateStart();

	}

	public int deleteQuestion( int id ) {

		dao.setSql( "delete from questions where id = ?" );
		dao.setInt( 1 , id );
		return dao.executeUpdateStart();

	}

	public int updateQuestion( Question question ) {

		dao.setSql( "update questions set category = ? , correct_answer = ? , hint_1 = ? , hint_2 = ? , hint_3 = ? where id = ?" );
		dao.setString( 1 , question.getCategory() );
		dao.setString( 2 , question.getCorrectAnswer() );
		dao.setString( 3 , question.getHint_1() );
		dao.setString( 4 , question.getHint_2() );
		dao.setString( 5 , question.getHint_3() );
		dao.setInt   ( 6 , question.getId() );
		return dao.executeUpdateStart();

	}

	public List<String> selectCategoryByUser( String userName ){

		Set<String> categorySet = new HashSet<String>();
		List<Question> questionList = this.selectQuestions( userName );

			for( Question question : questionList ) {
				categorySet.add( question.getCategory() );
			}

		return new ArrayList<String>( categorySet );

	}

}
