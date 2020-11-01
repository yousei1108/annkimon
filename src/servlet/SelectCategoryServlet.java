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
import dao.QuestionDAOService;
import entity.AnswerStatus;
import service.QuestionProvider;

/**
 * Servlet implementation class SelectCategoryServlet
 */
@WebServlet("/main/answer")
public class SelectCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		QuestionDAOService service = new QuestionDAOService();
		List<Question> questionList = service.selectQuestions( (String)request.getSession().getAttribute("userName") );
		if( questionList.isEmpty() ) {
			request.getRequestDispatcher("/WEB-INF/jsp/main/questionEmpty.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/jsp/main/selectCategory.jsp").forward(request, response);
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		session.removeAttribute( "questionList" );
		session.removeAttribute( "answerStatus" );

		String userName = (String)session.getAttribute("userName");
		String category = request.getParameter("category");
		int questionRate =  Integer.parseInt( request.getParameter("questionRate") );

		QuestionProvider provider = new QuestionProvider();
		List<Question> questionList = provider.provideQuestions(userName, category, questionRate);

		session.setAttribute( "questionList" , questionList );

		QuestionDAOService service = new QuestionDAOService();

		AnswerStatus status = new AnswerStatus();
		status.questionTotal = service.selectQuestionsByCategory( userName , category ).size();

		session.setAttribute( "answerStatus" , status );

		System.out.println("こっち");
		response.sendRedirect("/annkimon/main/answer/question");

	}

}
