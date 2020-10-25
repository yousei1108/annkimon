package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StringParameter implements SQLParameter {

	private int index;
	private String parameter;

	public StringParameter( int index , String parameter ) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.index = index;
		this.parameter = parameter;
	}

	@Override
	public void setParameter( PreparedStatement pstmt ) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		pstmt.setString( index , parameter );

	}

}
