package utilL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controlleR.LoginController;


@WebFilter("/LoginFilter")

public class LoginFilter implements Filter {

	// 화이트 리스트 생성
	private List<String> whiteList;
	private List<String> sResourceList;

	public LoginFilter() {
		// 화이트 리스트 등록
		whiteList = new ArrayList<String>();
		whiteList.add("/Login.jsp");
		whiteList.add("/LoginController");
		whiteList.add("RegUser.jsp");
		whiteList.add("RegUser1-1.jsp");
		whiteList.add("RegUser2.jsp");
		whiteList.add("RegUser3.jsp");
		whiteList.add("RegController");
		whiteList.add("isSame");

		/* URL방식
		 * Port 번호가 필수적으로 붙어야함 만약 붙지 않는다면 기본 Port이다.
		 * https://host:Port/information
		 * http: 80 port    https: 443 port
		 * 
		 * URI 방식
		 * https://host:Port/여기서부터 URI
		 * 이 경우에는 페이지의 정보만 알면된다.
		 * */
		sResourceList = new ArrayList<String>();
		sResourceList.add("/resource");

	}


	public void destroy() {

	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("인잇 호출");
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest rqs = (HttpServletRequest) request;
		HttpServletResponse rsp = (HttpServletResponse) response;

		// 화이트리스트 uri 호출
		String uri = rqs.getRequestURI();
		// 비교장치
		boolean isAccess = true;
		for(int i = 0; i < whiteList.size();i++) {
		if (uri.contains(whiteList.get(i))) {
				isAccess = false;
			}
		}


			//			boolean isResource = false;
			//
			//			for(String i : sResourceList) {
			//				if(uri.startsWith(i)) {
			//					isResource = true;
			//					break;
			//				}	
			//			}
			//
			//			if(isResource) {
			
			if(isAccess) {
				
				// uri가 같지않으면 들어옴
				HttpSession ss = rqs.getSession();
				String member = (String)ss.getAttribute("is");
				System.out.println(member);
				
				if(member==null) {			
					RequestDispatcher rd = rqs.getRequestDispatcher("RegUser3.jsp");
					rqs.setAttribute("requestV", 1);
					rqs.setAttribute("issucess", "로그인이 필요합니다.");
					rd.forward(rqs, rsp);		

			}
		}


		chain.doFilter(request, response);
		
	}



}
