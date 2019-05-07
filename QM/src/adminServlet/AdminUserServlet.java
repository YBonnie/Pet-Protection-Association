package adminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javabean.Admin;
import javabean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.AdminService;
import service.UserService;
import factory.BasicFactory;

public class AdminUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  //编码问题
		
		UserService service = BasicFactory.getFactory().getService(UserService.class);
		//		获取user所有数据
		List<User> UserList = service.getAllUser();
//		把user所有数据保存到request域里面	
		request.setAttribute("UserList", UserList);
	
//		重定向回Managing_user_info.jsp
	    request.getRequestDispatcher("/Administrator_interface/Managing_user_info.jsp").forward(request,
				response);

		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


}
