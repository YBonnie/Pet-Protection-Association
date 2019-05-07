package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javabean.News;
import javabean.Page;
import javabean.Pet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.commons.beanutils.BeanUtils;

import service.NewsService;
import factory.BasicFactory;

public class FindNewsList extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
			request.setCharacterEncoding("utf-8");
			NewsService service = BasicFactory.getFactory().getService(
					NewsService.class);
			
			/*
			News news= new News();
			
			news.setNews_titles(request.getParameter("search"));
			
//			System.out.print(news);
			
			//获取访问页码
			int thispage=1;
			String str_thispage = request.getParameter("thispage");
			
			if(str_thispage!=null){
				thispage = Integer.parseInt(str_thispage);
			}
			
			//2.调用Service中条件查询客户的方法,查出符合条件的客户
			List<News> list = service.findNewsByCond(news,thispage,5);
			
			System.out.print(list);
			//分页模型
			Page page = service.pageNews(thispage,5);
			//3.将查到的客户存入request域中带到association_Information.jsp页面进行展示
			page.setList(list);
			
			
			
			*/
			String title = request.getParameter("search");
			
			int thispage=1;
			int rowperpage =5;
			String str_thispage = request.getParameter("thispage");
			if(str_thispage!=null){
				thispage = Integer.parseInt(str_thispage);
			}
			//1.获取查询条件封装到bean中
			News news= new News();
			Page page = service.getDivDiviedByPage(title, thispage, rowperpage);
			
			
			
			
			
			request.setAttribute("page", page);
			
			request.getRequestDispatcher("/association_Information.jsp").forward(request,
					response);
		

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	
	}


}
