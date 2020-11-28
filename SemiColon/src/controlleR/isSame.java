package controlleR;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daO.UserInfoBean;
import servicE.AccessService;

@WebServlet("/isSame")
public class isSame extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public isSame() {
        super();
   
    }
    
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String userId = request.getParameter("id");
		
		UserInfoBean uib = new UserInfoBean();
		uib.setUserId(userId);
		
		AccessService as = new AccessService();
		

		
		if(as.flag(uib, 2)) {
			RequestDispatcher rd = request.getRequestDispatcher("RegUser2.jsp");
			request.setAttribute("is", "true");
			request.setAttribute("id", userId);
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("RegUser1-1.jsp");
			request.setAttribute("is", "false");
			rd.forward(request, response);
			
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
