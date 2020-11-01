package service;

import entity.AnswerStatus;
import entity.Result;

public class ResultAnalysis {

	public Result analyzeResult( AnswerStatus status ) {

		Result result = new Result();

		result.questionRate = Math.round( (float)status.answerTotal  / status.questionTotal   * 100 );
		result.correctRate  = Math.round( (float)status.correctTotal  / status.answerTotal   * 100 );
		result.hintOpenRate = Math.round( (float)status.answerTotal / status.hintOpenTotal   * 100 );

		int evaluationScore = result.questionRate * result.correctRate * result.hintOpenRate;

		if     ( evaluationScore == 1000000 ) { result.evaluation = "S"; }
		else if( evaluationScore >  700000  ) { result.evaluation = "A"; }
		else if( evaluationScore >  600000  ) { result.evaluation = "B"; }
		else if( evaluationScore >  300000  ) { result.evaluation = "C"; }
		else                              { result.evaluation = "D"; }

		return result;
	}

}
