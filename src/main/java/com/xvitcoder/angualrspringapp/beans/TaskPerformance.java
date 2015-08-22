/**
 * æ–‡å­—ã‚³ãƒ¼ãƒ‰	ï¼š UTF-8
 * ãƒ•ã‚¡ã‚¤ãƒ«å��	ï¼šTaskPerformance.java
 *
 * Copyright(c)ã€€SATT, Inc. All Rights Reserved
 */
package com.xvitcoder.angualrspringapp.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="task_performance")
@IdClass(TaskPerformance.class)
public class TaskPerformance implements Serializable {
	@Id
	@Column(name="work_no")
	String workNo;
	@Id
	@Column(name="reg_time")
	String time;
	@Id
	@Column(name="reg_date")
	String regDate;
	@Id
	@Column(name="member_id")
	String memberId;
	
	String work;
	public String getWorkNo() {
		return workNo;
	}
	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
}
