package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javabean.Pet;
import javabean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import service.UserService;
import factory.BasicFactory;

public class ListUser extends HttpServlet {

	

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  //编码问题
		//对于get提交只能手动的解决
		UserService service = BasicFactory.getFactory().getService(UserService.class);
		String id = request.getParameter("id");
		System.out.println(id);
		User user=service.findUserById(id);
		JOptionPane.showMessageDialog(null, "个人信息修改成功，请返回主页", "提示",JOptionPane.PLAIN_MESSAGE); 
		//2.将查找到的信息存入request域,请求转发到edit_success.jsp页面进行展示
		request.setAttribute("user", user);
		request.getRequestDispatcher("/edit_success.jsp").forward(request, response);
		

	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

	

}
