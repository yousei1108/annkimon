package dao;

import java.util.List;

import beans.User;

public class UserDAOService {

	UserDAO dao = new UserDAO();

	/**
	 * ユーザー名を指定し、ユーザーデータを取得するメソッド
	 * @param userName 検索を行う、ユーザー名
	 * @return 指定したユーザー名に該当する、Userインスタンスリスト
	 */
	public List<User> selectUser( String userName ){

		dao.setSql( "select * from user_accounts where user_name = ?" );
		dao.setString( 1 , userName );
		return dao.executeQueryStart();

	}

	public List<User> selectLoginUsers( String userName , String password ){

		dao.setSql( "select * from user_accounts where user_name = ? and password = ?" );
		dao.setString( 1 , userName );
		dao.setString( 2 , password );
		return dao.executeQueryStart();

	}

	/**
	 * ユーザーデータを、新規にデータベースに登録するメソッド
	 * @param user 新規登録したいユーザーデータ
	 * @return 更新に成功した行数
	 */
	public int insertUser( User user ) {

		dao.setSql( "insert into user_accounts( user_name , password ) values( ? , ? )" );
		dao.setString( 1 , user.getUserName() );
		dao.setString( 2 , user.getPassword() );
		return dao.executeUpdateStart();

	}

	/**
	 * 指定したユーザー名に該当するユーザーデータを、削除する
	 * @param userName 削除したいユーザーのユーザー名
	 * @return 削除に成功した行数
	 */
	public int deleteUser( String userName ) {

		dao.setSql( "delete from user_accounts where user_name = ?" );
		dao.setString( 1 , userName );
		return dao.executeUpdateStart();

	}

	/**
	 * ユーザーインスタンスのIDを取得し、IDに該当するデータをインスタンスのパラメーターで更新するメソッド
	 * @param user 更新を行いたいIDを格納し、更新パラメーターとして
	 * ユーザー名と、パスワードを内包したユーザーインスタンス
	 * @return 更新に成功した行数
	 */
	public int updateUser( User user ) {

		dao.setSql( "update user_accounts set user_name = ? , password = ? where id = ?" );
		dao.setString( 1 , user.getUserName() );
		dao.setString( 2 , user.getPassword() );
		dao.setInt( 3 , user.getId() );
		return dao.executeUpdateStart();

	}


}
