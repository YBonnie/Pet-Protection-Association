package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javabean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.commons.beanutils.BeanUtils;

import service.UserService;
import factory.BasicFactory;

public class Login extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  //编码问题
		//对于get提交只能手动的解决
		UserService service = BasicFactory.getFactory().getService(UserService.class);
		User user = new User();
		String name = request.getParameter("username");
		String password1 = request.getParameter("password1");
		user.setUsername(name);
		user.setPassword1(password1);
		User user2=service.getUserByNameAndPsw(user.getUsername(), user.getPassword1());
		
		if(user2==null ||user2.getUsername()==name && user2.getPassword1() == password1){
			JOptionPane.showMessageDialog(null, "密码或帐号错误！", "错误提示", JOptionPane.ERROR_MESSAGE);
			response.setHeader("Refresh", "1;url=/QM/sign_In.jsp");
			return;
		}else
			JOptionPane.showMessageDialog(null, "登陆成功！", "提示",JOptionPane.PLAIN_MESSAGE);

		request.getSession().setAttribute("user2", user2);
		response.setHeader("Refresh", "1;url=/QM/IndexList");
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
