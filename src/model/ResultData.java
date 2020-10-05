package model;

public class ResultData {

	/**
	 * 問題の出題率
	 */
	public int questionRate;
	/**
	 * 問題の正解率
	 */
	public int corecctRate;
	/**
	 * 問題のヒント確認した率( 暗記度 )
	 */
	public int hintOpenRate;

	/**
	 * 結果データのオブジェクトを生成する際に、それぞれのフィールドを引数の問題データによって計算する
	 * @param responseData 全ての回答が終了した時点での、問題のデータ
	 */
	public ResultData( ResponseData responseData ) {

		questionRate = (int)Math.round( responseData.responseTotal / responseData.questionTotal );
		corecctRate  = (int)Math.round( responseData.correctTotal  / responseData.responseTotal );
		hintOpenRate = (int)Math.round( responseData.responseTotal / responseData.hintOpenTotal );

	}

}
