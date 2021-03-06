package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import error.UserRegisterError;
import service.UserRegister;

/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/signup")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp");
		dispatcher.forward( request , response );

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userName = request.getParameter( "userName" );
		String password = request.getParameter( "password" );

		UserRegister register = new UserRegister();
		UserRegisterError error = register.registerUser( userName , password );

		if( error.hasError() ) {
			request.setAttribute( "error" , error );
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp");
			dispatcher.forward( request , response );
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher( "/WEB-INF/jsp/signUpOk.html" );
			dispatcher.forward( request , response );
		}

	}

}
