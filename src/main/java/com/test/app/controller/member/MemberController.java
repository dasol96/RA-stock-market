package com.test.app.controller.member;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.app.have.HaveService;
import com.test.app.have.HaveVO;
import com.test.app.member.MemberService;
import com.test.app.member.MemberVO;
import com.test.app.stock.StockVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private HaveService haveService;
	
	@RequestMapping(value="/signinlang.do")
	public String loginlang() {
		System.out.println("로그 : MEMBERCONTROLLER 다국어 처리 들어옴");
			return "signin.jsp";

	}

	@RequestMapping(value="/login.do")
	public String login(MemberVO vo,HttpSession session) {
		vo=memberService.selectOne2(vo);
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
	public String insertMember(MemberVO vo) {
		memberService.insert_member(vo);
		System.out.println("로그 : MemberController : 회원가입 성공!"+vo);
		return "signinlang.do";
	}
	
	@RequestMapping(value="/deleteMember.do")
	public String deleteMember(MemberVO vo,HttpSession session,HaveVO hvo) {
		//hvo=havedao.selectOne(hvo);
		hvo.setMid(vo.getMid());
		ArrayList<HaveVO> datas = haveService.selectAll(hvo); //mid 필요
		vo=memberService.selectOne(vo);
		System.out.println("로그 : MEMBERCONTROLLER delete.do hvo datas 확인 = "+datas); 
		System.out.println("로그 : MEMBERCONTROLLER delete.do mvo 확인 = "+vo); // 보유 금액으로도 필터링 해야함 
		
		if(datas.size()!=0|| vo.getMmoney()!=0) {//주식이 있거나 mmoney가 있을때
			System.out.println("탈퇴 불가");
			return "main.do";
		}
		else {
			memberService.delete_member(vo);
		session.invalidate();
		return "redirect:main.do";
		}
	}
	
	@RequestMapping(value="/setting.do")
	public String setting(MemberVO vo,Model model) {
		System.out.println("로그 : MemberController : setting.do 실행 vo="+vo+vo.getMid());
		vo=memberService.selectOne(vo);
		model.addAttribute("mdata", vo);
		System.out.println("로그 : MemberController : setting.do update vo = "+vo);
		return "setting.jsp";
	}
	
	@RequestMapping(value="/updateMember.do")
	public String update(MemberVO vo) {
		System.out.println("로그 : MemberController : setting.do 실행");
		memberService.update_member(vo);
		System.out.println("로그 : MemberController : setting.do update vo = "+vo);
		return "setting.do";
	}
	
	@RequestMapping(value="/takeMoney.do") //분리
	public String takeMoney(MemberVO vo, HttpSession session) {
		System.out.println("로그 : MemberController takeMoney"+vo.getMid()+vo.getInOrOutMoney()+vo.getInOrOut());
		if(vo.getInOrOut()==2) { // 인출
			if(vo.getMmoney()>=vo.getInOrOutMoney()) {
				memberService.update_mmoneyminus(vo);
				vo=memberService.selectOne(vo);
				session.setAttribute("mdata", vo);
			}
			else {
				System.out.println("인출 불가한상태");
			}
		}
		else { //입금인 경우
			System.out.println("로그 : MemberController takeM 입금 성공");
			memberService.update_mmoneyplus(vo);
			vo=memberService.selectOne(vo);
			session.setAttribute("mdata", vo);
		}
		return "mypage.do";
	}
	
	@RequestMapping(value="/mypage.do")
	public String mypage(MemberVO vo,HaveVO hvo,Model model,HttpSession session,StockVO svo) {
		System.out.println("로그 : MemberController : mypage.do"+vo.getMid());
		hvo.setMid(vo.getMid());
		hvo.setHsnowprice(svo.getSnowprice());
		haveService.update_nowprice(hvo);
		ArrayList<HaveVO> datas=haveService.selectAll(hvo);

		model.addAttribute("hdatas", datas);
		return "mypage.jsp";
	}
	
	
	
}
