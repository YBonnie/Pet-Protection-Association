package javabean;

import java.io.Serializable;
import java.sql.Date;

public class Dynamics implements Serializable{
	int id;
	String dynamics_title;
	Date dynamics_time;
	String dynamics_content;
	String dynamics_allcont;
	String dynamics_img;
	public String getDynamics_img() {
		return dynamics_img;
	}
	public void setDynamics_img(String dynamics_img) {
		this.dynamics_img = dynamics_img;
	}
	public String getDynamics_allcont() {
		return dynamics_allcont;
	}
	public void setDynamics_allcont(String dynamics_allcont) {
		this.dynamics_allcont = dynamics_allcont;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDynamics_title() {
		return dynamics_title;
	}
	public void setDynamics_title(String dynamics_title) {
		this.dynamics_title = dynamics_title;
	}
	public Date getDynamics_time() {
		return dynamics_time;
	}
	public void setDynamics_time(Date dynamics_time) {
		this.dynamics_time = dynamics_time;
	}
	public String getDynamics_content() {
		return dynamics_content;
	}
	public void setDynamics_content(String dynamics_content) {
		this.dynamics_content = dynamics_content;
	}

}
