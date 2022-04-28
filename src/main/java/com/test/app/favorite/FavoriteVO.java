package com.test.app.favorite;

public class FavoriteVO {
	private int fpk;
	private int spk;
	private String mid;
	
	public int getFpk() {
		return fpk;
	}
	public void setFpk(int fpk) {
		this.fpk = fpk;
	}
	public int getSpk() {
		return spk;
	}
	public void setSpk(int spk) {
		this.spk = spk;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	
	@Override
	public String toString() {
		return "FavoriteVO [fpk=" + fpk + ", spk=" + spk + ", mid=" + mid + "]";
	}
	
	
	
}
