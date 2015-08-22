/**
 * 文字コード	： UTF-8
 * ファイル名	：RepTime.java
 *
 * Copyright(c)　SATT, Inc. All Rights Reserved
 */
package com.xvitcoder.angualrspringapp.beans;

/**
 * クラスのファイルの説明を記述
 *
 * @author： Zaw Htut Win
 */
public class RepTime {
	String time;
	String workNo="";
	String taskNo="";
	String taskName="";
	String taskContent="";
	
	
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskContent() {
		return taskContent;
	}
	public void setTaskContent(String taskContent) {
		this.taskContent = taskContent;
	}
	public String getWorkNo() {
		return workNo;
	}
	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}
	public String getTaskNo() {
		return taskNo;
	}
	public void setTaskNo(String taskNo) {
		this.taskNo = taskNo;
	}
	public RepTime(){
		
	}
	public RepTime(String time) {
		super();
		this.time = time;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
