package test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import error.LoginProcessError;
import service.LoginProcess;

class LoginProcessTest {

	@Nested
	@DisplayName("method : loginProcess")
	public class TestLoginProcess {

		LoginProcess process = new LoginProcess();

		@Test
		@DisplayName("登録されているユーザー名とパスワードを入力した場合")
		public void case1() {

			LoginProcessError error = process.loginProcess( "test_user" , "password" );
			assertThat( error.hasError() , is(false) );

		}

		@Test
		@DisplayName("誤ったユーザー名を入力した場合")
		public void case2() {

			LoginProcessError error = process.loginProcess( "est_user" , "password" );
			assertThat( error.hasError() , is(true) );

		}

		@Test
		@DisplayName("誤ったパスワードを入力した場合")
		public void case3() {

			LoginProcessError error = process.loginProcess( "test_user" , "assword" );
			assertThat( error.hasError() , is(true) );

		}

	}

}
