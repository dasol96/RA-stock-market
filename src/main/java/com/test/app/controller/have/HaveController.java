package com.test.app.controller.have;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.app.have.HaveVO;
import com.test.app.have.impl.HaveDAO;
import com.test.app.member.MemberVO;
import com.test.app.member.impl.MemberDAO;
import com.test.app.stock.StockVO;
import com.test.app.stock.impl.StockDAO;

@Controller
public class HaveController { //moneykeyword가 안들어옴
	
	@RequestMapping(value="/buyOrSellStock.do") //옵션값이 buy라면
	public String buyStock(HaveVO hvo,HaveDAO havedao,StockVO svo,StockDAO stockdao,MemberVO mvo,MemberDAO memberdao,Model model,HttpSession session) {
		System.out.println();
		System.out.println("로그 : HAVECONTROLLER.DO 실행 moneyCondition = "+hvo.getMoneyCondition());
		System.out.println("로그 : HAVECONTROLLER.DO 실행 moneyKeyword = "+hvo.getMoneykeyword());
		System.out.println("로그 : HAVECONTROLLER.DO 실행 "+hvo.getHpk()+" "+hvo.getMid());
		//hvo=havedao.selectOne(hvo);	//새로 hvo 하면서 moneyCondition이 0으로 바뀜			
		//System.out.println("로그 : HAVECONTROLLER.DO hvo : "+hvo); //// 여기서 null이 뜸
		mvo=memberdao.selectOne(mvo);
		System.out.println("로그 : HAVECONTROLLER.DO mvo : "+mvo);
		svo=stockdao.selectOne(svo);
		System.out.println("로그 : HAVECONTROLLER.DO svo : "+svo);
		System.out.println("로그 : HAVECONTROLLER.DO MoneyCondition : "+hvo.getMoneyCondition());
		
		// 1. moneycondition이 1이라면
		if(hvo.getMoneyCondition()==1) { //매수 // 구매한 금액이 mmoney에서 빠져야함
			if(mvo.getMmoney()>0 && mvo.getMmoney()>hvo.getMoneykeyword()*svo.getSnprice()) { //돈 있을때 거래 가능
			
			System.out.println("로그 : HAVECONTROLLER.DO : MoneyCondition==1 if문으로 들어옴");
			System.out.println("로그 : HAVECONTROLLER.DO if문 안의 hvo,svo : "+hvo.getHpk() +" | "+svo.getSpk());
			
			//ArrayList<HaveVO> datas = havedao.selectAll(hvo); //
			//System.out.println("==============================확인 svo.pk" + svo.getSpk());
			//System.out.println("==============================확인 datas" + datas);
			System.out.println("======전=====hvo.getMoneykeyword확인 = "+hvo.getMoneykeyword());
			int cnt = hvo.getMoneykeyword();
			hvo.setHpk(svo.getSpk());
			hvo.setMid(mvo.getMid());
			System.out.println("=========전 = "+hvo);
			hvo=havedao.selectOne(hvo);
			System.out.println("=========후 = "+hvo);
			System.out.println("======후=====hvo.getMoneykeyword확인 = "+cnt);
			// 이미 데이터가 한번생성된바있어
			// pk를 체크한다 null대신...
			if(hvo.getHpk()!=0) {//만약에 datas에 spk가 있다면   datas.contains(svo.getSpk())
//				System.out.println("=============있는 주식을 살 때 ===============");
//				System.out.println("로그 : HAVECONTROLLER.DO : iO==0 if 안 if문으로 들어옴");
//				System.out.println("로그 : HAVECONTROLLER.DO BUY : 53번쨰 줄 getHscnt = "+hvo.getHscnt());
//				System.out.println("로그 : HAVECONTROLLER.DO BUY : 53번쨰 줄 getHsbuyprice = "+hvo.getHsbuyprice());
//				System.out.println("로그 : HAVECONTROLLER.DO BUY : 53번쨰 줄 getSnprice = "+svo.getSnprice());
//				System.out.println("로그 : HAVECONTROLLER.DO BUY : 53번쨰 줄 getHscnt = "+hvo.getHscnt());
//				System.out.println("로그 : HAVECONTROLLER.DO BUY : 53번쨰 줄 cnt = "+cnt);
				hvo.setHsbuyprice((hvo.getHscnt()*hvo.getHsbuyprice()+cnt*svo.getSnprice())/(hvo.getHscnt()+cnt));
//				System.out.println("로그 : HAVECONTROLLER.DO BUY : 60번쨰 줄 getHsbuyprice = "+hvo.getHsbuyprice());//
				hvo.setHsnowprice(svo.getSnowprice());
				hvo.setHscnt(cnt);
				havedao.update1_have(hvo);
				System.out.println("로그 : HAVECONTROLLER.DO BUY : 64번쨰 줄 hvo = "+hvo);
				System.out.println("로그 : HAVECONTROLLER.DO : update 수행");
				//금액 구하는 식 cnt * price
				int totalMoney = mvo.getMmoney()- (cnt * svo.getSnprice());
				mvo.setMmoney(totalMoney);
				memberdao.update_mmoneyminus_buyOrSell(mvo);
			}
			else {//만약에 datas에 spk가 없다면
				HaveVO hvo1 = new HaveVO();
				System.out.println("☆"+hvo1);
				System.out.println("로그 : HAVECONTROLLER.DO 49번쨰 줄 else문 실행");
				hvo.setMid(mvo.getMid());
				hvo.setHpk(svo.getSpk());
				hvo.setHsname(svo.getSname());
				hvo.setHsbuyprice(svo.getSnprice());
				hvo.setHsnowprice(svo.getSnowprice());
				hvo.setHscnt(cnt);
				System.out.println("로그 : HAVECONTROLLER.DO : hcnt"+cnt);
				System.out.println("로그 : HAVECONTROLLER.DO : hmid"+hvo.getMid());
				System.out.println("로그 : HAVECONTROLLER.DO : mid"+mvo.getMid());
				System.out.println("로그 : HAVECONTROLLER.DO : hpk"+hvo.getHpk());
				System.out.println("로그 : HAVECONTROLLER.DO : spk"+svo.getSpk());
				System.out.println("로그 : HAVECONTROLLER.DO : hsbuyprice"+hvo.getHsbuyprice());
				System.out.println("로그 : HAVECONTROLLER.DO : snpirce"+svo.getSnprice());
				havedao.insert_have(hvo);
				System.out.println("====================로그 :======= HAVECONTROLLER : hvo 확인1 = "+hvo);
				//금액 구하는 식 cnt * price
				System.out.println();
				System.out.println("=======로그 : HAVECONTROLLER.DO : 금액 구하기 시작=======");
				System.out.println("로그 : hvo.getMoneyKeyword = "+cnt);
				System.out.println("로그 : hvo.getHsbuyprice = "+hvo.getHsbuyprice());
				int totalMmoney = mvo.getMmoney()- (cnt*hvo.getHsbuyprice());
				mvo.setMmoney(totalMmoney);
				System.out.println("로그 : HAVECONTROLLER : totlamoney = "+totalMmoney);
				System.out.println("로그 : HAVECONTROLLER : mvo = "+mvo);
				memberdao.update_mmoneyminus_buyOrSell(mvo);
				
			}
			hvo=havedao.selectOne(hvo);
			System.out.println("====================로그 :======= HAVECONTROLLER : hvo 확인2 = "+hvo);
			model.addAttribute("hdata", hvo);
			}
			else {
				System.out.println("돈 없어서 거래 불가능");
				return "mypage.do";
			}
		}
		else {//매도 >> 판매한금액이 mmoney에 추가되어야함
			System.out.println("============================================로그"+hvo.getHscnt());
			if(hvo.getHscnt()>hvo.getMoneykeyword()) { //갯수가 남으면...
				System.out.println("로그 : HAVECONTROLLER : 매도 : hcnt > cnt hvo = "+hvo);
				System.out.println("로그 : HAVECONTROLLER : 매도 : hcnt > cnt Moneykeyword = "+hvo.getMoneykeyword());
				//일단 현재가로 매도 가능하도록 구현
				hvo.setHpk(svo.getSpk());
				hvo.setHsbuyprice(svo.getSnprice());
				hvo.setHsnowprice(svo.getSnowprice());
				
				hvo.setHscnt(hvo.getMoneykeyword());
				System.out.println("로그 : HAVECONTROLLER : hvo set = "+hvo.getHpk()+hvo.getHsnowprice()+hvo.getHscnt());
				havedao.update2_have(hvo);
				//금액 구하는식 cnt * price
				int totalMmoney = mvo.getMmoney()+ (hvo.getMoneykeyword()*hvo.getHsnowprice());
				mvo.setMmoney(totalMmoney);
				memberdao.update_mmoneyminus_buyOrSell(mvo);
			}
			else if(hvo.getHscnt()==hvo.getMoneykeyword()){ // 풀로 다 팔면
				hvo.setHpk(svo.getSpk());
				hvo.setHsbuyprice(svo.getSnprice());
				hvo.setHsnowprice(svo.getSnowprice());
				hvo.setHscnt(hvo.getMoneykeyword());
				havedao.update2_have(hvo);
				//금액 구하는식 cnt * price
				int totalMmoney = mvo.getMmoney()+ (hvo.getMoneykeyword()*hvo.getHsnowprice());
				mvo.setMmoney(totalMmoney);
				memberdao.update_mmoneyminus_buyOrSell(mvo);
				havedao.delete_have(hvo);

			} else {
				System.out.println("팔지 못하는 상태");
			}
		}

		ArrayList<HaveVO> datas = havedao.selectAll(hvo);
		model.addAttribute("hdatas", datas);
		
		mvo = memberdao.selectOne(mvo);
		session.setAttribute("mdata", mvo);
		
		return "mypage.do";
	}
	
	@RequestMapping(value="/hsnowpriceupdate.do") //옵션값이 buy라면
	public String hsnowpriceupdate(HaveVO hvo,HaveDAO havedao,StockVO svo,StockDAO stockdao,MemberVO mvo,MemberDAO memberdao,Model model,HttpSession session) {
		//hpk hsnowprice
		System.out.println("로그 : HaveController : hsnowpriceupdate.do "+ svo.getSpk());
		System.out.println("로그 : HaveController : hsnowpriceupdate.do "+ svo.getSnowprice());
		
		svo=stockdao.selectOne(svo);
		hvo.setHsnowprice(svo.getSnowprice());
		hvo.setHpk(svo.getSpk());
		
		havedao.update_nowprice(hvo);
		
		return "detail.do";
		
	}
	
	
//	@RequestMapping(value="/") // 옵션값이 sell이라면
//	public String sellStock(HaveVO vo,HaveDAO havedao) {
//		
//		havedao.insert_have(vo); //분기처리 vo.getcnt==입력한 값 = update다음 delete vo.getcnt>입력한 값 update
//		return "mypage.jsp";
//	}
//	
//	//내지갑

}
