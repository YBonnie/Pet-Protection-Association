package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import util.DaoUtils;
import util.TransactionManager;

import javabean.Good;
import javabean.News;
import javabean.Pet;
import javabean.User;

public class NewsDaoImpl implements NewsDao {


	public News findNewsById(String id) {
		String sql = "select * from news where id = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanHandler<News>(News.class),id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<News> findAllNews() {
		String sql = "select * from news order by news_time desc";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<News>(News.class));
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void addNews(News news) {
		String sql = "insert into news values(null,?,?,?,?,?,?)";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			runner.update(sql,news.getNews_img(),news.getNews_titles(),news.getNews_time(),news.getNews_content(),news.getNews_deily_cont(),news.getNews_allcont());
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

//	查询功能
	public List<News> findNewsByCond(News news,int from, int count) {
		// TODO Auto-generated method stub
		String sql = "select * from news where 1=1 ";
		List<Object> list = new ArrayList<Object>();
		if(news.getNews_titles()!=null && !"".equals(news.getNews_titles())){
			sql += " and news_titles like ?";
			list.add("%"+news.getNews_titles()+"%");
		}
		list.add(from);
		list.add(count);
		sql += "limit ?,?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			if(list.size()<=0){
				return runner.query(sql, new BeanListHandler<News>(News.class));
			}else{
				return runner.query(sql, new BeanListHandler<News>(News.class),list.toArray());
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public int getCountRow() {
		String sql = "select count(*) from news";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return ((Long)runner.query(sql, new ScalarHandler())).intValue();
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public List<News> getNewsByPage(int from, int count) {
		String sql = "select * from news order by news_time desc limit ?,?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			return runner.query(sql, new BeanListHandler<News>(News.class),from,count);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public List<News> findNewsTitle(String newsTitle) {
		String sql = "select * from news where news_titles = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<News>(News.class),newsTitle);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void updateNews(News news) {
		// TODO Auto-generated method stub
		String sql = "update news set news_img = ? ,news_titles = ? ,news_time = ? ,news_content = ? ,news_deily_cont = ? ,news_allcont = ? where id=?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			runner.update(sql,news.getNews_img(),news.getNews_titles(),news.getNews_time(),news.getNews_content(),news.getNews_deily_cont(),news.getNews_allcont(),news.getId());
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}	
	}

	public void delNews(String id) {
		// TODO Auto-generated method stub
		String sql = "delete from news where id = ?";
		try{
			QueryRunner runner = new QueryRunner(TransactionManager.getSource());
			runner.update(sql,id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}	
		
	}

	public void delCustByIDWithTrans(Connection conn, String id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from news where id = ?";
		QueryRunner runner = new QueryRunner();
		runner.update(conn,sql,id);
	}

	public List<News> getNewsDiviedByPage(String title, int i, int count) {
		String sql = "select * from news where 1=1 ";
		List<Object> list = new ArrayList<Object>();
		
		if(title!=""){
			sql += " and news_titles like ?";
			list.add(title);
		}
		list.add(i);
		list.add(count);
		sql += "limit ?,?";
		try{
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			if(list.size()<=0){
				return runner.query(sql, new BeanListHandler<News>(News.class));
			}else{
				return runner.query(sql, new BeanListHandler<News>(News.class),list.toArray());
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	
}
