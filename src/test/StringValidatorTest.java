package test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import model.StringValidator;

class StringValidatorTest {

	@Nested
	@DisplayName("method : emptyNullCheck")
	public class TestEmptyNullCheck {

		@Test
		@DisplayName("半角空白が入力されている場合のテストケース")
		public void case1() {

			StringValidator validator = new StringValidator( "  " );
			String expected = "入力されていません。<br>";
			assertThat( validator.emptyNullCheck().errorMsg , is( expected ) );

		}

		@Test
		@DisplayName("文字が入力されずnullであった場合のテストケース")
		public void case2() {

			StringValidator validator = new StringValidator();
			String expected = "入力されていません。<br>";
			assertThat( validator.emptyNullCheck().errorMsg , is( expected ) );

		}

		@Test
		@DisplayName("全角空白が入力されていた場合のテストケース")
		public void case3() {

			StringValidator validator = new StringValidator("　　");
			String expected = "入力されていません。<br>";
			assertThat( validator.emptyNullCheck().errorMsg , is( expected ) );

		}

		@Test
		@DisplayName("通常に文字が入力されていた場合のテストケース")
		public void case4() {

			StringValidator validator = new StringValidator(" test ");
			String expected = "";
			assertThat( validator.emptyNullCheck().errorMsg , is( expected ) );

		}

	}

	@Nested
	@DisplayName("method : halfAlphaCheck")
	public class TestHalfAlphaCheck {

		@Test
		@DisplayName("半角英数で入力されている場合")
		public void case1() {

			StringValidator validator = new StringValidator("test1234");
			String expected = "";
			assertThat( validator.halfAlphaCheck().errorMsg , is( expected ) );

		}

		@Test
		@DisplayName("全角数字が含まれている場合")
		public void case2() {

			StringValidator validator = new StringValidator("test１２３４");
			String expected = "半角英数字で入力してください<br>";
			assertThat( validator.halfAlphaCheck().errorMsg , is( expected ) );

		}

		@Test
		@DisplayName("全角英字が含まれている場合")
		public void case3() {

			StringValidator validator = new StringValidator("ＴＥＳＴ1234");
			String expected = "半角英数字で入力してください<br>";
			assertThat( validator.halfAlphaCheck().errorMsg , is( expected ) );

		}

		@Test
		@DisplayName("日本語が含まれている場合")
		public void case4() {

			StringValidator validator = new StringValidator("テスト1234");
			String expected = "半角英数字で入力してください<br>";
			assertThat( validator.halfAlphaCheck().errorMsg , is( expected ) );

		}

	}

	@Nested
	@DisplayName("method : passwordLengthCheck")
	public class TestPasswordLengthCheck {

		@Test
		@DisplayName("８文字が入力された場合")
		public void case1() {

			StringValidator validator = new StringValidator("password");
			String expected = "";
			assertThat( validator.passwordLengthCheck().errorMsg , is( expected ) );

		}

		@Test
		@DisplayName("１６文字で入力された場合")
		public void case2() {

			StringValidator validator = new StringValidator("passwordpassword");
			String expected = "";
			assertThat( validator.passwordLengthCheck().errorMsg , is( expected ) );

		}

		@Test
		@DisplayName("７文字で入力された場合")
		public void case3() {

			StringValidator validator = new StringValidator("passwor");
			String expected = "８文字以上１６文字以下で入力してください<br>";
			assertThat( validator.passwordLengthCheck().errorMsg , is( expected ) );

		}

		@Test
		@DisplayName("１７文字で入力された場合")
		public void case4() {

			StringValidator validator = new StringValidator("passwordpasswordp");
			String expected = "８文字以上１６文字以下で入力してください<br>";
			assertThat( validator.passwordLengthCheck().errorMsg , is( expected ) );

		}

	}

}
