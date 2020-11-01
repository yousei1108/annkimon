package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Question;
import dao.QuestionDAOService;

/**
 * Servlet implementation class QuestionChooseServlet
 */
@WebServlet("/main/question/select")
public class QuestionSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionSelectServlet() {
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
		request.setAttribute( "questionList" , questionList );

		request.getRequestDispatcher("/WEB-INF/jsp/main/questionSelect.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		QuestionDAOService service = new QuestionDAOService();
		int questionId = Integer.parseInt( request.getParameter( "questionId" ));

		List<Question> questionList = service.selectQuestionsById( questionId );

		if( questionList.isEmpty() ) {
			request.getRequestDispatcher("/WEB-INF/jsp/main/questionSelect.jsp").forward(request, response);
		}else {
			request.setAttribute( "selectQuestion" , questionList.get(0) );
			request.getRequestDispatcher("/WEB-INF/jsp/main/questionEdit.jsp").forward(request, response);
		}

	}

}
