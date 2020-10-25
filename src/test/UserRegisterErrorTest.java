package test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import error.UserRegisterError;

class UserRegisterErrorTest {

	@Nested
	@DisplayName( "method : hasError" )
	public class TestHasError{

		private UserRegisterError error = new UserRegisterError();

		@Test
		@DisplayName( "エラーがない場合のテストケース" )
		public void case1() {

			assertThat( error.hasError() , is(false) );

		}

		@Test
		@DisplayName( "名前にエラーがあった場合のテストケース" )
		public void case2() {

			error.nameError = "test";
			assertThat( error.hasError() , is(true) );

		}

		@Test
		@DisplayName( "パスワードにエラーがあった場合のテストケース" )
		public void case3() {

			error.passwordError = "test";
			assertThat( error.hasError() , is(true) );

		}

		@Test
		@DisplayName( "実行エラーがあった場合のテストケース" )
		public void case4() {

			error.executionError = "test";
			assertThat( error.hasError() , is(true) );

		}
	}
}
