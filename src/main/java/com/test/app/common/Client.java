package com.test.app.common;

import java.util.ArrayList;

import com.test.app.stock.StockVO;
import com.test.app.stock.impl.StockDAO;

public class Client {
	public static void main(String[] args) {
		StockDAO stockDAO = new StockDAO();
		ArrayList<StockVO> datas = new Crawling().startdb();
		stockDAO.insert(datas);
	}
}
