package services;

import java.util.ArrayList;

import data.DataAccessObject;
import data.GoodsInfoBean;

public class Sales {

	DataAccessObject dao;

	public Sales() {
		dao = new DataAccessObject();

	}


	public void entrance(GoodsInfoBean gib) {
		// 상품검색
		goodsSearch(gib);
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
}
