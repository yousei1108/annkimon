package test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import beans.Question;
import entity.Answer;
import service.AnswerCheck;

class AnswerCheckTest {

	@Nested
	@DisplayName("method : answerCheck")
	public class TestAnswerCheck {

		AnswerCheck answerCheck = new AnswerCheck();

		@Test
		@DisplayName("問題と回答に同じ文字が入力された場合")
		public void case1() {

			Answer answer = new Answer();
			Question question = new Question();

			answer.answerString = "テスト";
			question.setCorrectAnswer( "テスト" );

			answerCheck.checkAnswer( answer , question );

			assertThat( answer.correctCheck , is(true) );

		}

		@Test
		@DisplayName("問題とは異なり回答に全角空白が含まれていた場合")
		public void case2() {

			Answer answer = new Answer();
			Question question = new Question();

			answer.answerString = "　テスト";
			question.setCorrectAnswer( "テスト" );

			answerCheck.checkAnswer( answer , question );

			assertThat( answer.correctCheck , is(true) );

		}

		@Test
		@DisplayName("問題とは異なり回答に半角空白が含まれていた場合")
		public void case3() {

			Answer answer = new Answer();
			Question question = new Question();

			answer.answerString = " テ ス ト ";
			question.setCorrectAnswer( "テスト" );

			answerCheck.checkAnswer( answer , question );

			assertThat( answer.correctCheck , is(true) );

		}

		@Test
		@DisplayName("問題に空白が含まれていた場合")
		public void case4() {

			Answer answer = new Answer();
			Question question = new Question();

			answer.answerString = "テスト";
			question.setCorrectAnswer( "テ  ス  ト" );

			answerCheck.checkAnswer( answer , question );

			assertThat( answer.correctCheck , is(true) );

		}

		@Test
		@DisplayName("問題は半角、回答は全角で入力した場合")
		public void case5() {

			Answer answer = new Answer();
			Question question = new Question();

			answer.answerString = "tｅｓｔ１２３４";
			question.setCorrectAnswer( "test1234" );

			answerCheck.checkAnswer( answer , question );

			assertThat( answer.correctCheck , is(true) );

		}

		@Test
		@DisplayName("問題は小文字、回答は大文字が含まれていた場合")
		public void case6() {

			Answer answer = new Answer();
			Question question = new Question();

			answer.answerString = "TesＴ";
			question.setCorrectAnswer( "test" );

			answerCheck.checkAnswer( answer , question );

			assertThat( answer.correctCheck , is(true) );

		}

		@Test
		@DisplayName("間違った回答が入力された場合")
		public void case7() {

			Answer answer = new Answer();
			Question question = new Question();

			answer.answerString = "Tes";
			question.setCorrectAnswer( "test" );

			answerCheck.checkAnswer( answer , question );

			assertThat( answer.correctCheck , is(false) );

		}

	}

}
