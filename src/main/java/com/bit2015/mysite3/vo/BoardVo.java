package com.bit2015.mysite3.vo;

public class BoardVo {
	private long no;
	private String name;
	private long user_no;
	private long hit;
	private String title;
	private String message;
	private String reg_date;
	private long index_no;
	private long rnum;
	private long totcnt;
	
	
	
	public long getRnum() {
		return rnum;
	}
	public void setRnum(long rnum) {
		this.rnum = rnum;
	}
	public long getTotcnt() {
		return totcnt;
	}
	public void setTotcnt(long totcnt) {
		this.totcnt = totcnt;
	}
	public long getIndex_no() {
		return index_no;
	}
	public void setIndex_no(long index_no) {
		this.index_no = index_no;
	}
	public long getUser_no() {
		return user_no;
	}
	public void setUser_no(long user_no) {
		this.user_no = user_no;
	}
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getHit() {
		return hit;
	}
	public void setHit(long hit) {
		this.hit = hit;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
	

}