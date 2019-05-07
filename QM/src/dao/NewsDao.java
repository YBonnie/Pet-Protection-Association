package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javabean.News;

public interface NewsDao extends Dao {
	public News findNewsById(String id) ;

	public List<News> findAllNews();
	
	public void addNews(News news) ;

	/**
	 * 
	 * @param news
	 * @return
	 */
	public List<News> findNewsByCond(News news, int from, int count);
	/**
	 * 查询数据库中一共有多少条记录
	 * @return
	 */
	int getCountRow();

	/**
	 * 查询指定记录后多少条记录
	 * @param from 从哪条记录后取
	 * @param count 取多少条
	 * @return
	 */
	List<News> getNewsByPage(int from, int count);

	public List<News> findNewsTitle(String newsTitle);

	public void updateNews(News news);

	public void delNews(String id);

	public void delCustByIDWithTrans(Connection conn, String id) throws SQLException;

	public List<News> getNewsDiviedByPage(String title, int i, int count);

	

}
