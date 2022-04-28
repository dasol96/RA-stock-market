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



public class Crawling {
	Connection conn;
	PreparedStatement pstmt;
	final String sql="insert into stock values((select nvl(max(spk),0)+1 from stock),?,?,?,?,?,?,?)";

	public ArrayList<StockVO> startdb() {
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
		StockVO svo = null;
		while(itr3.hasNext()) {
			svo = new StockVO();
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
			datas.add(svo);
		}
		return datas;
		
		
	}
	 }
