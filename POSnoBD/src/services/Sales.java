package services;

import java.util.ArrayList;

import data.DataAccessObject;
import data.GoodsInfoBean;

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
	
	public void entrance(ArrayList<GoodsInfoBean> goodsStack) {
		// 상품판매 정보 저장
		stackSalesInfo(goodsStack);
	}

	private void goodsSearch(GoodsInfoBean gib) {
		dao.getGoodsInfo(3,gib);
	}

	private void stackSalesInfo(ArrayList<GoodsInfoBean> goodsStack) {
		dao.stackSalesInfo(2, goodsStack);
	}
	
	private ArrayList<GoodsInfoBean> getSalesList(GoodsInfoBean gib) {
		ArrayList<GoodsInfoBean> salesList;
		salesList = dao.getSalesList(gib,2);
		
		return salesList;
	}
	
	private void cancelOne(GoodsInfoBean gib) {
		dao.stackSalesInfo(2, gib);
	}
}
