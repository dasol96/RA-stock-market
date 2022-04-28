package com.test.app.member.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.member.MemberService;
import com.test.app.member.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Autowired //DI 타겟 클래스에도 Repository 
	private MemberDAO memberdao;
	
	// select -> selectOne(MemeberVO), selectList(List<MemberVO>)
	// update -> void, boolean
	// insert -> void, boolean
	// delete -> void, boolean
	
	@Override
	public void insert_member(MemberVO vo) {
		memberdao.insert_member(vo);
	}

	@Override
	public void update_member(MemberVO vo) {
		// TODO Auto-generated method stub
		memberdao.update_member(vo);
	}

	@Override
	public void delete_member(MemberVO vo) {
		// TODO Auto-generated method stub
		memberdao.delete_member(vo);
	}

	@Override
	public MemberVO selectOne(MemberVO vo) {
		// TODO Auto-generated method stub
		return memberdao.selectOne(vo);
	}

	@Override
	public void update_mmoneyplus(MemberVO vo) {
		// TODO Auto-generated method stub
		memberdao.update_mmoneyplus(vo);
	}

	@Override
	public void update_mmoneyminus(MemberVO vo) {
		// TODO Auto-generated method stub
		memberdao.update_mmoneyminus(vo);
	}

	@Override
	public MemberVO selectOne2(MemberVO vo) {
		// TODO Auto-generated method stub
		return memberdao.selectOne2(vo);
	}

	@Override
	public void update_mmoneyminus_buyOrSell(MemberVO mvo) {
		memberdao.update_mmoneyminus_buyOrSell(mvo);
		
	}

}
