package com.test.app.have.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.test.app.common.JDBCUtil;
import com.test.app.have.HaveVO;

@Repository("havedao")
public class HaveDAO {
	   private Connection conn=null;
	   private PreparedStatement pstmt=null;
	   private ResultSet rs=null;
	   
	   private final String insert_have="insert into have values(?,?,?,?,?,?)"; // 구매시 보유주 추가
	   private final String delete_have="delete have where hpk=?"; // cnt 없을 시 보유주 삭제
	   private final String update1_have="update have set hscnt=hscnt+?,hsbuyprice=? where hpk=?"; // 매수 
	   private final String update2_have="update have set hscnt=hscnt-?,hsnowprice=? where hpk=?"; // 매도
	   private final String update_nowprice="update have set hsnowprice=? where hpk=?"; //업데이트 후 현재가 세팅
	   private final String selectOne_have="select * from have where mid=? and hpk=?";
	   private final String selectAll="select * from have where mid=?";
	   
	   public void update_nowprice(HaveVO vo) {
		   conn=JDBCUtil.connect();
			try {
				pstmt=conn.prepareStatement(update_nowprice);
				pstmt.setInt(1, vo.getHsnowprice());
				pstmt.setInt(2, vo.getHpk());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
	   }
	   
		public void insert_have(HaveVO vo) {
			conn=JDBCUtil.connect();
			try {
				pstmt=conn.prepareStatement(insert_have);
				pstmt.setInt(1, vo.getHpk());
				pstmt.setString(2, vo.getMid());
				pstmt.setString(3, vo.getHsname());
				pstmt.setInt(4, vo.getHscnt()); // 갯수cnt
				pstmt.setInt(5, vo.getHsbuyprice());
				pstmt.setInt(6, vo.getHsnowprice());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
		}
		
		public void delete_have(HaveVO vo) {
			conn=JDBCUtil.connect();
			try {
				pstmt=conn.prepareStatement(delete_have);
				pstmt.setInt(1, vo.getHpk());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
		}
		
		public void update1_have(HaveVO vo) { //매수
			conn=JDBCUtil.connect();
			try {
				pstmt=conn.prepareStatement(update1_have);
				pstmt.setInt(1, vo.getHscnt());
				pstmt.setInt(2, vo.getHsbuyprice());
				pstmt.setInt(3, vo.getHpk());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
		}
		
		public void update2_have(HaveVO vo) { //매도
			conn=JDBCUtil.connect();
			try {
				pstmt=conn.prepareStatement(update2_have);
				pstmt.setInt(1, vo.getHscnt());
				pstmt.setInt(2, vo.getHsnowprice());
				pstmt.setInt(3, vo.getHpk());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
		}
		
		public HaveVO selectOne(HaveVO vo) {
			HaveVO data=new HaveVO();
			conn=JDBCUtil.connect();
			try {
				pstmt=conn.prepareStatement(selectOne_have);
				//System.out.println("로그 : HAVEDAO selectOne 실행 시작 : "+vo.getHpk()+" 2 "+vo.getMid());
				pstmt.setString(1, vo.getMid());
				pstmt.setInt(2, vo.getHpk());
				rs=pstmt.executeQuery();
				if(rs.next()) {
					data.setHpk(rs.getInt("hpk"));
					data.setMid(rs.getString("mid"));
					data.setHsname(rs.getString("hsname"));
					data.setHscnt(rs.getInt("hscnt"));
					data.setHsbuyprice(rs.getInt("hsbuyprice"));
					data.setHsnowprice(rs.getInt("hsnowprice"));
				}
				//System.out.println("로그 : HAVEDAO try문 안 :"+vo.getMid()+" | "+vo.getHpk()+" | "+data.getMid()+" | "+data.getHpk());
				 // 지금 얘가 안뜸
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
			//System.out.println("로그 : HAVEDAO select문 실행끝 : "+vo.getMid()+" | "+vo.getHpk());
			return data;
		}
		public ArrayList<HaveVO> selectAll(HaveVO vo){
			HaveVO data = null;
			ArrayList<HaveVO> datas = new ArrayList<HaveVO>();
			conn=JDBCUtil.connect();
			try {
				pstmt=conn.prepareStatement(selectAll);
				pstmt.setString(1, vo.getMid());
				rs=pstmt.executeQuery();
				while(rs.next()) {
					data=new HaveVO();
					data.setHpk(rs.getInt("hpk"));
					data.setMid(rs.getString("mid"));
					data.setHsname(rs.getString("hsname"));
					data.setHscnt(rs.getInt("hscnt"));
					data.setHsbuyprice(rs.getInt("hsbuyprice"));
					data.setHsnowprice(rs.getInt("hsnowprice"));
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
}
