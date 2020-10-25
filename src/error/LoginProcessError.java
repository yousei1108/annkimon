package error;

import java.util.ArrayList;
import java.util.List;

public class LoginProcessError implements Error {

	public String loginError = "";

	@Override
	public boolean hasError() {

		List<String> msgList = new ArrayList<String>();
		msgList.add( loginError );

		for( String msg : msgList ) {
			if( !(msg.equals("")) ) {
				return true;
			}
		}
		return false;

	}

	public String getLoginError() {
		return loginError;
	}

}
