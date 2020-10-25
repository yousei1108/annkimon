package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.User;

public class UserDAO extends DAO<User> {

	@Override
	public List<User> executeQueryStart() {
		// TODO 自動生成されたメソッド・スタブ
		List<User> userList = null;

		try {
			mysqlGetConnection();

			if( sql != null ) {
				createStatement();
			}

			for( SQLParameter param : parameterList ) {
				param.setParameter( pstmt );
			}
			parameterList.clear();

			userList = resultSetStore( pstmt.executeQuery() );

		}catch ( SQLException e) {
			e.printStackTrace();
		}catch ( ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
				pstmt.close();
			}catch ( SQLException e) {
				e.printStackTrace();
			}
		}
		return userList;
	}

	@Override
	public int executeUpdateStart() {
		// TODO 自動生成されたメソッド・スタブ
		int result = 0;

		try {
			mysqlGetConnection();

			if( sql != null ) {
				createStatement();
			}

			for( SQLParameter param : parameterList ) {
				param.setParameter( pstmt );
			}
			parameterList.clear();

			result = pstmt.executeUpdate();

		}catch( SQLException e ){
			e.printStackTrace();
		}catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pstmt.close();
			}catch ( SQLException  e ) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	protected List<User> resultSetStore(ResultSet rs) throws SQLException {

		List<User> userList = new ArrayList<User>();

		while( rs.next() ) {

			User user = new User();
			user.setId( rs.getInt( "id" ) );
			user.setUserName( rs.getString( "user_name" ) );

			userList.add( user );

		}

		return userList;

	}

}
