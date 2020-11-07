package filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Question;

/**
 * Servlet Filter implementation class QuestionListFilter
 */
@WebFilter("/main/answer/question")
public class QuestionListFilter implements Filter {

    /**
     * Default constructor.
     */
    public QuestionListFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		HttpSession session = ((HttpServletRequest)request).getSession();
		List<Question> questionList = ( List<Question> )session.getAttribute( "questionList" );

		if( questionList == null ) {
			( ( HttpServletResponse ) response).sendRedirect("/annkimon/main");
		}else if( questionList.size() == 0 ){
			( ( HttpServletRequest ) request).getRequestDispatcher( "/main/answer/result" ).forward( request , response );
		}else {
			chain.doFilter(request, response);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
