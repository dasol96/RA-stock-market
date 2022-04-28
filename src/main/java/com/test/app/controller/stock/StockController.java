package com.test.app.controller.stock;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.app.common.Crawling;
import com.test.app.favorite.FavoriteService;
import com.test.app.favorite.FavoriteVO;
import com.test.app.have.HaveService;
import com.test.app.have.HaveVO;
import com.test.app.stock.StockService;
import com.test.app.stock.StockVO;
import com.test.app.stock.impl.StockDAO;


@Controller
public class StockController {
	
	@Autowired
	private StockService stockService;
	@Autowired
	private FavoriteService favoriteService;
	@Autowired
	private HaveService haveService;
	
	@RequestMapping(value="/data.do")
	public String Alldata(StockVO vo,StockDAO stockdao) { 
		//stockdao.insert();
		return "main.do";
	}	
	
	@RequestMapping(value="/main.do")
	public String selectAll(StockVO vo,FavoriteVO fvo,Model model, HttpSession session) { 
		//System.out.println("로그 : StockController main.do | fvo 확인 : " + fvo);
//		fvo=favoritedao.selectOne(fvo);
//		System.out.println("로그 : STOCKCONTROLLER main.do fvo확인 = "+fvo);
		if(fvo.getMid()!=null) {
		//System.out.println("로그 : StockController main.do | if문 안에 들어옴");
		ArrayList<StockVO> datas2 = favoriteService.selectAll_SF(fvo);
		//System.out.println("로그 : StockController main.do | if문 안 datas2 = "+datas2);
		model.addAttribute("fdatas", datas2);
		}
		
		List<StockVO> datas = stockService.selectAll(vo);
		model.addAttribute("sdatas", datas);
		
		return "main.jsp";
	}
	
	@RequestMapping(value="/detail.do")
	public String selectOne(StockVO vo,Model model,HaveVO hvo) {
		//System.out.println("======================로그 : STOCKCONTROLLER : detail.do svo1 = "+vo);
		vo = stockService.selectOne(vo);
		//System.out.println("======================로그 : STOCKCONTROLLER : detail.do svo2 = "+vo);
		model.addAttribute("sdata", vo);
		System.out.println("로그 : STOCKCONTROLLER : mid = "+hvo.getMid());
		System.out.println("로그 : STOCKCONTROLLER : spk = "+vo.getSpk());
		hvo.setHpk(vo.getSpk());
		hvo.setHsnowprice(vo.getSnowprice());
		//System.out.println("===========로그 : STOCKCONTROLLER : detail.do svo.nprice = "+vo.getSnowprice());
		//System.out.println("===========로그 : STOCKCONTROLLER : detail.do hvo.nprice = "+hvo.getHsnowprice());
		hvo = haveService.selectOne(hvo);
		//System.out.println("로그 : STOCKCONTROLLER : detail.do hvo = "+hvo );
		//System.out.println("로그 : STOCKCONTROLLER : detail.do hvo.getHcnt = "+hvo.getHscnt() );
		model.addAttribute("hdata",hvo);
		
		return "detail.jsp";
	}
	
	@RequestMapping(value="/search.do")
	public String search(StockVO vo,Model model,HttpServletResponse response) throws IOException {
		if(vo.getSearchCondition().equals(null)||vo.getSearchCondition().equals("")) {
			List<StockVO> datas = stockService.selectAll(vo);
			//System.out.println("로그 : STOCKCONTROLLER : search.do null이여서 if문 안으로 들어옴");
			return "main.do";
		}
		List<StockVO> datas = stockService.selectAll_sname(vo);
		//System.out.println("로그 : STOCKCONTROLLER : search.do datas = "+datas);
		if(datas==null) { //stockDAO null로 수정해놨음 ArrayList datas = null로,,,
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('검색 결과가 없습니다.'); location.href='main.do';</script>");
			out.flush();
		}
		//System.out.println("로그 : STOCKCONTROLLER : search.do searchCondition = "+vo.getSearchCondition());
		//System.out.println("로그 SC:검색"+datas);
		model.addAttribute("sdatas", datas);
		return "search.jsp";

	}
	
	@RequestMapping(value="/updatecrw.do")
	public String update(StockVO vo,Model model,Crawling cw) {
		System.out.println("로그 : STOCKCONTROLLER : updatecrw 실행 시작★");
		vo=stockService.selectOne(vo);
		//System.out.println("로그 : STOCKCONTROLLER : updatecrw : selectone실행한 vo = "+vo);
		int result=stockService.checkCrawling(vo);
		//System.out.println("로그 : STOCKCONTROLLER : checkCrawling 실행 result = "+result);
		if(result>=0) {
			vo.setSnprice(result);
			stockService.update_snprice(vo);
			//System.out.println("로그 : STOCKCONTROLLER : updatecrw : update실행한 vo = "+vo);
		}	
		
		return "hsnowpriceupdate.do";
	}

	
	
	
	
}
