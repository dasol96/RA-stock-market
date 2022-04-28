package com.test.app.stock.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.test.app.common.Crawling;
import com.test.app.common.JDBCUtil;
import com.test.app.stock.StockVO;

public class StockDAO {
	   private Connection conn=null;
	   private PreparedStatement pstmt=null;
	   private ResultSet rs=null;
	   
	   private final String insert="insert into stock values((select nvl(max(spk),0)+1 from stock),?,?,?,?,?,?)"; //초기 데이터
	   private final String selectOne="select * from stock where spk=?"; //상세페이지
	   private final String selectOne_crwaling="select * from stock where spk=?"; //상세페이지(새로고침 버튼 누르면 작동)
	   private final String update="update stock set sname=?,snprice=?,sypriceupdown=?,snpercent=?,sntrade=? where spk=?"; // 새로고침키 누르면 크롤링 다시
	   
	   private final String selectAll_sname="select * from stock where sname like '%'||?||'%'"; //검색
	   private final String selectAll="select * from stock"; //모든 게시물 보기

	   private final String update_sstate="update stock set sstate=? where spk=?"; // 즐겨찾기 목록 상태업데이트
	   

	public StockVO selectOne(StockVO vo) {
		StockVO data = null;
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(selectOne);
			pstmt.setInt(1, vo.getSpk());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data = new StockVO();
				data.setSpk(rs.getInt("spk"));
				data.setSname(rs.getString("sname"));
				data.setSnprice(rs.getInt("snprice"));
				data.setSypriceupdown(rs.getInt("sypriceupdown"));
				data.setSnpercent(rs.getDouble("snpercent"));
				data.setSntrade(rs.getInt("sntrade"));
				data.setSstate(rs.getInt("sstate"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return data;
		
	}
	public void insert(ArrayList<StockVO> datas) {
		conn=JDBCUtil.connect();
		Crawling cw = new Crawling();
		cw.startdb();
		try {
			pstmt=conn.prepareStatement(insert);
			for(StockVO svo:datas) {
				pstmt.setString(1, svo.getSname());
				pstmt.setInt(2, svo.getSnprice());
				pstmt.setInt(3, svo.getSypriceupdown());
				pstmt.setDouble(4, svo.getSnpercent());
				pstmt.setInt(5, svo.getSntrade());
				pstmt.setInt(6, svo.getSstate());
				pstmt.executeUpdate();
			}
			System.out.println("로그:Crawling.java DB 저장 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JDBCUtil.disconnect(pstmt, conn);
	}
	
	public StockVO selectOne_crwaling(ArrayList<StockVO> datas) {
		StockVO data = null;
		Crawling cw= new Crawling();
		cw.startdb();  
		conn=JDBCUtil.connect();
		try {
			StockVO vo = new StockVO();
			pstmt.setInt(1, vo.getSpk());
			if(datas.contains(vo.getSname())) { //크롤링한 데이터가 sname을 포함한다면
				pstmt=conn.prepareStatement(update); // 업데이트 진행
				pstmt.setString(1, vo.getSname());
				pstmt.setInt(2, vo.getSnprice());
				pstmt.setInt(3, vo.getSypriceupdown());
				pstmt.setDouble(4, vo.getSnpercent());
				pstmt.setInt(5, vo.getSntrade());
				pstmt.setInt(6, vo.getSpk());
				pstmt.executeUpdate();
				//여기서도 data가 나와야 반환을 하는데...
			}
			 // 아니라면 그냥 selectone 실행할거야(유지)
			pstmt=conn.prepareStatement(selectOne_crwaling);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data = new StockVO();
				data.setSpk(rs.getInt("spk"));
				data.setSname(rs.getString("sname"));
				data.setSnprice(rs.getInt("snprice"));
				data.setSypriceupdown(rs.getInt("sypriceupdown"));
				data.setSnpercent(rs.getDouble("snpercent"));
				data.setSntrade(rs.getInt("sntrade"));
				data.setSstate(rs.getInt("sstate"));
				}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return data;	
	}
	
	public ArrayList<StockVO> selectAll_sname(StockVO vo){
		StockVO data = null;
		ArrayList<StockVO> datas = new ArrayList<StockVO>();
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(selectAll_sname);
			pstmt.setString(1, vo.getSname());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				data = new StockVO();
				data.setSpk(rs.getInt("spk"));
				data.setSname(rs.getString("sname"));
				data.setSnprice(rs.getInt("snprice"));
				data.setSypriceupdown(rs.getInt("sypriceupdown"));
				data.setSnpercent(rs.getDouble("snpercent"));
				data.setSntrade(rs.getInt("sntrade"));
				data.setSstate(rs.getInt("sstate"));
				datas.add(data);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	public ArrayList<StockVO> selectAll(StockVO vo){
		StockVO data = null;
		ArrayList<StockVO> datas = new ArrayList<StockVO>();
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(selectAll);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				data = new StockVO();
				data.setSpk(rs.getInt("spk"));
				data.setSname(rs.getString("sname"));
				data.setSnprice(rs.getInt("snprice"));
				data.setSypriceupdown(rs.getInt("sypriceupdown"));
				data.setSnpercent(rs.getDouble("snpercent"));
				data.setSntrade(rs.getInt("sntrade"));
				data.setSstate(rs.getInt("sstate"));
				datas.add(data);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return datas;
	}
	public boolean update_sstate(StockVO vo){
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(update_sstate);
			pstmt.setInt(1, vo.getSstate());
			pstmt.setInt(2, vo.getSpk());
			pstmt.executeUpdate();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
}

//	public boolean update(StockVO vo) {
//		@Autowired // 의존성 주입(DI)를 위해 @Autowired 추가! >> 크롤링 클래스에는 @Component
//		private Crawling c=null;
//		Data data = c.start();
//		update~
//		//이미 이름이 있으면 update,
//		// 이름이 없으면 변동 없기
//		
//	}
