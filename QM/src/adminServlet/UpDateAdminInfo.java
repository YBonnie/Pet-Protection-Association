package adminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;



import javabean.Admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import service.AdminService;



import com.sun.org.apache.commons.beanutils.BeanUtils;

import factory.BasicFactory;

public class UpDateAdminInfo extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  //编码问题
		
		AdminService service = BasicFactory.getFactory().getService(AdminService.class);		
		
		try {
			String id =request.getParameter("id");
			System.out.print(id);
			//1.封装数据校验数据
			Admin admin = new Admin();
			BeanUtils.populate(admin, request.getParameterMap());
			//2.调用Service中修改客户信息的方法
			service.updateAdmin(admin);
			JOptionPane.showMessageDialog(null, "修改成功", "提示",JOptionPane.PLAIN_MESSAGE);
			//3.重定向到客户列表页面
			 request.getRequestDispatcher("/administrator_Login.jsp").forward(request,response);
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
