package service;

import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import util.DaoUtils;

import dao.NewsDao;
import factory.BasicFactory;

import javabean.News;
import javabean.Page;



public class NewsServiceImpl implements NewsService{
	private NewsDao dao = BasicFactory.getFactory().getDao(NewsDao.class);

	public News findNewsById(String id) {
		// TODO Auto-generated method stub
		return dao.findNewsById(id);
	}

	public List<News> findAllNews() {
		// TODO Auto-generated method stub
		return dao.findAllNews();
	}

	public List<News> findNewsByCond(News news,int from, int count) {
		// TODO Auto-generated method stub
		return dao.findNewsByCond(news,from,count);
	}
	
	
	
	
	
	
	
	

	public Page pageNews(int thispage, int rowperpage) {
		Page page = new Page();
		//--当前页
		page.setThispage(thispage);
		//--每页记录数
		page.setRowperpage(rowperpage);
		//--共有多少行
		int countrow = dao.getCountRow();
		page.setCountrow(countrow);
		//--共有多少页
		int countpage = countrow/rowperpage+(countrow%rowperpage==0?0:1);
		page.setCountpage(countpage);
		//--首页
		page.setFirstpage(1);
		//--尾页
		page.setLastpage(countpage);
		//--上一页
		page.setPrepage(thispage==1?1:thispage-1);
		//--下一页
		page.setNextpage(thispage == countpage ? countpage : thispage+1);
		//--当前页数据
		List<News> list = dao.getNewsByPage((thispage-1)*rowperpage,rowperpage);
		page.setList(list);
		
		return page;
	}

	public List<News> findNewsTitle(String newsTitle) {
		// TODO Auto-generated method stub
		return dao.findNewsTitle(newsTitle);
	}

	public void updateNews(News news) {
		// TODO Auto-generated method stub
		dao.updateNews(news);
	}

	public void delNews(String id) {
		// TODO Auto-generated method stub
		dao.delNews(id);
		
	}

	public void addNews(News news) {
		// TODO Auto-generated method stub
		dao.addNews(news);
	}

	public void batchDel(String[] ids) {
		// TODO Auto-generated method stub
		java.sql.Connection conn = DaoUtils.getConn();
		try{
			conn.setAutoCommit(false);
			for(String id : ids){
				dao.delCustByIDWithTrans(conn,id);
			}
			DbUtils.commitAndCloseQuietly(conn);
		}catch (Exception e) {
			DbUtils.rollbackAndCloseQuietly(conn);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public Page getDivDiviedByPage(String title, int from, int count) {
		Page page = new Page();
		//--当前页
		page.setThispage(from);
		//--每页记录数
		page.setRowperpage(count);
		//--共有多少行
		int countrow = dao.getCountRow();
		page.setCountrow(countrow);
		//--共有多少页
		int countpage = countrow/count+(countrow%count==0?0:1);
		page.setCountpage(countpage);
		//--首页
		page.setFirstpage(1);
		//--尾页
		page.setLastpage(countpage);
		//--上一页
		page.setPrepage(from==1?1:from-1);
		//--下一页
		page.setNextpage(from == countpage ? countpage : from+1);
		//--当前页数据
		List<News> list = dao.getNewsDiviedByPage(title,(from-1)*count,count);
		page.setList(list);
		
		return page;
	}

	
}
