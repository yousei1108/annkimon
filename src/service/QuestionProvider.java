package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import beans.Question;
import dao.QuestionDAOService;

public class QuestionProvider {

	public List<Question> provideQuestions( String userName , String category , int questionRate ){

		QuestionDAOService daoService = new QuestionDAOService();
		List<Question> questionList = daoService.selectQuestionsByCategory( userName , category );
		int questionNum =  Math.round( questionList.size() * ( float )questionRate / 100 );

		if( questionNum == 0 ) {
			questionNum = 1;
		}

		Collections.shuffle( questionList );

		List<Question> randomQuestions = new ArrayList<Question>();

		if( !( questionList.isEmpty() ) )
			for( int i = 0 ; i < questionNum ; i++ ) {
				randomQuestions.add( questionList.get( i ) );
			}

		return randomQuestions;
	}

}
