package com.test.app.favorite.impl;

import java.util.ArrayList;

import com.test.app.favorite.FavoriteService;
import com.test.app.favorite.FavoriteVO;


public class FavoriteServiceImpl implements FavoriteService {
	
	private FavoriteDAO favoritedao;
	
	@Override
	public void insert_favorite(FavoriteVO vo) {
		// TODO Auto-generated method stub
		favoritedao.insert_favorite(vo);
	}

	@Override
	public void delete_favorite(FavoriteVO vo) {
		// TODO Auto-generated method stub
		favoritedao.delete_favorite(vo);
	}

	@Override
	public ArrayList<FavoriteVO> selectAll_favorite(FavoriteVO vo) {
		// TODO Auto-generated method stub
		return favoritedao.selectAll_favorite(vo);
	}



}
