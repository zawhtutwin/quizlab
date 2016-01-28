package com.xvitcoder.angualrspringapp.controller;

public class Mark {
	private String subject;
	private Integer mark;
	public Mark(String subject, Integer mark) {
		super();
		this.subject = subject;
		this.mark = mark;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Integer getMark() {
		return mark;
	}
	public void setMark(Integer mark) {
		this.mark = mark;
	}
	
	
}
