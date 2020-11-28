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


@WebServlet("/BoardController")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BoardController() {
        super();
     
    }
    
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int page = 1;
		int limit = 5;
		
		if(request.getParameter("page")!=null&&request.getParameter("page")!="") {
			page = Integer.parseInt(request.getParameter("page"));
		}

		

		
		//  컬럼 번호 설정
		PageInfoBean pig = new PageInfoBean();
		pig.setStartRow((page-1)*limit+1); 
		pig.setEndRow(page*limit);
		
		ArrayList<BoardInfoBean> boardList = new ArrayList<BoardInfoBean>();
		
		BoardService bs = new BoardService();
		bs.flag(boardList, pig,1);
		
		System.out.println(boardList.size()+"개 리스트 추출");
		
		// 글개수 가져오기
		int Count = pig.getCount();
		
		// 한페이지에 최대로 보여줄수있는 페이지
		int maxPage = (int)(((double)Count/limit)+0.9);
		
		// 현재 페이지에서 보여줄 시작페이지
		int startPage = (((int)((double)page/10 + 0.9))-1) * 5 +1;
		
		// 현재 페이지에서 보여줄 끝페이지
		int endPage = startPage+5-1;
		// MaxPage가 EndPage보다 클경우
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		pig.setPage(page);
		pig.setMaxPage(maxPage);
		pig.setStartPage(startPage);
		pig.setEndPage(endPage);

		
		RequestDispatcher rd = request.getRequestDispatcher("SemiBoard.jsp");
		request.setAttribute("boardList",boardList);
		request.setAttribute("pig", pig);
		rd.forward(request, response);
	
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doProcess(request, response);
		
	}

}
