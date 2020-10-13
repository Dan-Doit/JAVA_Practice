package services;

import java.util.ArrayList;

import data.DataAccessObject;
import data.GoodsInfoBean;

public class Managements {

	DataAccessObject dao;

	public Managements() {
		dao = new DataAccessObject();
	}

	public ArrayList<GoodsInfoBean> entrance(int reqValue, GoodsInfoBean gib) {
		ArrayList<GoodsInfoBean> goOut = null;
		switch (reqValue) {
		case 1:
			goodsReg(gib);
			break;

		case 2:
			goodsPriceMod(gib);;
			break;


		case 3:
			goOut = getDailySales(gib);;
			break;
		}
		
		return goOut;
	}


	private void goodsReg(GoodsInfoBean gib) {
		dao.goodsReg(3, gib);
	}


	private void goodsPriceMod(GoodsInfoBean gib) {
		ArrayList<GoodsInfoBean> goodsList;

		goodsList = dao.goodsGetAll(3);

		for (int i = 0; i < goodsList.size(); i++) {
			if(goodsList.get(i).getGoodsCode().equals(gib.getGoodsCode())) {
				goodsList.get(i).setGoodsPrice(gib.getGoodsPrice());
				break;
			}
		}
		dao.goodsPriceMod(3, goodsList);
	}
	
	private ArrayList<GoodsInfoBean> getDailySales(GoodsInfoBean gib) {

		ArrayList<GoodsInfoBean> goOut;
		goOut = dao.goodsGetHis(2,gib);
		
		return goOut;
	}

























}
