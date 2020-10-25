package service;



import beans.User;
import dao.UserDAOService;
import error.UserRegisterError;
import model.StringFormatter;
import model.StringValidator;

public class UserRegister {

	public UserRegisterError registerUser( String userName , String password ) {

		UserRegisterError error = new UserRegisterError();
		UserDAOService service = new UserDAOService();

		//文字列の整合性確認、エラーメッセージの追加
		StringValidator userValidator = new StringValidator( userName );
		userValidator.emptyNullCheck().halfAlphaCheck();
		error.nameError = userValidator.errorMsg;

		//userNameでDBを検索し、Listがあればエラーメッセージを追加
		if( !( service.selectUser( userName ).isEmpty() ) ) {
			error.nameError += "このユーザー名はすでに使用されています<br>";
		}

		StringValidator passwordValidator = new StringValidator( password );
		passwordValidator.emptyNullCheck().halfAlphaCheck().passwordLengthCheck();
		error.passwordError = passwordValidator.errorMsg;

		//エラーが含まれていなければユーザー登録を行う
		if( !( error.hasError() ) ) {

			User user = new User();
			StringFormatter formatter = new StringFormatter();
			user.setUserName( userName );
			user.setPassword( formatter.toHash( password ) );
			int result = service.insertUser( user );

			if( result < 1 ) {
				error.executionError = "登録できませんでした<br>再度同じ操作を行ってください<br>";
			}
		}
		return error;
	}
}
