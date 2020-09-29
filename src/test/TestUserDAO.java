package test;

import beans.User;
import dao.UserDAO;

public class TestUserDAO {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		UserDAO dao = new UserDAO();
		User insertUser = new User();
		User updateUser = new User();

		insertUser.setUserName( "insert_user" );
		insertUser.setPassword( "insert_password" );
		updateUser.setUserName( "update_user" );
		updateUser.setPassword( "update_password" );

		insertTest( dao , insertUser );
		selectTest( dao , insertUser.getUserName() );
		updateTest( dao ,  insertUser.getUserName() ,updateUser );
		selectTest( dao , updateUser.getUserName() );
		deleteTest( dao , updateUser.getUserName() );
		selectTest( dao , updateUser.getUserName() );

	}

	public static void selectTest( UserDAO dao , String userName ) {

		User user = dao.userSelect( userName );
		System.out.println( user.getUserName() + user.getPassword() + user.getId() );

	}

	public static void updateTest( UserDAO dao , String userName , User user ) {

		 int resultColumn = dao.userUpdate( userName , user );
		 System.out.println( resultColumn );

	}

	public static void insertTest( UserDAO dao , User user ) {

		int resultColumn = dao.userInsert( user );
		System.out.println( resultColumn );

	}

	public static void deleteTest( UserDAO dao , String userName ) {

		int resultColumn = dao.userDelete( userName );
		System.out.println( resultColumn );

	}

}
