package com.test.app.stock.impl;

import java.util.ArrayList;

import com.test.app.stock.StockService;
import com.test.app.stock.StockVO;

public class StockServiceImpl implements StockService{

	private StockDAO stockdao;	
	
	@Override
	public StockVO selectOne(StockVO vo) {
		// TODO Auto-generated method stub
		return stockdao.selectOne(vo);
	}

	@Override
	public ArrayList<StockVO> selectAll_sname(StockVO vo) {
		// TODO Auto-generated method stub
		return stockdao.selectAll_sname(vo);
	}

	@Override
	public ArrayList<StockVO> selectAll(StockVO vo) {
		// TODO Auto-generated method stub
		return stockdao.selectAll(vo);
	}

	@Override
	public void update_sstate(StockVO vo) {
		// TODO Auto-generated method stub
		stockdao.update_sstate(vo);
	}

	@Override
	public void insert(ArrayList<StockVO> datas) {
		// TODO Auto-generated method stub
		stockdao.insert(datas);
	}

	@Override
	public StockVO selectOne_crwaling(ArrayList<StockVO> datas) {
		// TODO Auto-generated method stub
		return stockdao.selectOne_crwaling(datas);
	}

	
	//update delete 새로 만들어야함!


}
