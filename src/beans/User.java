package beans;

import java.io.Serializable;

/**
 * ユーザーデータを格納するためのクラス
 * @author yousei
 *
 */
public class User implements Serializable {

	
	
	private String userName;
	private String password;
	private int    id;

	public String getUserName() {
		return userName;
	}
	public void setUserName(String useName) {
		this.userName = useName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
