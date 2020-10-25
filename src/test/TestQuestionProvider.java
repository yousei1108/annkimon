package test;

import java.util.List;

import beans.Question;
import service.QuestionProvider;

public class TestQuestionProvider {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		QuestionProvider provider = new QuestionProvider();

		String userName     = "test_user";
		String category     = "歴史";
		int    questionRate = 50;

		List<Question> randomQuestions = provider.provideQuestions( userName , category , questionRate );

		int i = 1;

		for( Question question : randomQuestions ) {

			System.out.println( i + " 問目------------------------------------");
			System.out.println( "ＩＤ　　　：" + question.getId() );
			System.out.println( "カテゴリー：" + question.getCategory() );
			System.out.println( "ユーザー名：" + question.getUserName() );
			System.out.println( "答え　　　：" + question.getCorrectAnswer() );
			System.out.println( "ヒント１　：" + question.getHintList()[0] );
			System.out.println( "ヒント２　：" + question.getHintList()[1] );
			System.out.println( "ヒント３　：" + question.getHintList()[2] );
			System.out.println( "作成日　　：" + question.getCreated_at() );
			System.out.println( "------------------------------------------" );

			i++;
		}

	}

}
