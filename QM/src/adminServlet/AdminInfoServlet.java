package adminServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.Admin;
import javabean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminService;
import service.UserService;
import factory.BasicFactory;

public class AdminInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  //编码问题
		
		AdminService service = BasicFactory.getFactory().getService(AdminService.class);		
		//1.获取要查询的客户id
				String id =request.getParameter("id");
				//2.调用Service中根据id查找客户的方法
				Admin admin = service.findAdminById(id);
				if(admin == null){
					throw new RuntimeException("找不到该客户!");
				}
				//3.将查找到的客户信息存入request域中,请求转发到/AdminEdit.jsp页面展示
				request.setAttribute("admin", admin);
				request.getRequestDispatcher("/Administrator_interface/AdminEdit.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

	
}
