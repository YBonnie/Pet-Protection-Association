package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javabean.News;
import javabean.Page;
import javabean.Pet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PetService;
import factory.BasicFactory;

public class LoveAdoption extends HttpServlet {

	

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PetService service = BasicFactory.getFactory().getService(PetService.class);
		
		int thispage = Integer.parseInt(request.getParameter("thispage"));
		int rowperpage =6;
		
		//2.调用Service中条件查询客户的方法,查出符合条件的客户
		Page page = service.getPetAdopByPage(0, thispage, rowperpage);

		//3.将查到的客户存入request域中带到love_Adoption.jsp页面进行展示
		request.setAttribute("page", page);
		request.getRequestDispatcher("/love_Adoption.jsp").forward(request, response);

	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);		
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
