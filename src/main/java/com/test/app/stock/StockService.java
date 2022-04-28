package com.test.app.stock;

import java.util.List;

public interface StockService { //업데이트 버튼 추가
	public void insert();
	public StockVO selectOne(StockVO vo);	
	public List<StockVO> selectAll_sname(StockVO vo);
	public List<StockVO> selectAll(StockVO vo);
	public void update_snprice(StockVO vo);
	public int checkCrawling(StockVO vo);
	
}
