package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join")
public class Start extends HttpServlet {
	
	private String add;
	
	private static final long serialVersionUID = 1L;

    public Start() {
        super();

    }
    // process
	protected String doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String sName = request.getParameter("sName");
    	String sid = request.getParameter("sid");
    	
		if(sid.equals("Dan")){
			sName = "환영합니다.";
		}else{
			sName = "없는아이디입니다.";
		}
		
		System.out.println("sName : " + sName);
		System.out.println("sid : " + sid);
		add = sName;
		
		return sName;
    	
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		
		add = doProcess(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("doPost");
		add = doProcess(request, response);
		System.out.println(add);
		// html 출력문
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.print("1234");
		pw.print(add);
		pw.close();
	}

}
