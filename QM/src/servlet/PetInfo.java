package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.Pet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PetService;
import factory.BasicFactory;

public class PetInfo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PetService service = BasicFactory.getFactory().getService(PetService.class);
		
		String name = request.getParameter("name");
		
		Pet pet=service.findPetByName(name);
		
		request.setAttribute("pet", pet);
		request.getRequestDispatcher("/pet_Detailed_Content.jsp").forward(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
