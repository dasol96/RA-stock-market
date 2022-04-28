package com.test.app.favorite.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.test.app.common.JDBCUtil;
import com.test.app.favorite.FavoriteVO;
import com.test.app.stock.StockVO;

@Repository("favoritedao")
public class FavoriteDAO {
	   private Connection conn=null;
	   private PreparedStatement pstmt=null;
	   private ResultSet rs=null;
	   
	   private final String insert_favorite="insert into favorite values((select nvl(max(fpk),0)+1 from favorite),?,?)";
	   private final String delete_favorite="delete favorite where spk=?";
	   private final String selectAll_favorite="select * from favorite where fpk=?";
	   private final String selectAll_SF="select stock.* from stock join favorite on stock.spk = favorite.spk where mid=?";
	   //fk에 따른 spk > stock 정보 불러오기 위한 selectAll
	   private final String selectOne="select * from favorite where mid=? and spk=?";
	   
	   public FavoriteVO selectOne(FavoriteVO vo) {
		   FavoriteVO data = null;
		   conn=JDBCUtil.connect();
		   try {
			pstmt=conn.prepareStatement(selectOne);
			pstmt.setString(1, vo.getMid());
			pstmt.setInt(2, vo.getSpk());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				data=new FavoriteVO();
				data.setFpk(rs.getInt("fpk"));
				data.setMid(rs.getString("mid"));
				data.setSpk(rs.getInt("spk"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		   return data;
		   
	   }
	   
	   public ArrayList<StockVO> selectAll_SF(FavoriteVO vo){
		   ArrayList<StockVO> datas = new ArrayList<StockVO>();
		   conn=JDBCUtil.connect();
		   try {
			pstmt=conn.prepareStatement(selectAll_SF);
			pstmt.setString(1, vo.getMid());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				StockVO data = new StockVO();
				data.setSpk(rs.getInt("spk"));
				data.setSname(rs.getString("sname"));
				data.setSnprice(rs.getInt("snprice"));
				data.setSypriceupdown(rs.getInt("sypriceupdown"));
				data.setSnpercent(rs.getDouble("snpercent"));
				data.setSntrade(rs.getInt("sntrade"));
				data.setSstate(rs.getInt("sstate"));
				datas.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		   return datas;
		   
	   }
	   
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
			pstmt=conn.prepareStatement(delete_favorite);
			pstmt.setInt(1, vo.getSpk());
			pstmt.executeUpdate();
			System.out.println("로그 : FAVORITEDAO delete문 실행 : fkp = "+vo.getFpk());
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
