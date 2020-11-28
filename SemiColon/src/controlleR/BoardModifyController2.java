package controlleR;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import daO.BoardInfoBean;
import daO.PageInfoBean;
import servicE.BoardService;


@WebServlet("/BoardModifyController2")
public class BoardModifyController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BoardModifyController2() {
        super();
     
    }
    
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		// 파일업로드 설정부분
		int size = 10 * 1024 * 1024;
		String savePath = "C:/Users/zmffh/OneDrive/Desktop/JAVA/SemiColon/WebContent/FileUpload";
		MultipartRequest multi = new MultipartRequest(request,savePath,size,"UTF-8",new DefaultFileRenamePolicy());
		
		BoardInfoBean bib = new BoardInfoBean();


		bib.setBo_Userid(multi.getParameter("id"));
		bib.setBo_Num(Integer.parseInt(multi.getParameter("num")));
		bib.setBo_Title(multi.getParameter("title"));
		bib.setBo_Content(multi.getParameter("content"));
		bib.setBo_Writer(multi.getParameter("name"));
		bib.setBo_FileName(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		
		
		BoardService bs = new BoardService();
		
		
		if(bs.flag(bib,3)) {
			RequestDispatcher rd = request.getRequestDispatcher("RegUser3.jsp");
			request.setAttribute("requestV", 2);
			request.setAttribute("issucess", "수정에 성공하였습니다.");
			request.setAttribute("index", bib.getBo_Num());
			request.setAttribute("hits", multi.getParameter("hits"));
			request.setAttribute("page", multi.getParameter("page"));
			rd.forward(request, response);
	
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("RegUser3.jsp");
			request.setAttribute("requestV", 2);
			request.setAttribute("issucess", "수정에 실패하였습니다.");
			request.setAttribute("index", bib.getBo_Num());
			request.setAttribute("hits", multi.getParameter("hits"));
			request.setAttribute("page", multi.getParameter("page"));
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
