package com.test.app.favorite;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FAVORITE")
public class FavoriteVO {
	
	private static final long serialVersionUID = 1L;
	public FavoriteVO() {
		super();
	}
	@Id
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
