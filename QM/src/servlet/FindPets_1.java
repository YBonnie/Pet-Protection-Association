package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.Page;
import javabean.Pet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PetService;
import factory.BasicFactory;

public class FindPets_1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PetService service = BasicFactory.getFactory().getService(PetService.class);
		int thispage=1;
		int rowperpage =6;
		String str_thispage = request.getParameter("thispage");
		if(str_thispage!=null){
			thispage = Integer.parseInt(str_thispage);
		}
		Pet pets= new Pet();
	    Page page = service.getPetDiviedByPage("cat", thispage, rowperpage);

		request.setAttribute("page", page);
		request.getRequestDispatcher("/pet_Introduction_2.jsp").forward(request,
				response);
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


}
