package com.mongodb.model;

import java.io.Serializable;

public class Msge implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String content;
	private long time;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

}
