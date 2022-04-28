package com.test.app.have;

import java.util.ArrayList;

public interface HaveService {
	public void insert_have(HaveVO vo);
	public void delete_have(HaveVO vo);
	public void update1_have(HaveVO vo);
	public void update2_have(HaveVO vo);
	public HaveVO selectOne(HaveVO vo);
	public ArrayList<HaveVO> selectAll(HaveVO vo);
}
