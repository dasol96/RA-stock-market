package com.test.app.member;

public class MemberVO {
	private String mid;
	private String mname;
	private String mpassword;
	private int mmoney;
	private String maccount;
	private String mphone;
	
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMpassword() {
		return mpassword;
	}
	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
	public int getMmoney() {
		return mmoney;
	}
	public void setMmoney(int mmoney) {
		this.mmoney = mmoney;
	}
	public String getMaccount() {
		return maccount;
	}
	public void setMaccount(String maccount) {
		this.maccount = maccount;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	
	@Override
	public String toString() {
		return "MemberVO [mid=" + mid + ", mname=" + mname + ", mpassword=" + mpassword + ", mmoney=" + mmoney
				+ ", maccount=" + maccount + ", mphone=" + mphone + "]";
	}
	
	
	
}
