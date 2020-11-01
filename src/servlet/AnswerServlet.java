package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Question;
import entity.Answer;
import entity.AnswerStatus;
import service.AnswerCheck;

/**
 * Servlet implementation class AnswerServlet
 */
@WebServlet("/main/answer/question")
public class AnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnswerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		@SuppressWarnings("unchecked")
		List<Question> questionlist = ( List<Question> )request.getSession().getAttribute("questionList");
		if( questionlist == null ) {
			response.sendRedirect( "/annkimon/main" );
		}else {
			request.setAttribute( "answerQuestion" , questionlist.get(0) );
			request.getRequestDispatcher("/WEB-INF/jsp/main/Answer.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Answer answer = new Answer();
		answer.answerString = request.getParameter( "answer" );
		answer.hintOpenCount = Integer.parseInt( request.getParameter( "hintOpenCount" ) );

		HttpSession session = request.getSession();
		AnswerStatus status = (AnswerStatus)session.getAttribute( "answerStatus" );

		AnswerCheck check = new AnswerCheck();
		List<Question> questionList = (List<Question>)session.getAttribute( "questionList" );
		Question question = questionList.get( 0 );

		answer = check.checkAnswer( answer , question );

		status.answerStatusUpdate( answer );

		request.setAttribute( "answerQuestion" , question );
		request.setAttribute( "answer" , answer );

		questionList.remove(0);
		if( questionList.size() == 0 ) {
			request.setAttribute( "hasQuestion" , false );
		}else {
			request.setAttribute( "hasQuestion" , true );
			session.setAttribute( "questionList" , questionList );
		}

		request.getRequestDispatcher( "/WEB-INF/jsp/main/correctAnswer.jsp" ).forward(request, response);

	}

}
