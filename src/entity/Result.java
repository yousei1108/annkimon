package entity;

import java.io.Serializable;

public class Result implements Serializable {

	public int questionRate;
	public int correctRate;
	public int hintOpenRate;
	public String evaluation;

	public int getQuestionRate() {
		return questionRate;
	}
	public int getCorrectRate() {
		return correctRate;
	}
	public int getHintOpenRate() {
		return hintOpenRate;
	}
	public String getEvaluation() {
		return evaluation;
	}

}
