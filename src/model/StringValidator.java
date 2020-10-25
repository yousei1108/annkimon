package model;

import java.util.regex.Pattern;

public class StringValidator {

	public String errorMsg = "";
	private String checkString = "";

	public StringValidator( String checkString ) {
		this.checkString = checkString;
	}

	public StringValidator() {}

	/**
	 * 入力された文字が、空白文字、またはnullであった場合にfalseを返す
	 * @param checkString 空白、もしくはnullであるかどうかを調べたい文字
	 * @return チェックの結果、エラーがあれば、エラーメッセージを返す( 問題なければ 空文字 )
	 */
	public StringValidator emptyNullCheck() {

		if( checkString.strip().length() == 0 || checkString == null ) {
			errorMsg += "入力されていません。<br>";
		}

		return this;

	}

	/**
	 * 入力された文字が、半角英数字であるかを調べるメソッド
	 * @param checkString 調べたい文字列
	 * @return チェックの結果、エラーあれば、エラーメッセージを返す( 問題なければ 空文字 )
	 */
	public StringValidator halfAlphaCheck() {

		if( !( Pattern.matches( "^[0-9a-zA-Z]+$", checkString ) ) ) {
			errorMsg += "半角英数字で入力してください<br>";
		}

		return this;

	}

	/**
	 * 入力された文字が、８文字以上１６文字以下であるかどうかを調べるメソッド
	 * @param checkString 調べたい文字列
	 * @return チェックの結果、エラーがあれば、エラーメッセージを返す( 問題なければ 空文字 )
	 */
	public StringValidator passwordLengthCheck() {

		if( checkString.length() < 8 || checkString.length() > 16 ) {
			errorMsg += "８文字以上１６文字以下で入力してください<br>";
		}

		return this;

	}

}
