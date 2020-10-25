package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface SQLParameter {

	public void setParameter( PreparedStatement pstmt ) throws SQLException;

}
