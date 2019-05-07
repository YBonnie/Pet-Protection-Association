package servlet;

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

public class newsContent extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		NewsService service = BasicFactory.getFactory().getService(
				NewsService.class);
		
		String id = request.getParameter("id");
		News news=service.findNewsById(id);
		request.setAttribute("news", news);
		request.getRequestDispatcher("/news_Center_content1.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	
	}

	
}
