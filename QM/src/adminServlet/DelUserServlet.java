package adminServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import factory.BasicFactory;

public class DelUserServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  //编码问题
		UserService service = BasicFactory.getFactory().getService(UserService.class);
		String id = request.getParameter("id");
		service.delUser(id);
//		重定向回/AdminUserServlet
		 request.getRequestDispatcher("/AdminUserServlet").forward(request,
					response);

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}



}
