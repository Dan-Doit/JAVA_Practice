package controlleR;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daO.UserInfoBean;
import servicE.AccessService;


@WebServlet("/RegController")
public class RegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RegController() {
        super();

    }

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		UserInfoBean uib = new UserInfoBean();
		
		uib.setUserId(request.getParameter("id"));
		uib.setUserPassword(request.getParameter("pwd1"));
		uib.setUserName(request.getParameter("name"));
		uib.setUserAdd(request.getParameter("add"));
		String phone = request.getParameter("phone");

		if(phone.length()==11) {
			phone = phone.substring(0,3) + "-" + phone.substring(3,7) + "-" + phone.substring(7);
		}
		uib.setUserPhone(phone);
		uib.setUserDate(request.getParameter("date")+"000000");
		
		
		AccessService as = new AccessService();
		if(as.flag(uib, 3)) {
			RequestDispatcher rd = request.getRequestDispatcher("RegUser3.jsp");
			request.setAttribute("requestV", 1);
			request.setAttribute("issucess", "등록성공 다시 로그인해주세요");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("RegUser3.jsp");
			request.setAttribute("requestV", 1);
			request.setAttribute("issucess", "등록실패 다시 등록해주세요");
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
