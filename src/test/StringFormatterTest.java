package test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import model.StringFormatter;


class StringFormatterTest {

	StringFormatter formatter = new StringFormatter();

	@Nested
	@DisplayName( "method : toEscapeHTML" )
	public class TestToEscapeHTML {


		@Test
		@DisplayName( "エスケープ文字がない場合のテストケース" )
		public void case1() {

			String actual = "テスト　test 12345";
			String expected = actual;
			assertThat( formatter.toEscapeHTML( actual ) , is( expected ) );

		}

		@Test
		@DisplayName( "エスケープ文字がある場合のテストケース" )
		public void case2() {

			String actual = "<テスト>\"test&'12345";
			String expected = "&lt;テスト&gt;&quot;test&amp;&apos;12345";
			assertThat( formatter.toEscapeHTML( actual ) , is( expected ) );

		}

	}

	@Nested
	@DisplayName( "method : toHash" )
	public class TestToHash {


		@Test
		@DisplayName( "「パスワード」という文字列をハッシュ化したテストケース" )
		public void case1() {

			String actual = "パスワード";
			String expected = "d8b076148c939d9d2d6eb60458969c486794a4c0fcf0632be58fa5bf6d15aafa";
			assertThat( formatter.toHash( actual ) , is( expected ) );

		}

		@Test
		@DisplayName( "空文字に対するハッシュ化のテストケース" )
		public void case2() {

			String actual = "";
			String expected = "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855";
			assertThat( formatter.toHash( actual ) , is( expected ) );


		}

	}

	@Nested
	@DisplayName( "method : removeSpace" )
	public class TestRemoveSpace {

		@Test
		@DisplayName( "全角スペースがある場合のテストケース" )
		public void case1() {

			String actual = "　テスト　1234";
			String expected = "テスト1234";
			assertThat( formatter.removeSpace( actual ) , is( expected ) );

		}

		@Test
		@DisplayName( "半角スペースがある場合のテストケース" )
		public void case2() {

			String actual = " テスト 1234";
			String expected = "テスト1234";
			assertThat( formatter.removeSpace( actual ) , is( expected ) );

		}

		@Test
		@DisplayName( "スペースがない場合のテストケース" )
		public void case3() {

			String actual = "テスト1234";
			String expected = "テスト1234";
			assertThat( formatter.removeSpace( actual ) , is( expected ) );


		}

	}

	@Nested
	@DisplayName( "method : toHalfAlpha" )
	public class TestToHalfAlpha {

		@Test
		@DisplayName( "全角文字を入力した場合のテストケース" )
		public void case1() {

			String actual = "あいう　１２３４　漢字　ＡＢＣ　アイウ";
			String expected = "あいう 1234 漢字 ABC ｱｲｳ";
			assertThat( formatter.toHalfAlpha( actual ) , is( expected ) );

		}

		@Test
		@DisplayName( "半角文字を入力した場合のテストケース" )
		public void case2() {

			String actual = "1234abc ";
			String expected = "1234abc ";
			assertThat( formatter.toHalfAlpha( actual ) , is( expected ) );

		}

	}

}
