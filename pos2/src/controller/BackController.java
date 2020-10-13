package controller;

import java.util.ArrayList;

import data.GoodsInfoBean;
import data.UserInfoBean;
import services.Access;
import services.Managements;
import services.Sales;

public class BackController {

	private Access ac;
	private Sales ss;
	private Managements mg;
	private String[] userAccess;

	public BackController() {
		ac = new Access();
		ss = new Sales();
		mg = new Managements();


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
		ss.entrance(gib,"1");

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
	

	public String[][] searchOrder(String ordCode) {
		GoodsInfoBean gib = new GoodsInfoBean();
		ArrayList<GoodsInfoBean> salesList;

		gib.setUniqCode(ordCode);
		salesList = ss.entrance(gib,"2");
		String[][] arrSalesList = new String[salesList.size()][4];
		
		if(salesList!=null) {
		for (int i = 0; i < salesList.size(); i++) {
			arrSalesList [i][0]= salesList.get(i).getGoodsCode();
			arrSalesList [i][1]= salesList.get(i).getGoodsName();
			arrSalesList [i][2]= salesList.get(i).getGoodsPrice()+"";
			arrSalesList [i][3]= salesList.get(i).getGoodsqty()+"";
		}    
		}
		return arrSalesList;
	}
	
	public void cancelInfo(String ordCode, String[][] cancelList) {
		ArrayList<GoodsInfoBean> arrCancelList = new ArrayList<GoodsInfoBean>();
		GoodsInfoBean gib;
		
		for (int i = 0; i < cancelList.length; i++) {
			gib = new GoodsInfoBean();
			gib.setGoodsCode(cancelList[i][0]);
			gib.setGoodsName(cancelList[i][1]);
			gib.setGoodsPrice(Integer.parseInt(cancelList[i][2]));
			gib.setGoodsqty(Integer.parseInt(cancelList[i][3]));
			gib.setUniqCode(ordCode);
			
			arrCancelList.add(gib);
		}
		
		ss.entrance(arrCancelList);
		
	}
	
	public void cancelInfo(String ordCode, String[] cancelGoods) {
		
		GoodsInfoBean gib;
		
			gib = new GoodsInfoBean();
			gib.setGoodsCode(cancelGoods[0]);
			gib.setGoodsName(cancelGoods[1]);
			gib.setGoodsPrice(Integer.parseInt(cancelGoods[2]));
			gib.setGoodsqty(-1);
			gib.setUniqCode(ordCode);
		
		ss.entrance(gib,"3");
		
	}
	public void goodsReg(String[] goodsInfo) {
		GoodsInfoBean gib =  new GoodsInfoBean();
		
		gib.setGoodsCode(goodsInfo[0]);
		gib.setGoodsName(goodsInfo[1]);
		gib.setGoodsPrice(Integer.parseInt(goodsInfo[2]));
		gib.setExpireDate(goodsInfo[3]);
		gib.setGoodsqty(Integer.parseInt(goodsInfo[4]));
		gib.setSafetyQty(goodsInfo[5]);
		
		mg.entrance(1, gib);
	}
	
	public void goodsPriceMod(String[] goodsInfo) {
		GoodsInfoBean gib = new GoodsInfoBean();
		gib.setGoodsCode(goodsInfo[0]);
		gib.setGoodsPrice(Integer.parseInt(goodsInfo[1]));
		
		mg.entrance(2, gib);

	}
	// 일별 매출 현황 정보 가져오기
	public String[][] getDailySales(String days) {
		ArrayList<GoodsInfoBean> goOut;
		GoodsInfoBean gib = new GoodsInfoBean();
		gib.setUniqCode(days);
		int count = 0;
		
		goOut = mg.entrance(3, gib);
		String[][] dailyList = new String[goOut.size()][4];

		for (GoodsInfoBean i : goOut) {
			dailyList[count][0] = i.getGoodsCode();
			dailyList[count][1] = i.getGoodsName();
			dailyList[count][2] = i.getGoodsPrice()+"";
			dailyList[count][3] = i.getGoodsqty()+"";
			count++;
		}
		return dailyList;
	}
	
	
	
	
}
