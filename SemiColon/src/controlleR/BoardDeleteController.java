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


@WebServlet("/BoardDeleteController")
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BoardDeleteController() {
        super();
     
    }
    
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		BoardInfoBean bib = new BoardInfoBean();
		bib.setBo_Userid(request.getParameter("id"));
		bib.setBo_Num(Integer.parseInt(request.getParameter("num")));
		int page = Integer.parseInt(request.getParameter("page"));
		
		BoardService bs = new BoardService();
		if(bs.flag(bib, 4)) {
			RequestDispatcher rd = request.getRequestDispatcher("RegUser3.jsp");
			request.setAttribute("page", page);
			request.setAttribute("requestV", 3);
			request.setAttribute("issucess", "성공적으로 삭제되었습니다.");
			rd.forward(request, response);
			
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("RegUser3.jsp");
			request.setAttribute("page", page);
			request.setAttribute("requestV", 3);
			request.setAttribute("issucess", "삭제가 실패되었습니다.");
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
