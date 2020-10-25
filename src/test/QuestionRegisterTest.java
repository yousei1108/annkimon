package test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import beans.Question;
import dao.QuestionDAO;
import dao.QuestionDAOService;
import error.QuestionRegisterError;
import service.QuestionRegister;

class QuestionRegisterTest {

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {

		QuestionDAOService service = new QuestionDAOService();
		service.deleteQuestion( 3 );
		QuestionDAO dao = new QuestionDAO();
		dao.setSql( "ALTER TABLE questions auto_increment = 3;" );
		dao.executeUpdateStart();

	}

	@Nested
	@DisplayName("method : registerQuestion")
	public class TestRegisterQuestion {

		QuestionRegister register = new QuestionRegister();

		@Test
		@DisplayName("カテゴリーに空白が入力されている場合")
		public void case1() {

			Question question = new Question();

			question.setUserName( "test_user" );
			question.setCategory( "" );
			question.setCorrectAnswer( "テスト" );
			question.addHint_1( "" );
			question.addHint_2( "" );

			QuestionRegisterError error = register.registerQuestion( question );

			String expected = "入力されていません。<br>";

			assertThat( error.categoryError , is( expected ) );

		}

		@Test
		@DisplayName("正常な問題が登録されようとしたとき")
		public void case2() {

			Question question = new Question();

			question.setUserName( "test_user" );
			question.setCategory( "歴史" );
			question.setCorrectAnswer( "テスト" );
			question.addHint_1( "テスト" );
			question.addHint_2( "テスト" );

			QuestionRegisterError error = register.registerQuestion( question );

			String expected = "";

			assertThat( error.categoryError , is( expected ) );

		}

		@Test
		@DisplayName("正解に空白が登録されようとしたとき")
		public void case3() {

			Question question = new Question();

			question.setUserName( "test_user" );
			question.setCategory( "歴史" );
			question.setCorrectAnswer( " " );
			question.addHint_1( "テスト" );
			question.addHint_2( "テスト" );

			QuestionRegisterError error = register.registerQuestion( question );

			String expected = "入力されていません。<br>";

			assertThat( error.correctAnswerError , is( expected ) );

		}

		@Test
		@DisplayName("ヒント１に空白が登録されようとしたとき")
		public void case4() {

			Question question = new Question();

			question.setUserName( "test_user" );
			question.setCategory( "歴史" );
			question.setCorrectAnswer( "テスト" );
			question.addHint_1( "　" );

			QuestionRegisterError error = register.registerQuestion( question );

			String expected = "入力されていません。<br>";

			assertThat( error.hintError , is( expected ) );

		}

	}

}
