package com.test.app.member;

public interface MemberService {
	public void insert_member(MemberVO vo);
	public void update_member(MemberVO vo);
	public void delete_member(MemberVO vo);
	public MemberVO selectOne(MemberVO vo);
	public void update_mmoneyplus(MemberVO vo);
	public void update_mmoneyminus(MemberVO vo);
}
