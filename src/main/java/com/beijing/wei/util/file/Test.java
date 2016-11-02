package com.beijing.wei.util.file;

import java.util.Date;

public class Test {
	private String id;
	private Date date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	Test(String id, Date date) {
		super();
		this.id = id;
		this.date = date;
	}
	
}
