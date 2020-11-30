package utilL;

import java.io.IOException;
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


@WebFilter("/LoginFilter2")
public class LoginFilter2 implements Filter {


    public LoginFilter2() {
      
    }

	public void destroy() {
		System.out.println("destory호출");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
	throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpSession session = req.getSession();
		
		String ID = (String) session.getAttribute("ID");
		
		if(ID==null) {
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendRedirect("Login.jsp");
			
		}
		
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init호출");
	}

}
