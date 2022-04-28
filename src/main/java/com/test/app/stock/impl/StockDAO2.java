package com.test.app.stock.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.test.app.common.Crawling;
import com.test.app.stock.StockVO;


public class StockDAO2 {

	private JdbcTemplate jdbcTemplate;

	private final String insert="insert into stock values((select nvl(max(spk),0)+1 from stock),?,?,?,?,?,?,?)"; //초기 데이터
	private final String selectOne="select * from stock where spk=?"; //상세페이지
	private final String update_snprice="update stock set snprice=?,sypriceupdown=?,snpercent=?,snowprice=? where spk=?"; // 새로고침키 누르면 update
	private final String selectAll_sname="select * from stock where sname like '%'||?||'%'"; //검색
	private final String selectAll="select * from stock"; //모든 게시물 보기

	public StockVO selectOne(StockVO vo) {
		Object[] args= {vo.getSpk()};
		System.out.println("로그 : STOCKDAO selectOne 시작");
		return jdbcTemplate.queryForObject(selectOne, args,new StockRowMapper());
	}

	public int checkCrawling(StockVO vo){
		Crawling cw = new Crawling();
		ArrayList<StockVO> datas = cw.startdb();
		for(StockVO v:datas) {
			if(vo.getSname().equals(v.getSname())) {
				vo.setSnowprice(v.getSnprice());
				return v.getSnprice();
			}
		}
		return -1;
	}

	public void update_snprice(StockVO vo) {
		jdbcTemplate.update(update_snprice,vo.getSnowprice(),vo.getSypriceupdown(),vo.getSnpercent(),vo.getSnowprice(),vo.getSpk());
		System.out.println("로그 : STOCKDAO update_snprice 성공");
	}

	public ArrayList<StockVO> selectAll_sname(StockVO vo){
		if(vo.getSearchCondition().equals(null)|| vo.getSearchCondition().equals("")) {
			return (ArrayList<StockVO>) jdbcTemplate.query(selectAll, new StockRowMapper());
		}
		else {
			Object[] args= {vo.getSearchCondition()};
			return (ArrayList<StockVO>) jdbcTemplate.query(selectAll_sname, args ,new StockRowMapper());
		}
	}

	public void insert() {
		Crawling cw = new Crawling();
		ArrayList<StockVO> datas = cw.startdb();
		for(StockVO svo:datas) {
			jdbcTemplate.update(insert,svo.getSname(),svo.getSnprice(),svo.getSnowprice(),svo.getSypriceupdown(),svo.getSnpercent(),svo.getSntrade());
			System.out.println("로그 : StockDAO insert 성공");
		}
	}
	public ArrayList<StockVO> selectAll(StockVO vo){
		return (ArrayList<StockVO>) jdbcTemplate.query(selectAll, new StockRowMapper());

	}

	class StockRowMapper implements RowMapper<StockVO>{

		@Override
		public StockVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			StockVO data = new StockVO();
			data.setSpk(rs.getInt("spk"));
			data.setSname(rs.getString("sname"));
			data.setSnprice(rs.getInt("snprice"));
			data.setSypriceupdown(rs.getInt("sypriceupdown"));
			data.setSnpercent(rs.getDouble("snpercent"));
			data.setSntrade(rs.getInt("sntrade"));
			return data;
		}


	}

}

