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


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public LoginController() {
        super();
 
    }

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String userId = request.getParameter("id");
		String userPwd = request.getParameter("pwd");
		
		UserInfoBean uib = new UserInfoBean();
		uib.setUserId(userId);
		uib.setUserPassword(userPwd);
		
		AccessService as = new AccessService();
		if(as.flag(uib, 1)) {
			HttpSession ss = request.getSession();
			
			ss.setAttribute("info", uib);
			ss.setAttribute("is", uib.getUserName());
			response.sendRedirect("Main.jsp");
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("LogFail.jsp");
			request.setAttribute("why", "잘좀 입력해봐 제발");
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
