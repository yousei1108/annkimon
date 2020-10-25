package test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import entity.AnswerStatus;
import entity.Result;
import service.ResultAnalysis;

class ResultAnalysisTest {

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Nested
	@DisplayName("method : analyzeResult")
	public class TestAnalyzeResult {

		ResultAnalysis analysis = new ResultAnalysis();

		@Test
		@DisplayName("評価がＤになるスコアが入力された場合")
		public void case1() {

			AnswerStatus status = new AnswerStatus();
			status.answerTotal   = 30;
			status.correctTotal  = 5;
			status.hintOpenTotal = 100;
			status.questionTotal = 100;

			Result result = analysis.analyzeResult( status );

			assertThat( result.correctRate ,  is( 17  ) );
			assertThat( result.questionRate , is( 30  ) );
			assertThat( result.hintOpenRate , is( 30  ) );
			assertThat( result.evaluation ,   is( "D" ) );

		}

		@Test
		@DisplayName("評価がＡになるスコアが入力された場合")
		public void case2() {

			AnswerStatus status = new AnswerStatus();
			status.answerTotal   = 30;
			status.correctTotal  = 28;
			status.hintOpenTotal = 30;
			status.questionTotal = 30;

			Result result = analysis.analyzeResult( status );

			assertThat( result.correctRate ,  is( 93  ) );
			assertThat( result.questionRate , is( 100  ) );
			assertThat( result.hintOpenRate , is( 100  ) );
			assertThat( result.evaluation ,   is( "A" ) );

		}

		@Test
		@DisplayName("評価がＳになるスコアが入力された場合")
		public void case3() {

			AnswerStatus status = new AnswerStatus();
			status.answerTotal   = 30;
			status.correctTotal  = 30;
			status.hintOpenTotal = 30;
			status.questionTotal = 30;

			Result result = analysis.analyzeResult( status );

			assertThat( result.correctRate ,  is( 100  ) );
			assertThat( result.questionRate , is( 100  ) );
			assertThat( result.hintOpenRate , is( 100  ) );
			assertThat( result.evaluation ,   is( "S" ) );

		}

	}

}
