package com.simplilearn.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter("/hello")
public class AuthFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthFilter() {    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("Destroy filter");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		response.setContentType("text/html");
		if(email.equals("admin@gmail.com")) {
			if(password.equals("password123")){					
				chain.doFilter(request, response);
			} 
		}else {
			response.getWriter().println("<h2>User Not Found !</h2> <p> looking for default user admin@gmail.com </p>");
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {	}

}
