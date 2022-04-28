package com.test.app.have;

public class HaveVO {
	private int hpk;
	private String hmid;
	private String hsname;
	private int hscnt;
	private int hsbuyprice;
	private int hsnowprice;
	
	public int getHpk() {
		return hpk;
	}
	public void setHpk(int hpk) {
		this.hpk = hpk;
	}
	public String getHmid() {
		return hmid;
	}
	public void setHmid(String hmid) {
		this.hmid = hmid;
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
	@Override
	public String toString() {
		return "HaveVO [hpk=" + hpk + ", hmid=" + hmid + ", hsname=" + hsname + ", hscnt=" + hscnt + ", hsbuyprice="
				+ hsbuyprice + ", hsnowprice=" + hsnowprice + "]";
	}

	
	
}
