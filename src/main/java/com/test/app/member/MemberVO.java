package com.test.app.member;

public class MemberVO {
	private String mid;
	private String mname;
	private String mpassword;
	private int mmoney;
	private String maccount;
	private String mphone;
	private int inOrOut;
	private int inOrOutMoney;
	private int moneyCondition;
	private int buyOrSell;
	
	
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
	public int getInOrOut() {
		return inOrOut;
	}
	public void setInOrOut(int inOrOut) {
		this.inOrOut = inOrOut;
	}
	public int getInOrOutMoney() {
		return inOrOutMoney;
	}
	public void setInOrOutMoney(int inOrOutMoney) {
		this.inOrOutMoney = inOrOutMoney;
	}
	public int getMoneyCondition() {
		return moneyCondition;
	}
	public void setMoneyCondition(int moneyCondition) {
		this.moneyCondition = moneyCondition;
	}
	
	public int getBuyOrSell() {
		return buyOrSell;
	}
	public void setBuyOrSell(int buyOrSell) {
		this.buyOrSell = buyOrSell;
	}
	@Override
	public String toString() {
		return "MemberVO [mid=" + mid + ", mname=" + mname + ", mpassword=" + mpassword + ", mmoney=" + mmoney
				+ ", maccount=" + maccount + ", mphone=" + mphone + ", inOrOut=" + inOrOut + ", inOrOutMoney="
				+ inOrOutMoney + ", moneyCondition=" + moneyCondition + ", buyOrSell=" + buyOrSell + "]";
	}
	
	
	
}
