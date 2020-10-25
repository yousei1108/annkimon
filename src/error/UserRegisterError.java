package error;

import java.util.ArrayList;
import java.util.List;

public class UserRegisterError implements Error {

	public String nameError = "";
	public String passwordError = "";
	public String executionError = "";

	public boolean hasError() {

		List<String> msgList = new ArrayList<String>();
		msgList.add(nameError);
		msgList.add(passwordError);
		msgList.add(executionError);

		for( String msg : msgList ) {
			if( !(msg.equals("")) ) {
				return true;
			}
		}
		return false;
	}

	public String getNameError() {
		return nameError;
	}

	public String getPasswordError() {
		return passwordError;
	}

	public String getExecutionError() {
		return executionError;
	}
}
