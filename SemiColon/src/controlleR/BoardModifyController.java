package controlleR;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daO.BoardInfoBean;
import daO.PageInfoBean;
import servicE.BoardService;


@WebServlet("/BoardModifyController")
public class BoardModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BoardModifyController() {
        super();
     
    }
    
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		RequestDispatcher rd = request.getRequestDispatcher("SemiBoardModify.jsp");
		request.setAttribute("num", Integer.parseInt(request.getParameter("num")));
		request.setAttribute("title", request.getParameter("title"));
		request.setAttribute("content", request.getParameter("content"));
		request.setAttribute("hits", request.getParameter("hits"));
		request.setAttribute("page", request.getParameter("page"));
		rd.forward(request, response);
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doProcess(request, response);
		
	}

}
