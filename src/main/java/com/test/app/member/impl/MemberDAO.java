package com.test.app.member.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.test.app.common.JDBCUtil;
import com.test.app.member.MemberVO;

@Repository("memberdao") //MemberServiceImpl에서 private MemberDAO = memberdao의 타겟이 되어 같이 어노테이션 삽입
public class MemberDAO {
	   private Connection conn=null;
	   private PreparedStatement pstmt=null;
	   private ResultSet rs=null;
	   private final String insert_member="insert into member(mid,mname,mpassword,maccount,mphone) values(?,?,?,?,?)";
	   private final String update_member="update member set mname=?,mpassword=?,maccount=?,mphone=? where mid=?";
	   private final String delete_member="delete member where mid=?";
	   private final String selectOne_member="select * from member where mid=?";
	   private final String selectOne_member2="select * from member where mid=? and mpassword=?";
	   private final String update_mmoneyplus="update member set mmoney=mmoney+? where mid=?"; //입금
	   private final String update_mmoneyminus="update member set mmoney=mmoney-? where mid=?"; //출금
	   private final String update_mmoneyminus_buyOrSell="update member set mmoney=? where mid=?";//매수매도로 인한 금액 차감
   
	   
		public void insert_member(MemberVO vo) {
			conn=JDBCUtil.connect();
			try {
				pstmt=conn.prepareStatement(insert_member);
				pstmt.setString(1, vo.getMid());
				pstmt.setString(2, vo.getMname());
				pstmt.setString(3, vo.getMpassword());
				pstmt.setString(4, vo.getMaccount());
				pstmt.setString(5, vo.getMphone());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
			System.out.println("MemberDAO insert 성공");
		}
		
		public void update_member(MemberVO vo) {
			conn=JDBCUtil.connect();
			try {
				//Systsem.out.println("로그 : MemberDAO update vo.getname"+vo.getMname());
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
				pstmt=conn.prepareStatement(delete_member);
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
				System.out.println("로그 : MemberDAO selectOne mid = "+vo.getMid());
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
				System.out.println("로그 : MemberDAO selectOne mname = "+data.getMname());
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
			return data;
		}
		public MemberVO selectOne2(MemberVO vo) {
			MemberVO data = null;
			conn=JDBCUtil.connect();
			try {
				pstmt=conn.prepareStatement(selectOne_member2);
				pstmt.setString(1, vo.getMid());
				pstmt.setString(2, vo.getMpassword());
				System.out.println("로그 : MemberDAO selectOne mid = "+vo.getMid());
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
				System.out.println("로그 : MemberDAO selectOne mname = "+data.getMname());
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
				pstmt.setInt(1, vo.getInOrOutMoney());
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
				pstmt.setInt(1, vo.getInOrOutMoney());
				pstmt.setString(2, vo.getMid());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
		}
		public void update_mmoneyminus_buyOrSell(MemberVO vo) {//매수매도로 인한 금액 차감
			conn=JDBCUtil.connect();
			try {
				pstmt=conn.prepareStatement(update_mmoneyminus_buyOrSell);
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
