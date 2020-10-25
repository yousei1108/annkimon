package test;

import model.StringFormatter;

public class LoginTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		StringFormatter formatter = new StringFormatter();

		System.out.println( formatter.toHash( "password" ) );

	}

}
