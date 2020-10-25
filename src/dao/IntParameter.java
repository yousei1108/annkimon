package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IntParameter implements SQLParameter {

	private int index;
	private int parameter;

	public IntParameter( int index , int parameter ) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.index = index;
		this.parameter = parameter;
	}

	@Override
	public void setParameter(PreparedStatement pstmt) throws SQLException {
		// TODO 自動生成されたメソッド・スタブ
		pstmt.setInt( index , parameter );

	}

}
