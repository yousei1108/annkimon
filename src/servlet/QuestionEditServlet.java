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
import error.QuestionRegisterError;
import service.QuestionEditor;

/**
 * Servlet implementation class QuestionEditServlet
 */
@WebServlet("/main/question/edit")
public class QuestionEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Question question = new Question();
		question.setUserName( (String)request.getSession().getAttribute( "userName" ) );
		question.setCategory( request.getParameter( "category" ) );
		question.setCorrectAnswer( request.getParameter("correctAnswer") );
		question.addHint_1( request.getParameter( "hint_1" ) );
		question.addHint_2( request.getParameter( "hint_2" ) );
		question.addHint_3( request.getParameter( "hint_3" ) );
		question.setId( Integer.parseInt( request.getParameter( "id" ) ) );

		QuestionRegisterError error = new QuestionRegisterError();
		QuestionEditor editor = new QuestionEditor();
		error = editor.editQuestion( question );

		if( error.hasError() ) {
			request.setAttribute( "error" , error );
			QuestionDAOService service = new QuestionDAOService();
			int questionId = Integer.parseInt( request.getParameter( "id" ));

			List<Question> questionList = service.selectQuestionsById( questionId );

			request.setAttribute( "selectQuestion" , questionList.get(0) );
			request.getRequestDispatcher( "/WEB-INF/jsp/main/questionEdit.jsp" ).forward(request, response);
		}else {
			request.setAttribute( "question" , question );
			request.getRequestDispatcher( "/WEB-INF/jsp/main/questionRegisterOk.jsp" ).forward(request, response);
		}

	}

}
