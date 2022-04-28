package com.test.app.have.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.test.app.common.JDBCUtil;
import com.test.app.have.HaveVO;

public class HaveDAO {
	   private Connection conn=null;
	   private PreparedStatement pstmt=null;
	   private ResultSet rs=null;
	   
	   private final String insert_have="insert into have value(?,?,?,?,?,?)";
	   private final String delete_have="delete have where hpk=?";
	   private final String update1_have="update have hscnt=hscnt+?,hsbuyprice=? where hpk=?";
	   //있는 주식을 구매했을때 cnt 증가, phnprice 도 평균가로 조정
	   private final String update2_have="update have hscnt=hscnt-?,hsbuyprice=? where hpk=?";
	   //있는 주식에서 일부만 판매했을때
	   private final String selectOne_have="select * from have where hmid=?";
	   private final String selectAll="select * from have where hmid=?";
	   
	   
	   
		public void insert_have(HaveVO vo) {
			conn=JDBCUtil.connect();
			try {
				pstmt=conn.prepareStatement(insert_have);
				pstmt.setInt(1, vo.getHpk());
				pstmt.setString(2, vo.getHmid());
				pstmt.setString(3, vo.getHsname());
				pstmt.setInt(4, vo.getHscnt());
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
		
		public void update1_have(HaveVO vo) {
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
		
		public void update2_have(HaveVO vo) {
			conn=JDBCUtil.connect();
			try {
				pstmt=conn.prepareStatement(update2_have);
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
		
		public HaveVO selectOne(HaveVO vo) {
			HaveVO data = null;
			conn=JDBCUtil.connect();
			try {
				pstmt=conn.prepareStatement(selectOne_have);
				pstmt.setString(1, vo.getHmid());
				rs=pstmt.executeQuery();
				if(rs.next()) {
					data=new HaveVO();
					data.setHpk(rs.getInt("hpk"));
					data.setHmid(rs.getString("hmid"));
					data.setHsname(rs.getString("hsname"));
					data.setHscnt(rs.getInt("hscnt"));
					data.setHsbuyprice(rs.getInt("hsbuyprice"));
					data.setHsnowprice(rs.getInt("hsnowprice"));
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
			return data;
			
		}
		public ArrayList<HaveVO> selectAll(HaveVO vo){
			HaveVO data = null;
			ArrayList<HaveVO> datas = new ArrayList<HaveVO>();
			conn=JDBCUtil.connect();
			try {
				pstmt=conn.prepareStatement(selectAll);
				pstmt.setString(1, vo.getHmid());
				rs=pstmt.executeQuery();
				while(rs.next()) {
					data=new HaveVO();
					data.setHpk(rs.getInt("hpk"));
					data.setHmid(rs.getString("hmid"));
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
