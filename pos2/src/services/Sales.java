package services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import data.DataAccessObject;
import data.GoodsInfoBean;
import data.UserInfoBean;

public class Sales {

	DataAccessObject dao;

	public Sales() {
		dao = new DataAccessObject();
	}
	
	public ArrayList<GoodsInfoBean> entrance(GoodsInfoBean gib,String reqCode) {
		ArrayList<GoodsInfoBean> salesList = null;
		switch (reqCode) {
		case "1":
			// 상품검색
			goodsSearch(gib);
			break;
		case "2":
			// 상품 반품 검색
			salesList = getSalesList(gib);
			break;
			
		case "3":
			// 상품 반품 검색
			cancelOne(gib);
			break;
		}
		return salesList;
	}
	
	public void entrance(ArrayList<GoodsInfoBean> goodsStack,UserInfoBean uib) {

		// 상품판매 정보 저장
		stackSalesInfo(goodsStack,uib);
	}
	
	
	

	private void goodsSearch(GoodsInfoBean gib) {
		dao.setAutoTransaction(false);
		dao.createConnection();
		dao.getGoodsInfo(gib);
	}

	private void stackSalesInfo(ArrayList<GoodsInfoBean> goodsStack, UserInfoBean uib) {
		boolean tran = false;
		dao.createConnection();
		dao.setAutoTransaction(false);
		int count = 0;
		
	
		for(GoodsInfoBean gib : goodsStack) {
			if(dao.stackSalesInfo(gib,count,uib)) {
				tran = true;
			}else{tran=false;
			break;}
			
			count++;
		}
		
		dao.endAutoTransaction(tran);
		
	}
	
	private ArrayList<GoodsInfoBean> getSalesList(GoodsInfoBean gib) {
		dao.createConnection();
		dao.setAutoTransaction(false);
		
		ArrayList<GoodsInfoBean> salesList;
		salesList = dao.getSalesList(gib,2);
		
		return salesList;
	}
	
	private void cancelOne(GoodsInfoBean gib) {
		dao.stackSalesInfo(2, gib);
	}
}
