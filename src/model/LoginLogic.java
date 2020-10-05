package model;

import beans.User;
import dao.UserDAO;

public class LoginLogic {

	/**
	 *
	 * @param userName ログインするユーザー名
	 * @param password ログインするユーザーパスワード
	 * @return データベースでユーザーデータが照合できれば、true を返す。<br>
	 * そうでなければ、falseを返す。
	 */
	public boolean Logincheck( String userName , String password ) {

		UserDAO dao = new UserDAO();
		User selectUser = dao.userSelect( userName );

		PasswordHash passHash = new PasswordHash();

		if( passHash.hashPassword( password ).equals( selectUser.getPassword() )){
			return true;
		}else { return false; }

	}

}
