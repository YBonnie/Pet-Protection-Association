package javabean;

import java.util.List;

public class Page {
	//litmit查询的其实位置
	//当前页面的index
	private int thispage;
	//每页展示的记录条数
	private int rowperpage;
	//总记录条数
	private int countrow;
	private int countpage;
	private int firstpage;
	//总页数
	private int lastpage;
	//上一页
	private int prepage;
	//下一页
	private int nextpage;
	private List<News>list;
	private List<Dynamics>list1;
	private List<Pet>list2;
	private List<Account>list3;
	private List<Good>list4;
	
	public List<Good> getList4() {
		return list4;
	}
	public void setList4(List<Good> list4) {
		this.list4 = list4;
	}
	public List<Account> getList3() {
		return list3;
	}
	public void setList3(List<Account> list3) {
		this.list3 = list3;
	}
	public List<Pet> getList2() {
		return list2;
	}
	public void setList2(List<Pet> list2) {
		this.list2 = list2;
	}
	public List<Dynamics> getList1() {
		return list1;
	}
	public void setList1(List<Dynamics> list1) {
		this.list1 = list1;
	}
	public int getThispage() {
		return thispage;
	}
	public void setThispage(int thispage) {
		this.thispage = thispage;
	}
	public int getRowperpage() {
		return rowperpage;
	}
	public void setRowperpage(int rowperpage) {
		this.rowperpage = rowperpage;
	}
	public int getCountrow() {
		return countrow;
	}
	public void setCountrow(int countrow) {
		this.countrow = countrow;
	}
	public int getCountpage() {
		return countpage;
	}
	public void setCountpage(int countpage) {
		this.countpage = countpage;
	}
	public int getFirstpage() {
		return firstpage;
	}
	public void setFirstpage(int firstpage) {
		this.firstpage = firstpage;
	}
	public int getLastpage() {
		return lastpage;
	}
	public void setLastpage(int lastpage) {
		this.lastpage = lastpage;
	}
	public int getPrepage() {
		return prepage;
	}
	public void setPrepage(int prepage) {
		this.prepage = prepage;
	}
	public int getNextpage() {
		return nextpage;
	}
	public void setNextpage(int nextpage) {
		this.nextpage = nextpage;
	}
	public List<News> getList() {
		return list;
	}
	public void setList(List<News> list) {
		this.list = list;
	}
	
	
}
