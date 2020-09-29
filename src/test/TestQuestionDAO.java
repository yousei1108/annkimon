package test;

import java.util.List;

import beans.Question;
import dao.QuestionDAO;

public class TestQuestionDAO {

	QuestionDAO dao = new QuestionDAO();

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		TestQuestionDAO test = new TestQuestionDAO();
		Question insertQuestion = new Question();
		Question updateQuestion = new Question();
		String insertHintList[] = new String[3];
		String updateHintList[] = new String[3];
		insertHintList[0] = "hint_1";
		insertHintList[1] = "hint_2";
		insertHintList[2] = "hint_3";
		updateHintList[0] = "hint_4";
		updateHintList[1] = "hint_5";

		insertQuestion.setUserName( "insert_user" );
		insertQuestion.setCategory( "歴史" );
		insertQuestion.setAnswer( "豊臣秀吉" );
		insertQuestion.setHintList( insertHintList );

		updateQuestion.setUserName( "insert_user" );
		updateQuestion.setCategory( "数学" );
		updateQuestion.setAnswer( "2" );
		updateQuestion.setHintList( updateHintList );
		updateQuestion.setId( 6 );

		//---------------------------テスト実行-------------------------------

		test.selectTest( "test_user" );
		test.insertTest( insertQuestion );
		test.selectTest( insertQuestion.getUserName() );
		test.updateTest( updateQuestion );
		test.selectTest( updateQuestion.getUserName() );
		test.deleteTest( 6 );
		test.selectTest( updateQuestion.getUserName() );

		//---------------------------------------------------------------------

	}

	public void selectTest( String userName ) {

		List<Question> questions = dao.allQuestionSelect( userName );

		for( Question question : questions ) {

			System.out.println( question.getId() );
			System.out.println( question.getCategory() );
			System.out.println( question.getUserName() );
			System.out.println( question.getAnswer() );
			System.out.println( question.getHintList()[0] );
			System.out.println( question.getHintList()[1] );
			System.out.println( question.getHintList()[2] );

		}
	}

	public void insertTest( Question insertQuestion ) {

		int resultColumn = dao.insertQuestion( insertQuestion );
		System.out.println( resultColumn );

	}

	public void updateTest( Question updateQuestion ) {

		int resultColumn = dao.updateQuestion( updateQuestion );
		System.out.println( resultColumn );

	}

	public void deleteTest( int questionId ) {

		int resultColumn = dao.deleteQuestion( questionId );
		System.out.println( resultColumn );

	}

}
