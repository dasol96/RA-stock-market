package com.test.app.controller.member;

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
public class MemberController {
	
	//private MemberService memberService;
	//private HaveService haveService;
	
	@RequestMapping(value="/signinlang.do")
	public String loginlang() {
		System.out.println("로그 : MEMBERCONTROLLER 다국어 처리 들어옴");
			return "signin.jsp";

	}
	
	
	@RequestMapping(value="/login.do")
	public String login(MemberVO vo,MemberDAO memberdao,HttpSession session) {
		vo=memberdao.selectOne2(vo);
		if(vo==null) {
			System.out.println("로그 : MemberController : login 정보"+vo);
			return "redirect:signin.jsp";
		}
		else {
		session.setAttribute("mdata", vo);
		return "main.do";
		}
	}
	
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:main.do";
	}
	
	@RequestMapping(value="/insertMember.do")
	public String insertMember(MemberVO vo,MemberDAO memberdao) {
		memberdao.insert_member(vo);
		System.out.println("로그 : MemberController : 회원가입 성공!"+vo);
		return "signinlang.do";
	}
	
	@RequestMapping(value="/deleteMember.do")
	public String deleteMember(MemberVO vo,MemberDAO memberdao,HttpSession session,HaveVO hvo,HaveDAO havedao) {
		//hvo=havedao.selectOne(hvo);
		hvo.setMid(vo.getMid());
		ArrayList<HaveVO> datas = havedao.selectAll(hvo); //mid 필요
		vo=memberdao.selectOne(vo);
		System.out.println("로그 : MEMBERCONTROLLER delete.do hvo datas 확인 = "+datas); 
		System.out.println("로그 : MEMBERCONTROLLER delete.do mvo 확인 = "+vo); // 보유 금액으로도 필터링 해야함 
		
		if(datas.size()!=0|| vo.getMmoney()!=0) {//주식이 있거나 mmoney가 있을때
			System.out.println("탈퇴 불가");
			return "main.do";
		}
		else {
		memberdao.delete_member(vo);
		session.invalidate();
		return "redirect:main.do";
		}
	}
	
	@RequestMapping(value="/setting.do")
	public String setting(MemberVO vo,MemberDAO memberdao,Model model) {
		System.out.println("로그 : MemberController : setting.do 실행 vo="+vo+vo.getMid());
		vo=memberdao.selectOne(vo);
		model.addAttribute("mdata", vo);
		System.out.println("로그 : MemberController : setting.do update vo = "+vo);
		return "setting.jsp";
	}
	
	@RequestMapping(value="/updateMember.do")
	public String update(MemberVO vo,MemberDAO memberdao) {
		System.out.println("로그 : MemberController : setting.do 실행");
		memberdao.update_member(vo);
		System.out.println("로그 : MemberController : setting.do update vo = "+vo);
		return "setting.do";
	}
	
	@RequestMapping(value="/takeMoney.do") //분리
	public String takeMoney(MemberVO vo,MemberDAO memberdao, HttpSession session) {
		System.out.println("로그 : MemberController takeMoney"+vo.getMid()+vo.getInOrOutMoney()+vo.getInOrOut());
		if(vo.getInOrOut()==2) { // 인출
			if(vo.getMmoney()>=vo.getInOrOutMoney()) {
				memberdao.update_mmoneyminus(vo);
				vo=memberdao.selectOne(vo);
				session.setAttribute("mdata", vo);
			}
			else {
				System.out.println("인출 불가한상태");
			}
		}
		else { //입금인 경우
			System.out.println("로그 : MemberController takeM 입금 성공");
			memberdao.update_mmoneyplus(vo);
			vo=memberdao.selectOne(vo);
			session.setAttribute("mdata", vo);
		}
		return "mypage.do";
	}
	
	@RequestMapping(value="/mypage.do")
	public String mypage(MemberVO vo,MemberDAO memberdao,HaveVO hvo,HaveDAO havedao,Model model,HttpSession session,StockVO svo,StockDAO stockdao) {
		System.out.println("로그 : MemberController : mypage.do"+vo.getMid());
		hvo.setMid(vo.getMid());
		System.out.println("로그 : MemberController : mypage.do"+vo);
		System.out.println("로그 : MemberController : mypage.do"+hvo);
		//hvo.setHsnowprice(svo.getSnowprice());
		//hvo=havedao.selectOne(hvo);
		
		//
		hvo.setHsnowprice(svo.getSnowprice());
		havedao.update_nowprice(hvo);
		ArrayList<HaveVO> datas=havedao.selectAll(hvo);
		
		
		model.addAttribute("hdatas", datas);
		return "mypage.jsp";
	}
	
	
	
}
