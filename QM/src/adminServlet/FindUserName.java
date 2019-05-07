package adminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javabean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import service.UserService;
import factory.BasicFactory;

public class FindUserName extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		UserService service = BasicFactory.getFactory().getService(UserService.class);
		
		String userName = request.getParameter("FindUserName");
		List<User> UserList = service.AdminfindUserByName(userName);
		request.setAttribute("UserList", UserList);
		request.getRequestDispatcher("/Administrator_interface/Managing_user_info.jsp").forward(request,
				response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	
	}

	

}
