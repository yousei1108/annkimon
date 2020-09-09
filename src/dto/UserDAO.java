package dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.User;

public class UserDAO {

	Connection con = null;

	final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	final String JDBC_URL = "jdbc:mysql://localhost/annkimon?characterEncoding=UTF-8&serverTimezone=JST&useSSL=false";
	final String DB_USER = "root";
	final String DB_PASS = "Yousei8239";

	public User userSelect( User imputUser ) {

		User selectUser = new User();

		try {

			Class.forName( DRIVER_NAME );
			con = DriverManager.getConnection( JDBC_URL , DB_USER , DB_PASS );

			String sql = "select * from user where user_name = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, imputUser.getUserName());

			ResultSet rs = pstmt.executeQuery();

			while( rs.next() ) {
				selectUser.setUserName(rs.getString("user_name"));
				selectUser.setPassword(rs.getString("password"));
				selectUser.setId(rs.getInt("id"));
			}

			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}catch (SQLException e) {
				e.printStackTrace();
			}finally{
					try {
						con.close();
					}catch( SQLException e) {
						e.printStackTrace();
					}
			}
		return selectUser;
		}
	}
