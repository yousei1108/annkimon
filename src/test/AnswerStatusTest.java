package test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import entity.Answer;
import entity.AnswerStatus;

class AnswerStatusTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}


	@Nested
	@DisplayName( "method : answerStatusUpdate" )
	public class AnswerStatusUpdate{

		public Answer answer = new Answer();
		public AnswerStatus status = new AnswerStatus();


		@Test
		@DisplayName( "問題に正解した場合のテストケース" )
		public void case1() {

			status.hintOpenTotal = 5;
			status.correctTotal  = 3;
			status.answerTotal   = 4;

			answer.correctCheck = true;
			answer.hintOpenCount = 2;
			answer.answerString = "test";

			status.answerStatusUpdate( answer );

			assertThat( status.answerTotal , is( 5 ) );
			assertThat( status.correctTotal , is( 4 ) );
			assertThat( status.hintOpenTotal , is( 7 ) );

		}

		@Test
		@DisplayName( "問題が不正解だった場合のテストケース" )
		public void case2() {

			status.hintOpenTotal = 7;
			status.correctTotal  = 6;
			status.answerTotal   = 6;

			answer.correctCheck  = false;
			answer.hintOpenCount = 1;
			answer.answerString  = "test";

			status.answerStatusUpdate( answer );

			assertThat( status.answerTotal , is( 7 ) );
			assertThat( status.correctTotal , is( 6 ) );
			assertThat( status.hintOpenTotal , is( 8 ));

		}

	}

}
