package services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import data.DataAccessObject;
import data.UserInfoBean;

public class Access {

	private DataAccessObject dao; 

	public Access() {
		dao = new DataAccessObject();
	}

	public void entrance(UserInfoBean uib) {
		switch (uib.getRequestValue()) {
		case "A1":
			logIn(uib);
			break;
		case "A2":
			userReg(uib);
			break;
		case "A3":
			userMod(uib);
			break;
		}


	}

	private void logIn(UserInfoBean uib) {

		if (dao.isEmployee(0, uib)) {	
			if (dao.isAccess(0, uib)) {
				Date now = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
				uib.setAccessTime(sdf.format(now));

				dao.getUserInfo(0, uib);
				dao.setLogInInfo(1, uib);
				// 필요없는데이터 삭제
				uib.setRequestValue(null);
				uib.setAccessCode(null);				
			}
		}
		// 로그인 성공 --> 
		// parameter로 전달받은 uib에 저장
		// 저장값  7777,훈짱,M, 20200924180000
	}
	private void userReg(UserInfoBean uib) {

		dao.setUserReg(0, uib);
	}

	private void userMod(UserInfoBean uib) {
		// 빈 리스트값 수정하기
		ArrayList<UserInfoBean> al ;
		al = dao.getUserInfoMod(0);
		
		for (int i = 0; i < al.size(); i++) {
			if(uib.getEmployeeCode().equals(al.get(i).getEmployeeCode())) {
				al.get(i).setAccessCode(uib.getAccessCode());
				break;
			}
			
		}
		// 수정하는 매서드 호출
		dao.setUserInfoMod(0, al);
	}

}
