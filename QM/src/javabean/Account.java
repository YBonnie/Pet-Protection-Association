package javabean;

import java.io.Serializable;
import java.sql.Date;

public class Account implements Serializable{
	int id;
	Date timer;
	String title;
	String url;
	String accountimg;
	public String getAccountimg() {
		return accountimg;
	}
	public void setAccountimg(String accountimg) {
		this.accountimg = accountimg;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getTimer() {
		return timer;
	}
	public void setTimer(Date timer) {
		this.timer = timer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
