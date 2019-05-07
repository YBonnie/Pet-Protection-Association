package javabean;

import java.io.Serializable;
import java.sql.Date;

public class News implements Serializable{
	int id;
	String news_img;
	String news_titles;
	Date news_time;
	String news_content;
	String news_deily_cont;
	String news_allcont;
	public String getNews_allcont() {
		return news_allcont;
	}
	public void setNews_allcont(String news_allcont) {
		this.news_allcont = news_allcont;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNews_img() {
		return news_img;
	}
	public void setNews_img(String news_img) {
		this.news_img = news_img;
	}
	public String getNews_titles() {
		return news_titles;
	}
	public void setNews_titles(String news_titles) {
		this.news_titles = news_titles;
	}
	public Date getNews_time() {
		return news_time;
	}
	public void setNews_time(Date news_time) {
		this.news_time = news_time;
	}
	public String getNews_content() {
		return news_content;
	}
	public void setNews_content(String news_content) {
		this.news_content = news_content;
	}
	public String getNews_deily_cont() {
		return news_deily_cont;
	}
	public void setNews_deily_cont(String news_deily_cont) {
		this.news_deily_cont = news_deily_cont;
	}
	
}
