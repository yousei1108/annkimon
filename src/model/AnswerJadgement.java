package model;

import beans.Question;

/**
 * 回答データを個々の回答毎に更新するクラス
 * @author youse
 *
 */
public class AnswerJadgement {

	/**
	 * 問題、回答データ、ヒント確認数を入力すると、正否の判定やヒント確認数等を回答データに更新し、再度返す
	 * @param question 回答を判定する、個々の問題データ
	 * @param responseData 回答に関するデータ
	 * @param hintOpenCount ユーザーがヒントを確認した数( JavascriptによりhiddenParamを変更し、それを受け取る )
	 * @return 入力された回答データを、回答の状態に応じて更新して返す。
	 */
	public ResponseData answerJadge( Question question , ResponseData responseData , int hintOpenCount ) {

		responseData.responseTotal++;
		responseData.hintOpenTotal += hintOpenCount;

		if( question.getAnswer().equals( responseData.Answer ) ) {

			responseData.correctTotal++;
			responseData.jadge = true;

		}else {

			responseData.jadge = false;

		}

		return responseData;

	}

}
