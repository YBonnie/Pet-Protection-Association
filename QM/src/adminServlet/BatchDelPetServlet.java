package adminServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PetService;
import factory.BasicFactory;

public class BatchDelPetServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  //编码问题
		PetService service = BasicFactory.getFactory().getService(PetService.class);
		//1.获取所有要删除的客户id
		String [] ids = request.getParameterValues("delId");
		//2.调用Service中批量删除客户的方法
		service.batchDel(ids);
		//3.转发到客户列表页面
		request.getRequestDispatcher("/AdminPetsServlet").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
