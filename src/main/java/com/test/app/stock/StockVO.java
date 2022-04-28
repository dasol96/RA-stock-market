package com.test.app.stock;

public class StockVO {
	private int spk;
	private String sname;
	private int snprice;
	private int sypriceupdown;
	private double snpercent;
	private int sntrade;
	private int sstate;
	
	public int getSpk() {
		return spk;
	}
	public void setSpk(int spk) {
		this.spk = spk;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSnprice() {
		return snprice;
	}
	public void setSnprice(int snprice) {
		this.snprice = snprice;
	}
	public int getSypriceupdown() {
		return sypriceupdown;
	}
	public void setSypriceupdown(int sypriceupdown) {
		this.sypriceupdown = sypriceupdown;
	}
	public double getSnpercent() {
		return snpercent;
	}
	public void setSnpercent(double snpercent) {
		this.snpercent = snpercent;
	}
	public int getSntrade() {
		return sntrade;
	}
	public void setSntrade(int sntrade) {
		this.sntrade = sntrade;
	}
	public int getSstate() {
		return sstate;
	}
	public void setSstate(int sstate) {
		this.sstate = sstate;
	}
	
	@Override
	public String toString() {
		return "StockVO [spk=" + spk + ", sname=" + sname + ", snprice=" + snprice + ", sypriceupdown=" + sypriceupdown
				+ ", snpercent=" + snpercent + ", sntrade=" + sntrade + ", sstate=" + sstate + "]";
	}
	
	
}
