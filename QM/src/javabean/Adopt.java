package javabean;

import java.io.Serializable;
import java.util.Date;

public class Adopt implements Serializable {
	int id;
	int userId;
	String aptName;
	String aptGender;
	String aptId;
	String aptBirthday;
	String aptAddress;
	String aptMobile;
	String aptEmail;
	String aptImage;
	String pet_name;
	int pet_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAptName() {
		return aptName;
	}
	public void setAptName(String aptName) {
		this.aptName = aptName;
	}
	public String getAptGender() {
		return aptGender;
	}
	public void setAptGender(String aptGender) {
		this.aptGender = aptGender;
	}
	public String getAptId() {
		return aptId;
	}
	public void setAptId(String aptId) {
		this.aptId = aptId;
	}
	public String getAptBirthday() {
		return aptBirthday;
	}
	public void setAptBirthday(String aptBirthday) {
		this.aptBirthday = aptBirthday;
	}
	public String getAptAddress() {
		return aptAddress;
	}
	public void setAptAddress(String aptAddress) {
		this.aptAddress = aptAddress;
	}
	
	public String getAptMobile() {
		return aptMobile;
	}
	public void setAptMobile(String aptMobile) {
		this.aptMobile = aptMobile;
	}
	public String getAptEmail() {
		return aptEmail;
	}
	public void setAptEmail(String aptEmail) {
		this.aptEmail = aptEmail;
	}
	public String getAptImage() {
		return aptImage;
	}
	public void setAptImage(String aptImage) {
		this.aptImage = aptImage;
	}
	public String getPet_name() {
		return pet_name;
	}
	public void setPet_name(String pet_name) {
		this.pet_name = pet_name;
	}
	public int getPet_id() {
		return pet_id;
	}
	public void setPet_id(int pet_id) {
		this.pet_id = pet_id;
	}
}
