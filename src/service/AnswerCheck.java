package service;

import beans.Question;
import entity.Answer;
import model.StringFormatter;

public class AnswerCheck {

	public Answer checkAnswer( Answer answer , Question question ) {


		String answerString  = answer.answerString;
		String correctAnswer = question.getCorrectAnswer();

		StringFormatter formatter = new StringFormatter();

		answerString = formatter.removeSpace( answerString );
		answerString = formatter.toHalfAlpha( answerString );
		answerString = answerString.toUpperCase();
		correctAnswer = formatter.removeSpace( correctAnswer );
		correctAnswer = formatter.toHalfAlpha( correctAnswer );
		correctAnswer = correctAnswer.toUpperCase();

		if( answerString.equals( correctAnswer ) ) {
			answer.correctCheck = true;
		}

		return answer;

	}

}
