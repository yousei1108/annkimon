package test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import error.LoginProcessError;

class LoginProcessErrorTest {

	@Nested
	@DisplayName( "method : hasError" )
	public class TestHasError{

		private LoginProcessError error = new LoginProcessError();

		@Test
		@DisplayName( "エラーがない場合のテストケース" )
		public void case1() {

			assertThat( error.hasError() , is(false) );

		}

		@Test
		@DisplayName( "エラーがあった場合のテストケース" )
		public void case2() {

			error.loginError = "test";
			assertThat( error.hasError() , is(true) );

		}

	}

}
