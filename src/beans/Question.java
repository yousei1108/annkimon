package beans;

import java.io.Serializable;
import java.sql.Time;

public class Question implements Serializable{

	public Question() {}


	private String userName;
	private String category;
	private String answer;
	private int id;
	private String hintList[] = new String[3];
	private Time created_at;

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Time getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Time created_at) {
		this.created_at = created_at;
	}
	public String[] getHintList() {
		return hintList;
	}
	public void setHintList(String hintList[]) {
		this.hintList = hintList;
	}

}
