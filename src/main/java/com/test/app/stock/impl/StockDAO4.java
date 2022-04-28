package com.test.app.stock.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.test.app.common.Crawling;
import com.test.app.stock.StockVO;


public class StockDAO4 {

	@PersistenceContext
	private EntityManager em;

	public StockVO selectOne(StockVO vo) {
		System.out.println("로그 : STOCKDAO selectOne 시작");
		return em.find(StockVO.class,vo.getSpk());
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
		em.merge(vo);
		System.out.println("로그 : STOCKDAO update_snprice 성공");
	}
	
	public List<StockVO> selectAll(StockVO vo){
		return em.createQuery("from StockVO s order by s.spk desc").getResultList();
	}

	
	public void insert() {
		Crawling cw = new Crawling();
		ArrayList<StockVO> datas = cw.startdb();
		for(StockVO svo:datas) {
			em.persist(svo);
		}
	}


	public List<StockVO> selectAll_sname(StockVO vo){
		if(vo.getSearchCondition().equals(null)|| vo.getSearchCondition().equals("")) {
			return em.createQuery("from StockVO s order by s.spk desc").getResultList();

		}
		else {
			//"select * from stock where sname like '%'||?||'%'";
			List<StockVO> query =  (List<StockVO>) em.createQuery("select s from Stock as s where sname like %:sc%").getResultList();
			((Query) query).setParameter("sc", vo.getSearchCondition());
			return query;
		}
	}


	


}

