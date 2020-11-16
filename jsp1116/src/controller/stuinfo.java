package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import sun.rmi.server.Dispatcher;


@WebServlet({ "/stuinfo", "/stuinfo1" })
public class stuinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public stuinfo() {
    	super();
    }
    
    // processes are here!! 
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		// 이동할 JSP를 설정해 주는 Dispatcher 방식
		RequestDispatcher dispatcher = request.getRequestDispatcher("BackController");
		
		
		String Name = request.getParameter("Name");
    	String id = request.getParameter("id");
    	String sInfo = request.getParameter("sInfo");
    	
    	
		if(id.equals("Dan")){
			Name = "환영합니다.";
		}else{
			Name = "없는아이디입니다.";
		}
		
		// 정보를 저장하는 방법
		// Attribute : String 외 Object, Array등 다양한 데이터 타입 입력가능
		request.setAttribute("Name", Name);
		request.setAttribute("id", id);
		request.setAttribute("sInfo", "임의의값");
		

		// 실제로 jsp로 정보를 담아서 이동하는 구간
		dispatcher.forward(request, response);
		
		
		
		System.out.println(request.getAttribute("Name"));
		System.out.println(request.getAttribute("id"));
		System.out.println(request.getAttribute("sInfo"));
		
		
		

    	PrintWriter out = response.getWriter();
    	
    	

    	// html의 body라고 생각하자
    	
//    	out.println("<h1>학생 정보 받아오기</h1>");
//    	out.println("<h3>결과 : "+Name+"</h3>");
//    	out.println("<h3>아이디 :"+id+"</h3>");
//    	out.close();
    	
    	
	}


    // get
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	}

	// post
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	}

}
