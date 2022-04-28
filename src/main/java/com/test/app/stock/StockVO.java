package com.test.app.stock;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="STOCK")
public class StockVO {
	
	private static final long serialVersionUID = 1L;
	public StockVO() {
		super();
	}
	
	@Id
	private int spk;
	private String sname;
	private int snprice;
	private int snowprice;
	private int sypriceupdown;
	private double snpercent;
	private int sntrade;
	@Transient
	private String searchCondition;
	
	
	
	public int getSnowprice() {
		return snowprice;
	}
	public void setSnowprice(int snowprice) {
		this.snowprice = snowprice;
	}
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
	
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	@Override
	public String toString() {
		return "StockVO [spk=" + spk + ", sname=" + sname + ", snprice=" + snprice + ", snowprice=" + snowprice
				+ ", sypriceupdown=" + sypriceupdown + ", snpercent=" + snpercent + ", sntrade=" + sntrade 
				+  ", searchCondition=" + searchCondition + "]";
	}
	
	
}
