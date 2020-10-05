package model;

import java.util.regex.Pattern;

public class StringCheck {

	/**
	 * 入力された文字が、空白文字、またはnullであった場合にfalseを返す
	 * @param checkString 空白、もしくはnullであるかどうかを調べたい文字
	 * @return チェックの結果、エラーがあれば、エラーメッセージを返す( 問題なければ null )
	 */
	public static String emptyNullCheck( String checkString ) {

		if( checkString.length() == 0 || checkString == null ) {
			return "入力されていません。";
		}else {
			return null;
		}

	}

	/**
	 * 入力された文字が、半角英数字であるかを調べるメソッド
	 * @param checkString 調べたい文字列
	 * @return チェックの結果、エラーあれば、エラーメッセージを返す( 問題なければ null )
	 */
	public static String halfAlphaCheck( String checkString ) {

		if( Pattern.matches( "^[0-9a-zA-Z]+$", checkString ) ) {
			return null;
		}else {
			return "半角英数字で入力してください";
		}

	}

	/**
	 * 入力された文字が、８文字以上であるかどうかを調べるメソッド
	 * @param checkString 調べたい文字列
	 * @return チェックの結果、エラーがあれば、エラーメッセージを返す( 問題なければ null )
	 */
	public static String eightLengtCheck( String checkString ) {

		if( checkString.length() < 8 ) {
			return null;
		}else {
			return "８文字以上で入力してください";
		}

	}

}