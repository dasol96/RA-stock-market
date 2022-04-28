package com.test.app.have.impl;

import java.util.ArrayList;

import com.test.app.have.HaveService;
import com.test.app.have.HaveVO;

public class HaveServiceImpl implements HaveService{

	private HaveDAO havedao;
	
	@Override
	public void insert_have(HaveVO vo) {
		// TODO Auto-generated method stub
		havedao.insert_have(vo);
	}

	@Override
	public void delete_have(HaveVO vo) {
		// TODO Auto-generated method stub
		 havedao.delete_have(vo);
	}

	@Override
	public void update1_have(HaveVO vo) {
		// TODO Auto-generated method stub
		havedao.update1_have(vo);
	}

	@Override
	public void update2_have(HaveVO vo) {
		// TODO Auto-generated method stub
		havedao.update2_have(vo);
	}

	@Override
	public HaveVO selectOne(HaveVO vo) {
		// TODO Auto-generated method stub
		return havedao.selectOne(vo);
	}

	@Override
	public ArrayList<HaveVO> selectAll(HaveVO vo) {
		// TODO Auto-generated method stub
		return havedao.selectAll(vo);
	}

}
