package error;

import java.util.ArrayList;
import java.util.List;

public class QuestionRegisterError implements Error {

	public String correctAnswerError = "";
	public String categoryError = "";
	public String hintError = "";
	public String executionError = "";

	public boolean hasError() {

		List<String> msgList = new ArrayList<String>();
		msgList.add( correctAnswerError );
		msgList.add( categoryError );
		msgList.add( hintError );
		msgList.add( executionError );

		for( String msg : msgList ) {
			if( !(msg.equals("")) ) {
				return true;
			}
		}
		return false;
	}

	public String getCorrectAnswerError() {
		return correctAnswerError;
	}

	public String getCategoryError() {
		return categoryError;
	}

	public String getHintError() {
		return hintError;
	}

	public String getExecutionError() {
		return executionError;
	}

}
