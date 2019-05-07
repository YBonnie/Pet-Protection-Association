package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javabean.Dynamics;
import javabean.Good;
import javabean.News;
import javabean.Pet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DynamicsService;
import service.GoodService;
import service.NewsService;
import service.PetService;
import factory.BasicFactory;

public class IndexList extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		NewsService newsService = BasicFactory.getFactory().getService(
				NewsService.class);
		DynamicsService dynamicsService = BasicFactory.getFactory().getService(
				DynamicsService.class);
		PetService petService = BasicFactory.getFactory().getService(PetService.class);
		GoodService goodService = BasicFactory.getFactory().getService(
				GoodService.class);
		
		List<News> newsList = newsService.findAllNews();
		request.setAttribute("newsList", newsList);
		
		 List<Dynamics> dynamicsList = dynamicsService.findAllDynamics();		
		request.setAttribute("dynamicsList", dynamicsList);
		
		List<Pet> petList = petService.findPetItem(0);
		request.setAttribute("petList", petList);
		
		List<Good> goodList = goodService.findAllGood();
		request.setAttribute("goodList", goodList);
		
	request.getRequestDispatcher("/index.jsp").forward(request,
				response);

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
	}

	

}
