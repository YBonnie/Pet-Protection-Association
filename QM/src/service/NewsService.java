package service;

import java.util.List;

import javabean.News;
import javabean.Page;


public interface NewsService extends Service{
	News findNewsById(String id);

	List<News> findAllNews();

    List<News> findNewsByCond(News news,int from, int count);
    /**
	 * 分页查询客户的方法
	 * @param thispage 当前页码
	 * @param rowperpage 每页记录数
	 * @return 当前页所有信息
	 */
	Page pageNews(int thispage, int rowperpage);

	List<News> findNewsTitle(String newsTitle);

	void updateNews(News news);

	void delNews(String id);
	/**
	 * 添加新闻*/
	void addNews(News news);

	void batchDel(String[] ids);
    
	Page getDivDiviedByPage(String title, int from, int count);
   
}
