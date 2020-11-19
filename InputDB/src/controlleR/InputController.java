package controlleR;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dtO.Inputback;


@WebServlet("/Inputdb")
public class InputController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public InputController() {
        super();

    }
    
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String id = request.getParameter("data1");
		String pwd = request.getParameter("data2");
		
		Inputback ib = new Inputback();
		
		String[] info = ib.input(id, pwd);
		
		RequestDispatcher rd = request.getRequestDispatcher("output.jsp");
		
		request.setAttribute("info", info);
		
		rd.forward(request, response);
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	}

}
