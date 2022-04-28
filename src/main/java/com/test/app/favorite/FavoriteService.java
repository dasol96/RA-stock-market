package com.test.app.favorite;

import java.util.ArrayList;


import com.test.app.stock.StockVO;

public interface FavoriteService {
	public FavoriteVO selectOne(FavoriteVO vo);
	public ArrayList<StockVO> selectAll_SF(FavoriteVO vo);
	public void insert_favorite(FavoriteVO vo);
	public void delete_favorite(FavoriteVO vo);
	public ArrayList<FavoriteVO> selectAll_favorite(FavoriteVO vo);
}
