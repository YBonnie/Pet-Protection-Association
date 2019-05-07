package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javabean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.commons.beanutils.BeanUtils;

import service.UserService;
import factory.BasicFactory;

public class UpdateUser extends HttpServlet {


	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  //编码问题
		//对于get提交只能手动的解决
		UserService service = BasicFactory.getFactory().getService(UserService.class);
		
		try {
			String id =request.getParameter("id");
			
			//1.封装数据校验数据
			User user = new User();
			
			BeanUtils.populate(user, request.getParameterMap());
			
			//2.调用Service中修改客户信息的方法
			service.updateUser(user);
			
			//3.重定向到客户列表页面
			request.getRequestDispatcher("/ListUser").forward(request, response);
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

	

}
