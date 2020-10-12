package services;

import java.util.ArrayList;

import data.DataAccessObject;
import data.GoodsInfoBean;

public class Managements {

	DataAccessObject dao;

	public Managements() {
		dao = new DataAccessObject();
	}

	public void entrance(int reqValue, GoodsInfoBean gib) {
		switch (reqValue) {
		case 1:
			goodsReg(gib);
			break;

		case 2:
			goodsPriceMod(gib);;
			break;
		}
	}


	private void goodsReg(GoodsInfoBean gib) {
		dao.goodsReg(3, gib);
	}

	private void goodsPriceMod(GoodsInfoBean gib) {
		ArrayList<GoodsInfoBean> goodsList;
		String goodsCode;
		int goodsPrice;
		goodsCode = gib.getGoodsCode();
		goodsPrice = gib.getGoodsPrice();

		goodsList = dao.goodsGetAll(3, gib);

		for (int i = 0; i < goodsList.size(); i++) {
			if(goodsList.get(i).getGoodsCode().equals(goodsCode)) {
				goodsList.get(i).setGoodsPrice(goodsPrice);
				break;
			}
		}
		dao.goodsPriceMod(3, goodsList);
	}


}
