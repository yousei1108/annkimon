package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class DAO<E> {

	private final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://annkimondb.cu2svyfvjnk5.ap-northeast-1.rds.amazonaws.com:3306/annkimon?characterEncoding=UTF-8&serverTimezone=JST";
	private final String DB_USER = "dbuser";
	private final String DB_PASS = "Yousei8239";

	protected Connection con = null;
	protected String sql;
	protected PreparedStatement pstmt = null;
	protected ArrayList<SQLParameter> parameterList = new ArrayList<SQLParameter>();

	protected void mysqlGetConnection() throws ClassNotFoundException, SQLException{

		Class.forName( DRIVER_NAME );
		con = DriverManager.getConnection( JDBC_URL , DB_USER , DB_PASS );

	}

	protected void createStatement() throws SQLException {

		pstmt = con.prepareStatement( sql );

	}

	public void setSql( String sql ) {
		this.sql = sql;
	}

	public void setString( int index , String parameter ) {

		SQLParameter param = new StringParameter( index , parameter );
		parameterList.add( param );

	}

	public void setInt( int index , int parameter ) {

		SQLParameter param = new IntParameter( index , parameter );
		parameterList.add( param );

	}

	public abstract List<E> executeQueryStart();
	public abstract int executeUpdateStart();
	protected abstract List<E> resultSetStore( ResultSet rs ) throws SQLException;

}
