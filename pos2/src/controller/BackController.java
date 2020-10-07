package controller;

import java.util.ArrayList;

import data.GoodsInfoBean;
import data.UserInfoBean;
import services.Access;
import services.Sales;

public class BackController {

	private Access ac;
	private Sales ss;
	private String[] userAccess;

	public BackController() {
		ac = new Access();
		ss = new Sales();


	}

	public String[] logIn(String[] userInfo) {		
		UserInfoBean uib = new UserInfoBean();
		uib.setRequestValue(userInfo[0]);   // Client로 부터 전달 받은 userInfo의 값을 UserInfoBean으로 복사
		uib.setEmployeeCode(userInfo[1]);
		uib.setAccessCode(userInfo[2]);

		ac.entrance(uib);

		if (uib.getUserName()!=null) {
			userAccess = new String[4];
			userAccess[0] = uib.getEmployeeCode();
			userAccess[1] = uib.getUserName();
			userAccess[2] = uib.isUserLevel()? "Manager":"Mate";
			userAccess[3] = uib.getAccessTime();

		}else {userAccess = null;
		}
		return userAccess;
	}

	public String[] userRegistration(String[] userInfo) {
		UserInfoBean uib = new UserInfoBean();
		uib.setEmployeeCode(userInfo[0]);
		uib.setAccessCode(userInfo[1]);
		uib.setUserName(userInfo[2]);
		uib.setUserPhone(userInfo[3]);
		uib.setUserLevel(userInfo[4].equals("Manager")?true:false);
		uib.setRequestValue("A2");

		ac.entrance(uib);
		return userAccess;
	}

	public String[] userAccMod(String[] userInfo) {
		UserInfoBean uib = new UserInfoBean();
		uib.setRequestValue(userInfo[0]);   // Client로 부터 전달 받은 userInfo의 값을 UserInfoBean으로 복사
		uib.setEmployeeCode(userInfo[1]);
		uib.setAccessCode(userInfo[2]);

		ac.entrance(uib);

		return userAccess;
	}
	public String[] getGoodsInfo(String goodsCode) {
		String[] goodsInfo = null;
		GoodsInfoBean gib = new GoodsInfoBean();
		// bean 저장
		gib.setGoodsCode(goodsCode);
		ss.entrance(gib);

		// Bean 값 배열로저장
		if(gib.getGoodsName()!=null) {
			goodsInfo = new String[6];
			goodsInfo[0] = gib.getGoodsCode();
			goodsInfo[1] = gib.getGoodsName();
			goodsInfo[2] = gib.getGoodsPrice()+"";
			goodsInfo[3] = gib.getGoodsqty()+"";
			goodsInfo[4] = gib.getExpireDate();
			
		}
		return goodsInfo;
	}
	
	public void stackGoodsInfo(String[][] goodsList) {
		// 리스트배열 선언으로 2차원 배열값 빈에 저장하기
		ArrayList<GoodsInfoBean> goodsStack = new ArrayList<GoodsInfoBean>();
		GoodsInfoBean gib;
		for (int i = 0; i < goodsList.length; i++) {
			gib = new GoodsInfoBean();
			gib.setGoodsCode(goodsList[i][0]);
			gib.setGoodsName(goodsList[i][1]);
			gib.setGoodsPrice(Integer.parseInt(goodsList[i][2]));
			gib.setGoodsqty(Integer.parseInt(goodsList[i][3]));
			gib.setUniqCode(goodsList[i][5]);
			
			goodsStack.add(gib);
		}
		
		ss.entrance(goodsStack);
	}
	


}
