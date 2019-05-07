package adminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javabean.Pet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PetService;
import factory.BasicFactory;

public class AdminPetsServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  //编码问题
		PetService service = BasicFactory.getFactory().getService(PetService.class);
		
		List<Pet> PetList = service.findAllPet();
//		把user所有数据保存到request域里面	
		request.setAttribute("PetList", PetList);
	
//		重定向回Managing_pet_info.jsp
	    request.getRequestDispatcher("/Administrator_interface/Managing_pet_info.jsp").forward(request,
				response);

	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	
	}

}
