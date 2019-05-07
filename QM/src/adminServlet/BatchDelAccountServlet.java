package adminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javabean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AccountService;
import service.AdoptionService;
import service.UserService;
import factory.BasicFactory;

public class BatchDelAccountServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		AccountService service = BasicFactory.getFactory().getService(
				AccountService.class);
		//1.获取所有要删除的客户id
		String [] ids = request.getParameterValues("delId");
		//2.调用Service中批量删除客户的方法
		service.batchDel(ids);
		//3.转发到客户列表页面
		request.getRequestDispatcher("/AdminAccountServlet").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

	

}
