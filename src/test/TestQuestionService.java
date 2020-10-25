package test;

import java.util.List;

import beans.Question;
import dao.QuestionDAO;
import dao.QuestionDAOService;

public class TestQuestionService {

	QuestionDAOService service = new QuestionDAOService();

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		TestQuestionService test = new TestQuestionService();
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
		insertQuestion.setCorrectAnswer( "豊臣秀吉" );
		insertQuestion.setHintList( insertHintList );

		updateQuestion.setUserName( "insert_user" );
		updateQuestion.setCategory( "数学" );
		updateQuestion.setCorrectAnswer( "2" );
		updateQuestion.setHintList( updateHintList );
		updateQuestion.setId( 3 );

		//---------------------------テスト実行-------------------------------

		test.selectTest( "test_user" );
		System.out.println( "--------------------------------------------------" );
		test.insertTest( insertQuestion );
		System.out.println( "--------------------------------------------------" );
		test.selectTest( insertQuestion.getUserName() );
		System.out.println( "--------------------------------------------------" );
		test.updateTest( updateQuestion );
		System.out.println( "--------------------------------------------------" );
		test.selectTest( updateQuestion.getUserName() );
		System.out.println( "--------------------------------------------------" );
		test.deleteTest( 3 );
		System.out.println( "--------------------------------------------------" );
		test.selectTest( updateQuestion.getUserName() );
		System.out.println( "--------------------------------------------------" );

		QuestionDAO dao = new QuestionDAO();
		dao.setSql( "ALTER TABLE questions auto_increment = 3;" );
		dao.executeUpdateStart();

		//---------------------------------------------------------------------

	}

	public void selectTest( String userName ) {

		List<Question> questions = service.selectQuestions( userName );

		for( Question question : questions ) {

			System.out.println( "ＩＤ　　　：" + question.getId() );
			System.out.println( "カテゴリー：" + question.getCategory() );
			System.out.println( "ユーザー名：" + question.getUserName() );
			System.out.println( "答え　　　：" + question.getCorrectAnswer() );
			System.out.println( "ヒント１　：" + question.getHintList()[0] );
			System.out.println( "ヒント２　：" + question.getHintList()[1] );
			System.out.println( "ヒント３　：" + question.getHintList()[2] );
			System.out.println( "ヒント３　：" + question.getCreated_at() );

		}
	}

	public void insertTest( Question insertQuestion ) {

		int resultColumn = service.insertQuestion( insertQuestion );
		System.out.println( "登録しました：" + resultColumn + "件" );

	}

	public void updateTest( Question updateQuestion ) {

		int resultColumn = service.updateQuestion( updateQuestion );
		System.out.println( "更新しました：" + resultColumn + "件" );

	}

	public void deleteTest( int questionId ) {

		int resultColumn = service.deleteQuestion( questionId );
		System.out.println( "削除しました：" + resultColumn + "件" );

	}

}
