package adminServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.News;
import javabean.Pet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NewsService;
import factory.BasicFactory;

public class EditNewsServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  //编码问题
		NewsService service = BasicFactory.getFactory().getService(NewsService.class);
		
		 //1.获取要查询的客户id
		String id =request.getParameter("id");
		//2.调用Service中根据id查找客户的方法
				News news = service.findNewsById(id);
				if(news == null){
					throw new RuntimeException("找不到该新闻信息!");
				}
				//3.将查找到的客户信息存入request域中,请求转发到AdminEditNews.jsp页面展示
				request.setAttribute("news", news);
				request.getRequestDispatcher("/Administrator_interface/AdminEditNews.jsp").forward(request, response);

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	

}
