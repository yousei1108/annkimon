package model;

/**
 * 回答に関するデータを保持しておくためのdto
 * @author yousei
 *
 */
public class ResponseData {

	/**
	 * 個々の問題におけるユーザーが入力した解答
	 */
	public String Answer;
	/**
	 * 問題の総数
	 */
	public int questionTotal;
	/**
	 * 問題の解答総数（解答ごとに、カウントアップしていく）
	 */
	public int responseTotal;
	/**
	 * 問題の正解総数
	 */
	public int correctTotal;
	/**
	 * ユーザーがヒントを確認した総数
	 */
	public int hintOpenTotal;
	/**
	 * 個々の問題における、正否
	 */
	public boolean jadge;

	public ResponseData(){

		this.Answer = null;
		this.questionTotal = 0;
		this.responseTotal = 0;
		this.correctTotal = 0;
		this.hintOpenTotal = 0;
		this.jadge = false;

	}

}
