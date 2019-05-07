package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javabean.Admin;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.commons.beanutils.BeanUtils;

import service.AdminService;
import factory.BasicFactory;


public class AdminLogin extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  //编码问题
		AdminService service = BasicFactory.getFactory().getService(AdminService.class);		
		Admin admin = new Admin();
		try {
			String adminName = request.getParameter("username");
			String adminPwd = request.getParameter("password1");
			admin.setAd_name(adminName);
			admin.setAd_password(adminPwd);
			Admin admin2=service.getAdminByNameAndPsw(admin.getAd_name(), admin.getAd_password());
			System.out.print(admin.getAd_name());
			System.out.print(admin.getAd_password());
			
			//判断权限
			if(admin2==null||admin2.getAd_name()== adminName && admin2.getAd_password() == adminPwd){
				JOptionPane.showMessageDialog(null, "密码或帐号错误！", "错误提示", JOptionPane.ERROR_MESSAGE);
				response.setHeader("Refresh", "1;url=/QM/administrator_Login.jsp");
				return;
			}
			else
				JOptionPane.showMessageDialog(null, "登陆成功！", "提示",JOptionPane.PLAIN_MESSAGE);
			request.getSession().setAttribute("admin2", admin2);
			response.setHeader("Refresh", "1;url=/QM/AdminNewsServlet");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


}
