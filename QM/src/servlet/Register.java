package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.commons.beanutils.BeanUtils;

import javabean.User;

import service.UserService;
import factory.BasicFactory;

public class Register extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  //编码问题
		UserService service = BasicFactory.getFactory().getService(UserService.class);
		
		try {
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			//判断两次密码是否相同
			if(service.findUserByName(user.getUsername())!=null){
				JOptionPane.showMessageDialog(null, "用户名已经存在!!", " 错误提示", JOptionPane.ERROR_MESSAGE);
				response.setHeader("Refresh", "2;url=/QM/register.jsp");
				return;
			}
			if(!user.getPassword1().equals(user.getPassword2())){
				
				JOptionPane.showMessageDialog(null, "两次密码不正确！", " 错误提示", JOptionPane.ERROR_MESSAGE);
				response.setHeader("Refresh", "2;url=/QM/register.jsp");
				return;
			}
			
			
			service.regist(user);
			//4.回到主页
			JOptionPane.showMessageDialog(null, "注册成功", "提示",JOptionPane.PLAIN_MESSAGE); 
			response.setHeader("Refresh", "2;url=/QM/IndexList");
			
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
		doGet(request,response);

	}

}
