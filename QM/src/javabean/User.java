package javabean;

import java.io.Serializable;

public class User implements Serializable {
String username;
int id;
String password1;
String password2;
String truename;
String chineseId;
String email;
String phone;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPassword1() {
	return password1;
}
public void setPassword1(String password1) {
	this.password1 = password1;
}
public String getPassword2() {
	return password2;
}
public void setPassword2(String password2) {
	this.password2 = password2;
}
public String getTruename() {
	return truename;
}
public void setTruename(String truename) {
	this.truename = truename;
}
public String getChineseId() {
	return chineseId;
}
public void setChineseId(String chineseId) {
	this.chineseId = chineseId;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}



	
	
}
