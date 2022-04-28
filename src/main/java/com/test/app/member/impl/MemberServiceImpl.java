package com.test.app.member.impl;

import java.sql.SQLException;

import com.test.app.member.MemberService;
import com.test.app.member.MemberVO;

public class MemberServiceImpl implements MemberService{
	
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

}
