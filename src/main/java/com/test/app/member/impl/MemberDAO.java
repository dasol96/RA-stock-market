package com.test.app.member.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.test.app.common.JDBCUtil;
import com.test.app.member.MemberVO;

public class MemberDAO {
	   private Connection conn=null;
	   private PreparedStatement pstmt=null;
	   private ResultSet rs=null;
	   private final String insert_member="insert into member values(?,?,?,?,?,?)";
	   private final String update_member="update member mname=?,mpassword=?,maccount=?,mphone=? where mid=?";
	   private final String delete_member="delete member where mid=?";
	   private final String selectOne_member="select * from member where mid=?";
	   private final String update_mmoneyplus="update member mmoney=mmoney+? where mid=?";
	   private final String update_mmoneyminus="update member mmoney=mmoney-? where mid=?";
	   
	   
		public void insert_member(MemberVO vo) {
			conn=JDBCUtil.connect();
			try {
				pstmt=conn.prepareStatement(insert_member);
				pstmt.setString(1, vo.getMid());
				pstmt.setString(2, vo.getMname());
				pstmt.setString(3, vo.getMpassword());
				pstmt.setInt(4, vo.getMmoney());
				pstmt.setString(5, vo.getMaccount());
				pstmt.setString(6, vo.getMphone());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
		}
		
		public void update_member(MemberVO vo) {
			conn=JDBCUtil.connect();
			try {
				pstmt=conn.prepareStatement(update_member);
				pstmt.setString(1, vo.getMname());
				pstmt.setString(2, vo.getMpassword());
				pstmt.setString(3, vo.getMaccount());
				pstmt.setString(4, vo.getMphone());
				pstmt.setString(5, vo.getMid());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
		}
		
		public void delete_member(MemberVO vo) {
			conn=JDBCUtil.connect();
			try {
				pstmt=conn.prepareStatement(update_member);
				pstmt.setString(1, vo.getMid());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
		}
		public MemberVO selectOne(MemberVO vo) {
			MemberVO data = null;
			conn=JDBCUtil.connect();
			try {
				pstmt=conn.prepareStatement(selectOne_member);
				pstmt.setString(1, vo.getMid());
				rs=pstmt.executeQuery();
				if(rs.next()) {
					data=new MemberVO();
					data.setMid(rs.getString("mid"));
					data.setMname(rs.getString("mname"));
					data.setMpassword(rs.getString("mpassword"));
					data.setMmoney(rs.getInt("mmoney"));
					data.setMaccount(rs.getString("maccount"));
					data.setMphone(rs.getString("mphone"));
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
		public void update_mmoneyplus(MemberVO vo) {
			conn=JDBCUtil.connect();
			try {
				pstmt=conn.prepareStatement(update_mmoneyplus);
				pstmt.setInt(1, vo.getMmoney());
				pstmt.setString(2, vo.getMid());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
		}
		
		public void update_mmoneyminus(MemberVO vo) {
			conn=JDBCUtil.connect();
			try {
				pstmt=conn.prepareStatement(update_mmoneyminus);
				pstmt.setInt(1, vo.getMmoney());
				pstmt.setString(2, vo.getMid());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
		}
	   
	   
	   
}
