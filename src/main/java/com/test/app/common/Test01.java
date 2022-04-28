package com.test.app.common;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Test01 {
	public static void main(String[] args) {


		final String url = "https://finance.naver.com/sise/field_submit.naver?menu=quant&returnUrl=http%3A%2F%2Ffinance.naver.com%2Fsise%2Fsise_quant.naver&fieldIds=quant&fieldIds=open_val&fieldIds=prev_quant\\r\\n";
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Elements eles=doc.select("tbody>tr"); 
		Iterator<Element> itr2=eles.select("a").iterator();
		Iterator<Element> itr3=eles.select("td.number").iterator();

		while(itr3.hasNext()) {
			String n = itr2.next().text();
			int a = Integer.parseInt(itr3.next().text().replace(",", "").replace("%","").replace("+", ""));
			int b = Integer.parseInt(itr3.next().text().replace(",", "").replace("%","").replace("+", ""));
			double c = Double.parseDouble(itr3.next().text().replace(",", "").replace("%","").replace("+", ""));
			int d = Integer.parseInt(itr3.next().text().replace(",", "").replace("%","").replace("+", ""));
			int e = Integer.parseInt(itr3.next().text().replace(",", "").replace("%","").replace("+", ""));
			System.out.println("현재가 :"+a);
			System.out.println("전일비 :"+b);
			System.out.println("등락률 :"+c);
			System.out.println("거래량 :"+d);
			System.out.println("매도호가 :"+e);
		}
		
	
		
		
		
	}
}
