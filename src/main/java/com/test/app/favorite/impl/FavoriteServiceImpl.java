package com.test.app.favorite.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.favorite.FavoriteService;
import com.test.app.favorite.FavoriteVO;
import com.test.app.stock.StockVO;

@Service("favoriteService")
public class FavoriteServiceImpl implements FavoriteService {
	
	@Autowired
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

	@Override
	public ArrayList<StockVO> selectAll_SF(FavoriteVO vo) {
		// TODO Auto-generated method stub
		return favoritedao.selectAll_SF(vo);
	}

	@Override
	public FavoriteVO selectOne(FavoriteVO vo) {
		// TODO Auto-generated method stub
		return favoritedao.selectOne(vo);
	}



}
