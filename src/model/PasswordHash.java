package model;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * パスワードのハッシュ化を行うクラス
 * @author yousei
 *
 */

public class PasswordHash {

	String hashPassword = null;

	/**
	 * ハッシュ化したいパスワードを引数に指定すると、SHA-256 アルゴリズムによりハッシュ化を行い、ハッシュ化されたパスワードを返す
	 * @param inputPassword
	 * @return 入力されたパスワードのハッシュ値( String )
	 */

	public String hashPassword( String inputPassword ) {

		try {
			MessageDigest digest = MessageDigest.getInstance( "SHA-256" );
			byte[] result = digest.digest( inputPassword.getBytes() );
			hashPassword = String.format( "%064x" , new BigInteger( 1 , result ) );
		} catch( Exception e ) {
			e.printStackTrace();
		}

		return hashPassword;
	}

}
