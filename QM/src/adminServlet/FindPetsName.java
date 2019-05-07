package adminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javabean.Pet;
import javabean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PetService;
import factory.BasicFactory;

public class FindPetsName extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PetService service = BasicFactory.getFactory().getService(PetService.class);
		
		String PetName = request.getParameter("FindPetsName");
		List<Pet> PetList = service.findPetName(PetName);
		request.setAttribute("PetList", PetList);
		request.getRequestDispatcher("/Administrator_interface/Managing_pet_info.jsp").forward(request,
				response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

	

}
