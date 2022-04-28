package com.test.app.stock.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.stock.StockService;
import com.test.app.stock.StockVO;

@Service("stockService")
public class StockServiceImpl implements StockService{
	
	@Autowired
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
	public void insert() {
		// TODO Auto-generated method stub
		 stockdao.insert();
	}

	@Override
	public void update_snprice(StockVO vo) {
		// TODO Auto-generated method stub
		
	}

//	@Override 업데이트
//	public StockVO selectOne_crwaling() {
//		// TODO Auto-generated method stub
//		return stockdao.selectOne_crwaling();
//	}

	
	//update delete 새로 만들어야함!


}
