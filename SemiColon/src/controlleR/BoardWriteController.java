package controlleR;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import daO.BoardInfoBean;
import servicE.BoardService;


@WebServlet("/BoardWriteController")
public class BoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardWriteController() {
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
		bib.setBo_Title(multi.getParameter("title"));
		bib.setBo_Content(multi.getParameter("content"));
		bib.setBo_Writer(multi.getParameter("name"));
		bib.setBo_FileName(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		
		
		BoardService bs = new BoardService();
		boolean result = bs.flag(bib,1);
		
		if(result) {
			response.sendRedirect("BoardController");
		} else {
			response.sendRedirect("BoardController");
		}
		
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	


}
