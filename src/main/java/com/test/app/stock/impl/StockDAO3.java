package com.test.app.stock.impl;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.app.common.Crawling;
import com.test.app.stock.StockVO;

@Repository("stockDAO")
public class StockDAO3 {
		
	@Autowired
	private SqlSessionTemplate mybatis; 
	  
	public void insert() {
		Crawling cw = new Crawling();
		ArrayList<StockVO> datas = cw.startdb();
		for(StockVO svo:datas) {
			mybatis.insert("StockDAO.insert",svo);
		}
		System.out.println("로그 : StockDAO insert 성공");
	}
	   
	     
	public StockVO selectOne(StockVO vo) {
		System.out.println("로그 : STOCKDAO selectOne 시작");
		return mybatis.selectOne("StockDAO.selectOne",vo);
	}
	
	public int checkCrawling(StockVO vo){
		System.out.println("로그 : STOCKDAO checkCrawling 에 들어왔다!!!"); // 해당 pk번호로 들어오고..
		Crawling cw = new Crawling();
		ArrayList<StockVO> datas = cw.startdb();
		for(StockVO v:datas) {
			if(vo.getSname().equals(v.getSname())) {
				vo.setSnowprice(v.getSnprice());
				System.out.println("로그 :====== STOCKDAO checkCrawling snowprice = "+vo.getSnowprice());
				return v.getSnprice();
			}
		}
		return -1;
	}
	
	   public void update_snprice(StockVO vo) {
		   mybatis.update("StockDAO.update_snprice",vo);
		   System.out.println("로그 : STOCKDAO update_snprice 성공");
	   }
	   

	public List<StockVO> selectAll_sname(StockVO vo){
			if(vo.getSearchCondition().equals(null)|| vo.getSearchCondition().equals("")) {
				return mybatis.selectList("StockDAO.selectAll",vo);

			}
			else {
				return mybatis.selectList("StockDAO.selectAll_sname", vo);
			}
	}
	
	public List<StockVO> selectAll(StockVO vo){
		return mybatis.selectList("StockDAO.selectAll",vo);
	}
	
	
	
	}

