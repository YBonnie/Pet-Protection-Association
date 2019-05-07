package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javabean.Page;
import javabean.Pet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PetService;
import factory.BasicFactory;

public class ReturnHome extends HttpServlet {


	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PetService service = BasicFactory.getFactory().getService(PetService.class);

		int thispage = Integer.parseInt(request.getParameter("thispage"));
		int rowperpage =6;
		Page page = service.getPetAdopByPage(1, thispage, rowperpage);
		
		request.setAttribute("page", page);
		request.getRequestDispatcher("/return_Home.jsp").forward(request, response);
		
		
		
		
		
		
//      List<Pet> list=service.findPetItem(1);
//			System.out.print(list);
//			//2.将所有商品信息存入request域后带到页面展示
//			request.setAttribute("list", list);
//			request.getRequestDispatcher("/return_Home.jsp").forward(request, response);
		
		

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
