package com.test.app.common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import com.test.app.stock.StockVO;



public class Crawling_update {
	Connection conn;
	PreparedStatement pstmt;
	final String sql="update stock set sname=?,snprice=?,sypriceupdown=?,snpercent=?,sntrade=? where spk=?";

	public void startdb() {
		conn=JDBCUtil.connect();
		final String url = "https://finance.naver.com/sise/field_submit.naver?menu=quant&returnUrl=http%3A%2F%2Ffinance.naver.com%2Fsise%2Fsise_quant.naver&fieldIds=quant&fieldIds=open_val&fieldIds=prev_quant\\r\\n";
		ArrayList<StockVO> datas = new ArrayList<StockVO>();
		Document doc = null;
		try {
			doc=Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Elements eles=doc.select("tbody>tr"); 
		Iterator<Element> itr2=eles.select("a").iterator();
		Iterator<Element> itr3=eles.select("td.number").iterator();
		StockVO svo = new StockVO();
		while(itr3.hasNext()) {
			
			String n = itr2.next().text();
			svo.setSname(n);//종목명
			int a = Integer.parseInt(itr3.next().text().replace(",", "").replace("%","").replace("+", ""));
			svo.setSnprice(a);//현재가
			int b = Integer.parseInt(itr3.next().text().replace(",", "").replace("%","").replace("+", ""));
			svo.setSypriceupdown(b); //전일비
			double c = Double.parseDouble(itr3.next().text().replace(",", "").replace("%","").replace("+", ""));
			svo.setSnpercent(c); // 등락률
			int d = Integer.parseInt(itr3.next().text().replace(",", "").replace("%","").replace("+", ""));
			svo.setSntrade(d);
			svo.setSstate(0);
			int e = Integer.parseInt(itr3.next().text().replace(",", "").replace("%","").replace("+", ""));
			System.out.println("현재가 :"+a);
			System.out.println("전일비 :"+b);
			System.out.println("등락률 :"+c);
			System.out.println("거래량 :"+d);
			System.out.println("매도호가 :"+e);
			datas.add(svo);
		}
		System.out.println("크롤링 성공!");
		
		try {
			if(svo.getSname().equals("현재 DB에 있는 sname")) {
				pstmt=conn.prepareStatement(sql);
				for(StockVO vo:datas) {
					pstmt.setString(1, vo.getSname());
					pstmt.setInt(2, vo.getSnprice());
					pstmt.setInt(3, vo.getSypriceupdown());
					pstmt.setDouble(4, vo.getSnpercent());
					pstmt.setInt(5, vo.getSntrade());
					pstmt.setInt(6, vo.getSstate());
					pstmt.executeUpdate();
				}
				System.out.println("로그:Crawling_update 성공");
			}
			System.out.println("로그:Crawling_update 하지않음");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}

	}




}
