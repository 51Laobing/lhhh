package com.wxc.lhhh.model;

import java.sql.Date;

public class User {
	private String id;
	private String mm;
	private String nc;
	private int jfye;
	private Date zcsj;
	
	
	
	public Date getZcsj() {
		return zcsj;
	}
	public void setZcsj(Date zcsj) {
		this.zcsj = zcsj;
	}
	public String getMm() {
		return mm;
	}
	public void setMm(String mm) {
		this.mm = mm;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNc() {
		return nc;
	}
	public void setNc(String nc) {
		this.nc = nc;
	}
	public int getJfye() {
		return jfye;
	}
	public void setJfye(int jfye) {
		this.jfye = jfye;
	}
	
}
