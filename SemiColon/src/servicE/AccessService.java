package servicE;

import daO.UserInfoBean;

import static utilL.JdbcUtil.*;

import java.sql.Connection;

import daO.DataAccessObject;

public class AccessService {
	
	Connection con;
	DataAccessObject dao;
	
	
	public AccessService() {
		
		con = getConnection();
		dao = DataAccessObject.getInstance();
		dao.setConnection(con);
		
	}
	
	
	public boolean flag(UserInfoBean uib ,int request) {
		boolean result = false;
		
		switch (request) {
		case 1:
			result = isAccess(uib);
			break;
		case 2:
			result = isSame(uib);
			break;
		case 3:
			result = regUser(uib);
			break;

		default:
			System.out.println("무었을원하시죠?");
			break;
		}
		
		return result;
	}
	
	
	private boolean isAccess(UserInfoBean uib) {
		
		boolean result = false;
		

		
		if(dao.isAccess(uib)) {
			System.out.println("로그인 성공");
			result = true;
		}else {
			System.out.println("로그인 실패");
		}
		close(con);
		
		return result;
	}
	
	
	private boolean isSame(UserInfoBean uib) {
		
		boolean result = false;
		
		if(dao.isSame(uib)) {
			System.out.println("중복값 없음");
			result = true;
		}else {
			System.out.println("중복값 있음");
		}
		close(con);
		
		return result;
	}
	
	
	private boolean regUser(UserInfoBean uib) {
		
		boolean result = false;
		
		if(dao.regUser(uib)) {
			commit(con);
			System.out.println("등록성공");
			result = true;
		}else {
			rollback(con);
			System.out.println("등록실패");
		}
		
		close(con);
		
		return result;
	}
	


}
