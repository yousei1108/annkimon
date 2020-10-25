package beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class Question implements Serializable{

	public Question() {}


	private String userName;
	private String category;
	private String correctAnswer;
	private int id;
	private String hintList[] = new String[3];
	private Timestamp created_at;

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
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String answer) {
		this.correctAnswer = answer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public String[] getHintList() {
		return hintList;
	}
	public void setHintList(String hintList[]) {
		this.hintList = hintList;
	}
	public void addHint_1( String hint ) {
		this.hintList[0] = hint;
	}
	public void addHint_2( String hint ) {
		this.hintList[1] = hint;
	}
	public void addHint_3( String hint ) {
		this.hintList[2] = hint;
	}
	public String getHint_1() {
		return this.hintList[0];
	}
	public String getHint_2() {
		return this.hintList[1];
	}
	public String getHint_3() {
		return this.hintList[2];
	}

}
