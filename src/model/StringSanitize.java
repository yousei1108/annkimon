package model;


/**
 * ユーザーが入力した文字列を適切な形にサニタイズするクラス
 * @author youse
 *
 */
public class StringSanitize {

	/**
	 * ユーザーが入力した情報をhtmlで表示する際に、エスケープ処理を行い、文字列を返す
	 * @param sanitizeString エスケープ処理を行いたい文字列
	 * @return XSS対策として、エスケープ処理を行った文字列を返す。
	 */
	public static String escapeHTML( String sanitizeString ) {

			sanitizeString = sanitizeString.replaceAll( "&", "&amp;");
			sanitizeString = sanitizeString.replaceAll( "<", "&lt;");
			sanitizeString = sanitizeString.replaceAll( ">", "&gt;");
			sanitizeString = sanitizeString.replaceAll( "\"", "&quot;");
			sanitizeString = sanitizeString.replaceAll( "'", "&apos;");

			return sanitizeString;

	}

}
