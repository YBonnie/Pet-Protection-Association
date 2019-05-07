package adminServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.Adopt;
import javabean.Pet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PetService;
import factory.BasicFactory;

public class EditPetsServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  //编码问题
		PetService service = BasicFactory.getFactory().getService(PetService.class);
		
		
		 //1.获取要查询的客户id
		String id =request.getParameter("id");
		//2.调用Service中根据id查找客户的方法
		Pet pet = service.findPetById(id);
		if(pet == null){
			throw new RuntimeException("找不到该宠物!");
		}
		//3.将查找到的客户信息存入request域中,请求转发到AdminEditPet.jsp页面展示
		request.setAttribute("pet", pet);
		request.getRequestDispatcher("/Administrator_interface/AdminEditPet.jsp").forward(request, response);

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	
	}


}
