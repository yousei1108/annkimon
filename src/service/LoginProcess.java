package service;

import java.util.List;

import beans.User;
import dao.UserDAOService;
import error.LoginProcessError;
import model.StringFormatter;

public class LoginProcess {

	public LoginProcessError loginProcess( String userName , String password ) {

		LoginProcessError error = new LoginProcessError();
		UserDAOService daoService = new UserDAOService();
		StringFormatter formatter = new StringFormatter();

		List<User> user = daoService.selectLoginUsers( userName , formatter.toHash( password ) );

		if( user.isEmpty() ) {

			error.loginError += "ユーザー名、もしくはパスワードが異なります<br>";

		}

		return error;

	}

}
