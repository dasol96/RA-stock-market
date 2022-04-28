package com.test.app.favorite.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.test.app.common.JDBCUtil;
import com.test.app.favorite.FavoriteVO;

public class FavoriteDAO {
	   private Connection conn=null;
	   private PreparedStatement pstmt=null;
	   private ResultSet rs=null;
	   
	   private final String insert_favorite="insert into favorite value((select nvl(max(fpk),0)+1 from favorite),?,?)";
	   private final String delete_favorite="delete favorite where fpk=?";
	   private final String selectAll_favorite="select * from favorite where fpk=?";
	   
	   
	public void insert_favorite(FavoriteVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(insert_favorite);
			pstmt.setInt(1, vo.getSpk());
			pstmt.setString(2, vo.getMid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	
	}
	public void delete_favorite(FavoriteVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(insert_favorite);
			pstmt.setInt(1, vo.getFpk());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}
	public ArrayList<FavoriteVO> selectAll_favorite(FavoriteVO vo){
		FavoriteVO data = null;
		ArrayList<FavoriteVO> datas = new ArrayList<FavoriteVO>();
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(selectAll_favorite);
			pstmt.setInt(1, vo.getFpk());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				data = new FavoriteVO();
				data.setFpk(rs.getInt("fpk"));
				data.setMid(rs.getString("mid"));
				data.setSpk(rs.getInt("spk"));
				datas.add(data);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return datas;
	}
}
