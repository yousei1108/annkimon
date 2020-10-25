package entity;

import java.io.Serializable;

public class AnswerStatus implements Serializable {

	public int questionTotal;
	public int answerTotal;
	public int correctTotal;
	public int hintOpenTotal;

	public void answerStatusUpdate( Answer answer ) {

		if( answer.answerString != null ) {
			answerTotal++;
			hintOpenTotal += answer.hintOpenCount;

			if( answer.correctCheck ) {
				correctTotal++;
			}
		}
	}

}
