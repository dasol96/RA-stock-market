package com.test.app.have;

public class HaveVO {
	private int hpk;
	private String mid; 
	private String hsname;
	private int hscnt;
	private int hsbuyprice;
	private int hsnowprice;
	private int moneyCondition;
	private int moneykeyword;
	
	public int getHpk() {
		return hpk;
	}
	public void setHpk(int hpk) {
		this.hpk = hpk;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String hmid) {
		this.mid = hmid;
	}
	public String getHsname() {
		return hsname;
	}
	public void setHsname(String hsname) {
		this.hsname = hsname;
	}
	public int getHscnt() {
		return hscnt;
	}
	public void setHscnt(int hscnt) {
		this.hscnt = hscnt;
	}
	public int getHsbuyprice() {
		return hsbuyprice;
	}
	public void setHsbuyprice(int hsbuyprice) {
		this.hsbuyprice = hsbuyprice;
	}
	public int getHsnowprice() {
		return hsnowprice;
	}
	public void setHsnowprice(int hsnowprice) {
		this.hsnowprice = hsnowprice;
	}
	
	public int getMoneyCondition() {
		return moneyCondition;
	}
	public void setMoneyCondition(int moneyCondition) {
		this.moneyCondition = moneyCondition;
	}

	public int getMoneykeyword() {
		return moneykeyword;
	}
	public void setMoneykeyword(int moneykeyword) {
		this.moneykeyword = moneykeyword;
	}
	@Override
	public String toString() {
		return "HaveVO [hpk=" + hpk + ", mid=" + mid + ", hsname=" + hsname + ", hscnt=" + hscnt + ", hsbuyprice="
				+ hsbuyprice + ", hsnowprice=" + hsnowprice + ", moneyCondition=" + moneyCondition + ", moneykeyword="
				+ moneykeyword + "]";
	}

	
	
}
