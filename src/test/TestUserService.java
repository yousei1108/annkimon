package test;

import java.util.List;

import beans.User;
import dao.UserDAO;
import dao.UserDAOService;

public class TestUserService {

	static UserDAOService service = new UserDAOService();

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		User insertuser = new User();
		User updateUser = new User();

		insertuser.setUserName( "insert_user" );
		insertuser.setPassword( "insert_password" );

		updateUser.setUserName( "update_user" );
		updateUser.setPassword( "update_password" );
		updateUser.setId( 2 );

		selectTest( "test_user" );
		insertTest( insertuser );
		selectTest( insertuser.getUserName() );
		//deleteTest( insertuser.getUserName() );
		selectTest( insertuser.getUserName() );
		updateTest( updateUser );
		selectTest( updateUser.getUserName() );
		deleteTest( updateUser.getUserName() );
		selectTest( updateUser.getUserName() );
		selectLoginTest( "test_user" , "password" );

		UserDAO dao = new UserDAO();
		dao.setSql( "ALTER TABLE user_accounts auto_increment = 2;" );
		dao.executeUpdateStart();


	}

	static void selectTest( String userName ) {

		List<User> userList = service.selectUser( userName );

		for( User user : userList ) {

			System.out.println( "ユーザー名：" + user.getUserName() );
			System.out.println( "パスワード：" + user.getPassword() );
			System.out.println( "　　　ＩＤ：" + user.getId() );

		}
	}

	static void insertTest( User insertUser ) {

		int result = service.insertUser( insertUser );

		System.out.println( "登録しました：" + result + "件" );

	}

	static void deleteTest( String userName ) {

		int result = service.deleteUser( userName );

		System.out.println( "削除しました：" + result + "件" );

	}

	static void updateTest( User updateUser ) {

		int result = service.updateUser( updateUser );

		System.out.println( "更新しました：" + result + "件" );


	}

	static void selectLoginTest( String userName , String password ) {

		List<User> userList = service.selectLoginUsers( userName , password );

		for( User user : userList ) {

			System.out.println( "ユーザー名：" + user.getUserName() );
			System.out.println( "パスワード：" + user.getPassword() );

		}
	}
}


