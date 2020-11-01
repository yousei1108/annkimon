package service;

import beans.Question;
import dao.QuestionDAOService;
import error.QuestionRegisterError;
import model.StringValidator;

public class QuestionEditor {

	public QuestionRegisterError editQuestion( Question question ) {

		QuestionRegisterError error = new QuestionRegisterError();

		StringValidator validator = new StringValidator(question.getCorrectAnswer() );
		validator.emptyNullCheck();
		error.correctAnswerError = validator.errorMsg;

		validator = new StringValidator( question.getCategory() );
		validator.emptyNullCheck();
		error.categoryError = validator.errorMsg;

		validator = new StringValidator( question.getHint_1() );
		validator.emptyNullCheck();
		error.hintError = validator.errorMsg;

		if( !( error.hasError() ) ) {

			QuestionDAOService daoService = new QuestionDAOService();
			int result = daoService.updateQuestion( question );

			if( result < 1 ) {
				error.executionError = "登録できませんでした<br>再度同じ操作を行って下さい<br>";
			}
		}
		return error;
	}

}
