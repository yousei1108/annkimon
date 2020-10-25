package service;

import entity.AnswerStatus;
import entity.Result;

public class ResultAnalysis {

	public Result analyzeResult( AnswerStatus status ) {

		Result result = new Result();

		result.questionRate = Math.round( (float)status.answerTotal   / status.questionTotal * 100 );
		result.correctRate  = Math.round( (float)status.correctTotal  / status.answerTotal   * 100 );
		result.hintOpenRate = Math.round( (float)status.answerTotal / status.hintOpenTotal   * 100 );

		int evaluationScore = ( result.questionRate + result.correctRate + result.hintOpenRate ) / 3;

		if     ( evaluationScore == 100 ) { result.evaluation = "S"; }
		else if( evaluationScore >  80  ) { result.evaluation = "A"; }
		else if( evaluationScore >  50  ) { result.evaluation = "B"; }
		else if( evaluationScore >  30  ) { result.evaluation = "C"; }
		else                              { result.evaluation = "D"; }

		return result;
	}

}
