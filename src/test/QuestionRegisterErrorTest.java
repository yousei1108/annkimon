package test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import error.QuestionRegisterError;

class QuestionRegisterErrorTest {

	@Nested
	@DisplayName( "method : hasError" )
	public class TestHasError{

		private QuestionRegisterError error = new QuestionRegisterError();

		@Test
		@DisplayName( "エラーがない場合のテストケース" )
		public void case1() {

			assertThat( error.hasError() , is(false) );

		}

		@Test
		@DisplayName( "カテゴリーにエラーがあった場合のテストケース" )
		public void case2() {

			error.categoryError = "test";
			assertThat( error.hasError() , is(true) );

		}

		@Test
		@DisplayName( "正解にエラーがあった場合のテストケース" )
		public void case3() {

			error.correctAnswerError = "test";
			assertThat( error.hasError() , is(true) );

		}

		@Test
		@DisplayName( "ヒントにエラーがあった場合のテストケース" )
		public void case4() {

			error.hintError = "test";
			assertThat( error.hasError() , is(true) );

		}

		@Test
		@DisplayName( "実行エラーがあった場合のテストケース" )
		public void case5() {

			error.executionError = "test";
			assertThat( error.hasError() , is(true) );

		}

	}

}
