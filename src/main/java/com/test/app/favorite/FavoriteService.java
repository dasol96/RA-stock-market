package com.test.app.favorite;

import java.util.ArrayList;

import com.test.app.have.HaveVO;

public interface FavoriteService {
	public void insert_favorite(FavoriteVO vo);
	public void delete_favorite(FavoriteVO vo);
	public ArrayList<FavoriteVO> selectAll_favorite(FavoriteVO vo);
	
}
