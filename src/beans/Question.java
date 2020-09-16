package beans;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;

public class Question implements Serializable{

	public Question() {}

	private User user;
	private String category;
	private String answer;
	private int id;
	private List<String> hintList;
	private Time created_at;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	public List<String> getHintList() {
		return hintList;
	}
	public void setHintList(List<String> hintList) {
		this.hintList = hintList;
	}
	public Time getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Time created_at) {
		this.created_at = created_at;
	}

}
