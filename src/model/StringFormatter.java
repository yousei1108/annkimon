package model;

import java.math.BigInteger;
import java.security.MessageDigest;

import com.ibm.icu.text.Transliterator;

/**
 * ユーザーが入力した文字列を適切な形にサニタイズするクラス
 * @author youse
 *
 */
public class StringFormatter {

	/**
	 * ユーザーが入力した情報をhtmlで表示する際に、エスケープ処理を行い、文字列を返す
	 * @param sanitizeString エスケープ処理を行いたい文字列
	 * @return XSS対策として、エスケープ処理を行った文字列を返す。
	 */
	public String toEscapeHTML( String escapeString ) {

		escapeString = escapeString.replaceAll( "&", "&amp;");
		escapeString = escapeString.replaceAll( "<", "&lt;");
		escapeString = escapeString.replaceAll( ">", "&gt;");
		escapeString = escapeString.replaceAll( "\"", "&quot;");
		escapeString = escapeString.replaceAll( "'", "&apos;");

		return escapeString;

	}

	public String toHash( String sanitizeString ) {

		String hashString = null;

		try {
			MessageDigest digest = MessageDigest.getInstance( "SHA-256" );
			byte[] result = digest.digest( sanitizeString.getBytes() );
			hashString = String.format( "%064x" , new BigInteger( 1 , result ) );
		}catch( Exception e ) {
			e.printStackTrace();
		}

		return hashString;

	}

	public String removeSpace( String sanitizeString ) {

		return sanitizeString.replaceAll( " " , "" ).replaceAll( "　" , "" );

	}

	public String toHalfAlpha( String fullAlpha ) {

		Transliterator fullToHalf = Transliterator.getInstance( "Fullwidth-Halfwidth" );
		return fullToHalf.transliterate( fullAlpha );

	}

}

