package controlleR;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daO.BoardInfoBean;
import servicE.BoardService;


@WebServlet("/BoardDetailController")
public class BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardDetailController() {
        super();

    }
    
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		BoardInfoBean bib = new BoardInfoBean();
		bib.setBo_Num(Integer.parseInt(request.getParameter("index")));
		bib.setBo_Hits(Integer.parseInt(request.getParameter("hits")));
		int page = Integer.parseInt(request.getParameter("page"));
		
		BoardService bs = new BoardService();
		if(bs.flag(bib, 2)) {
			System.out.println("성공");
			RequestDispatcher rd = request.getRequestDispatcher("SemiBoardDetail.jsp");
			request.setAttribute("page", page);
			request.setAttribute("boinfo", bib);
			rd.forward(request, response);
			
		}else {
			System.out.println("실패");
		}

		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	}

}
