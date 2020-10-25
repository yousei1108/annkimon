package entity;

import java.io.Serializable;

public class Answer implements Serializable {

	public String answerString;
	public int hintOpenCount;
	public boolean correctCheck;

	public String getAnswerString() {
		return answerString;
	}
	public int getHintOpenCount() {
		return hintOpenCount;
	}
	public boolean isCorrectCheck() {
		return correctCheck;
	}

}
