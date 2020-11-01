package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Question;
import error.QuestionRegisterError;
import service.QuestionRegister;

/**
 * Servlet implementation class QuestionRegisterServlet
 */
@WebServlet("/main/question/register")
public class QuestionRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		request.getRequestDispatcher( "/WEB-INF/jsp/main/questionRegister.jsp" ).forward( request , response );

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

		QuestionRegisterError error = new QuestionRegisterError();
		QuestionRegister register = new QuestionRegister();
		error = register.registerQuestion( question );

		if( error.hasError() ) {
			request.setAttribute( "error" , error );
			request.getRequestDispatcher( "/WEB-INF/jsp/main/questionRegister.jsp" ).forward(request, response);
		}else {
			request.setAttribute( "question" , question );
			request.getRequestDispatcher( "/WEB-INF/jsp/main/questionRegisterOk.jsp" ).forward(request, response);
		}

	}

}
