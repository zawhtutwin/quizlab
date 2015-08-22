package com.xvitcoder.angualrspringapp.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="design_work")
public class DesignWork {
	@Id
	@Column(name="work_no")
	String workNo;

	@Column(name="work")
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

	
	
	
}
