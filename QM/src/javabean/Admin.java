package javabean;

import java.io.Serializable;

public class Admin implements Serializable{
	int id;
	String ad_name;
	String ad_password;
	int ad_phone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAd_name() {
		return ad_name;
	}
	public void setAd_name(String ad_name) {
		this.ad_name = ad_name;
	}
	public String getAd_password() {
		return ad_password;
	}
	public void setAd_password(String ad_password) {
		this.ad_password = ad_password;
	}
	public int getAd_phone() {
		return ad_phone;
	}
	public void setAd_phone(int ad_phone) {
		this.ad_phone = ad_phone;
	}
}
