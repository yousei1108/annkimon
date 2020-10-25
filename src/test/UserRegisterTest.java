package test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import dao.UserDAO;
import dao.UserDAOService;
import error.UserRegisterError;
import service.UserRegister;

class UserRegisterTest {

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {

		UserDAOService service = new UserDAOService();
		service.deleteUser( "test" );
		UserDAO dao = new UserDAO();
		dao.setSql( "ALTER TABLE user_accounts auto_increment = 2;" );
		dao.executeUpdateStart();

	}

	@Nested
	@DisplayName("method : registerUser")
	public class TestRegisterUser {

		UserRegister register = new UserRegister();

		@Test
		@DisplayName("正常に登録された場合")
		public void case1() {

			UserRegisterError error = register.registerUser( "test" , "password" );
			assertThat( error.hasError() , is(false) );

		}

		@Test
		@DisplayName("ユーザー名が入力されなかった場合")
		public void case2() {

			UserRegisterError error = register.registerUser( "" , "password" );
			assertThat( error.hasError() , is(true) );

		}

		@Test
		@DisplayName("ユーザー名が半角カナであった場合")
		public void case3() {

			UserRegisterError error = register.registerUser( "ｱｲｳ" , "password" );
			assertThat( error.hasError() , is(true) );

		}

		@Test
		@DisplayName("ユーザー名に半角スペースが含まれていた場合")
		public void case4() {

			UserRegisterError error = register.registerUser( " awe" , "password" );
			assertThat( error.hasError() , is(true) );

		}

		@Test
		@DisplayName("パスワードが６文字の場合")
		public void case5() {

			UserRegisterError error = register.registerUser( "test" , "ssword" );
			assertThat( error.hasError() , is(true) );

		}

		@Test
		@DisplayName("パスワードが１７文字であった場合")
		public void case6() {

			UserRegisterError error = register.registerUser( " awe" , "passwordpaswordp" );
			assertThat( error.hasError() , is(true) );

		}

		@Test
		@DisplayName("パスワードが空白であった場合")
		public void case7() {

			UserRegisterError error = register.registerUser( "awe" , "  " );
			assertThat( error.hasError() , is(true) );

		}

		@Test
		@DisplayName("ユーザー名に重複があった場合")
		public void case8() {

			UserRegisterError error = register.registerUser( "test_user" , "password" );
			assertThat( error.hasError() , is(true) );

		}


	}

}
