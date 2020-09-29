package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.User;


/**
 * user テーブル に関する、DAOクラス<br>
 * 提供するメソッドは、単一のユーザーデータ取得、ユーザーの新規登録、ユーザーデータの更新、ユーザーデータの削除
 * @author yousei
 *
 */
public class UserDAO {

	//mysqlに接続するための、情報定数
	final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	final String JDBC_URL = "jdbc:mysql://localhost/annkimon?characterEncoding=UTF-8&serverTimezone=JST&useSSL=false";
	final String DB_USER = "root";
	final String DB_PASS = "Yousei8239";

	//------------------------------------------------------------------------
	//                             userSelect
	//------------------------------------------------------------------------
	//ユーザー名を受け取り、データベースから合致した単一のユーザーデータを返すメソッド
	//ユーザー名は、String型で受け取り、返り値としては、String userName , String password
	//int id が格納された、 User インスタンスを返す。
	//-------------------------------------------------------------------------

	/**
	 * ユーザー名を引数に、userテーブルの検索を行い、単一のユーザーデータを返す。
	 * @param userName 検索用ユーザー名
	 * @return 検索に合致した単一のユーザーデータ( Userインスタンス )<br>
	 * String userName , String password , int id を格納
	 */

	public User userSelect( String userName ) {

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
			String sql = "select * from user_accounts where user_name = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			//メソッド実行時に引数で受け取った、ユーザーインスタンスからユーザー名を
			//受け取り、そのユーザー名をSQLに挿入
			pstmt.setString( 1 , userName );
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

	//------------------------------------------------------------------ここまで



	//--------------------------------------------------------------------------
	//                            userInsert
	//--------------------------------------------------------------------------
	//引数に指定した、ユーザー名、パスワードをデータベースに登録するメソッド。
	//それぞれユーザー名と、パスワードを格納した、 User インスタンスを
	//引数に指定し、データベースに登録を行う。
	//帰り値は、 SQL にて実行された行数を int型 で返す。
	//---------------------------------------------------------------------------

	/**
	 * ユーザー名、パスワードをデータベースに新規登録する。
	 * @param imputUser 登録用ユーザーデータ( String userName , String password を格納しておく )
	 * @return SQL実行による更新行数
	 */
	public int userInsert( User imputUser ) {

		int resultColumn = 0;
		Connection con = null;

		try {

			Class.forName( DRIVER_NAME );
			con = DriverManager.getConnection( JDBC_URL , DB_USER , DB_PASS );

			//userテーブルに、新たに、ユーザー名とパスワードを追加するSQLの作成
			String sql = "insert into user_accounts( user_name , password ) values( ? , ? )";

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
	//-------------------------------------------------------------------ここまで



	//----------------------------------------------------------------------------
	//                               userDelete
	//----------------------------------------------------------------------------
	//引数で指定された、ユーザー名に応じて、ユーザーデータをデータベースから
	//削除するメソッド。
	//引数は、String型で指定する。
	//返り値は、 SQL にて実行された行数を int型 で返す。
	//----------------------------------------------------------------------------

	/**
	 * ユーザー名を引数に指定し、それに合致するユーザーデータをDBから削除する。
	 * @param userName 削除するユーザー名
	 * @return SQL実行による更新行数
	 */
	public int userDelete( String userName ) {

		int resultColumn = 0;
		Connection con = null;

		try {

			Class.forName(DRIVER_NAME);
			con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			//ユーザー名を検索値に、DBから該当のユーザーを消去する
			String sql = "delete from user_accounts where user_name = ?";

			PreparedStatement pstmt = con.prepareStatement(sql);

			//引数で指定した、ユーザーインスタンスのユーザー名を受け取り
			//SQLにセットする
			pstmt.setString( 1, userName );

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
	//------------------------------------------------------------ここまで



	//---------------------------------------------------------------------
	//                            userUpdate
	//---------------------------------------------------------------------
	//データベースに登録されている、ユーザーデータを更新する。
	//第一引数で更新したいユーザー名を指定し、第二引数で更新内容を
	// User インスタンスで指定する( インスタンスには、ユーザー名とパスワードを格納 )
	//返り値には SQL にて実行された行数を返す。
	//---------------------------------------------------------------------

	/**
	 * 第一引数で指定した、ユーザー名でデータベースへの検索を行い<br>
	 * 検索に合致した、カラムのユーザー名とパスワードを<br>
	 * 第二引数で指定した、Userインスタンスを元に更新を行う。
	 * @param userName 更新を行うカラムのユーザー名
	 * @param updateUser 更新するパラメーター( String userName , String password を格納 )
	 * @return SQL実行による更新行数
	 */
	public int userUpdate( String userName , User updateUser ) {

		int resultColumn = 0;
		Connection con = null;

		try {

			Class.forName(DRIVER_NAME);
			con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			//前ユーザー名を検索値とし、ユーザー名とパスワードの更新を行うSQL文の作成
			String sql = "update user_accounts set user_name = ? , password = ? where user_name = ?";

			PreparedStatement pstmt = con.prepareStatement(sql);

			//引数に指定されている、更新後のユーザーインスタンスから
			//ユーザー名、パスワードを受けとり、更新用の文字列にセットし
			//更新前のユーザーインスタンスから、ユーザー名を受け取り
			//検索値として、セットする
			pstmt.setString(1, updateUser.getUserName());
			pstmt.setString(2, updateUser.getPassword());
			pstmt.setString(3, userName );

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
	//-------------------------------------------------------------ここまで

}
