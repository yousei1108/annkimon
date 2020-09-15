package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.User;

public class UserDAO {

	//mysqlに接続するための、情報定数
	final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	final String JDBC_URL = "jdbc:mysql://localhost/annkimon?characterEncoding=UTF-8&serverTimezone=JST&useSSL=false";
	final String DB_USER = "root";
	final String DB_PASS = "Yousei8239";

	//ユーザー名を受け取り、それに応じたユーザー名、パスワードを返すメソッド
	public User userSelect( User imputUser ) {

		//返り値用の、ユーザーインスタンスの生成
		//接続用インスタンスの生成、null代入
		User selectUser = new User();
		Connection con = null;

		try {

			//jdbcドライバーの読み込み
			Class.forName( DRIVER_NAME );
			//データベースへの接続
			con = DriverManager.getConnection( JDBC_URL , DB_USER , DB_PASS );

			//ユーザー名を検索ワードとした、SQLの発行
			String sql = "select * from user where user_name = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			//メソッド実行時に引数で受け取った、ユーザーインスタンスからユーザー名を
			//受け取り、そのユーザー名をSQLに挿入
			pstmt.setString(1, imputUser.getUserName());
			//Resultsetインスタンスに、結果のカーソルを保存
			ResultSet rs = pstmt.executeQuery();

			//rsが示す、データがある限り、その個所のレコードを
			//ユーザー名、パスワード、ＩＤを取得し、返り値用のユーザーインスタンスに
			//保存していく
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
			//もしメソッドの実行時に引数に指定したユーザー名が
			//あれば、ユーザーインスタンスは返り値に保存されているが
			//もし登録されていない場合は、空のユーザーインスタンスが返される。
			return selectUser;
		}

	//引数に指定した、ユーザー名、パスワードをDBに登録するメソッド
	public int userInsert( User imputUser ) {

		int resultColumn = 0;
		Connection con = null;

		try {

			Class.forName( DRIVER_NAME );
			con = DriverManager.getConnection( JDBC_URL , DB_USER , DB_PASS );

			//userテーブルに、新たに、ユーザー名とパスワードを追加するSQLの作成
			String sql = "insert into user( user_name , password ) values( ? , ? )";

			PreparedStatement pstmt = con.prepareStatement(sql);

			//引数によって指定された、ユーザーインスタンスのユーザー名と
			//パスワードをSQLに挿入
			pstmt.setString(1, imputUser.getUserName());
			pstmt.setString(2, imputUser.getPassword());

			//SQL実行行数を、受け取り戻り値の resultColumn に代入する
			resultColumn = pstmt.executeUpdate();

		}catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}catch( SQLException e ) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch( SQLException e ) {
				e.printStackTrace();
			}
		}
		//ユーザーの新規登録に成功した場合、この戻り値は
		//１になっている、また成功しなかった場合は
		//初期値である０のままである
		return resultColumn;
	}

	//引数で指定された、ユーザー名に応じて、ユーザーデータをDBから削除するメソッド
	public int userDelete( User imputUser ) {

		int resultColumn = 0;
		Connection con = null;

		try {

			Class.forName(DRIVER_NAME);
			con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			//ユーザー名を検索値に、DBから該当のユーザーを消去する
			String sql = "delete from user where user_name = ?";

			PreparedStatement pstmt = con.prepareStatement(sql);

			//引数で指定した、ユーザーインスタンスのユーザー名を受け取り
			//SQLにセットする
			pstmt.setString(1, imputUser.getUserName());

			resultColumn = pstmt.executeUpdate();

		}catch ( ClassNotFoundException e) {
			e.printStackTrace();
		}catch ( SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch ( SQLException e ) {
				e.printStackTrace();
			}
		}

		return resultColumn;
	}

	//引数で更新前のユーザーインスタンスと、変更後のユーザー情報が含まれた
	//ユーザーインスタンスを指定し、DBのユーザー名、パスワードを更新するメソッド
	public int userUpdate( User afterUser , User beforeUser ) {

		int resultColumn = 0;
		Connection con = null;

		try {

			Class.forName(DRIVER_NAME);
			con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			//前ユーザー名を検索値とし、ユーザー名とパスワードの更新を行うSQL文の作成
			String sql = "update user set user_name = ? , password = ? where = ?";

			PreparedStatement pstmt = con.prepareStatement(sql);

			//引数に指定されている、更新後のユーザーインスタンスから
			//ユーザー名、パスワードを受けとり、更新用の文字列にセットし
			//更新前のユーザーインスタンスから、ユーザー名を受け取り
			//検索値として、セットする
			pstmt.setString(1, afterUser.getUserName());
			pstmt.setString(2, afterUser.getPassword());
			pstmt.setString(3, beforeUser.getUserName());

			resultColumn = pstmt.executeUpdate();
		}catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}catch( SQLException e ) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch( SQLException e ) {
				e.printStackTrace();
			}
		}

		return resultColumn;
	}

}
