package com.test.app.stock;

import java.util.ArrayList;

public interface StockService { //변경해야함!!!!
	public StockVO selectOne(StockVO vo);
	public void insert(ArrayList<StockVO> datas);
	public StockVO selectOne_crwaling(ArrayList<StockVO> datas);
	public ArrayList<StockVO> selectAll_sname(StockVO vo);
	public ArrayList<StockVO> selectAll(StockVO vo);
	public void update_sstate(StockVO vo);
	//update delete 새로 만들어야함
}
