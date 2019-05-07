package adminServlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javabean.Account;
import javabean.Good;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import service.AccountService;
import util.IOUtils;
import factory.BasicFactory;

public class EditAccountServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		AccountService service = BasicFactory.getFactory().getService(
				AccountService.class);
		
		 //1.获取要查询的客户id
		String id =request.getParameter("id");
		//2.调用Service中根据id查找客户的方法
		Account account = service.findAccountById(id);
		if(account == null){
			throw new RuntimeException("找不到该账单!");
		}
		//3.将查找到的客户信息存入request域中,请求转发到AdminEditGoods.jsp页面展示
		request.setAttribute("account", account);
		request.getRequestDispatcher("/Administrator_interface/AdminEditAccount.jsp").forward(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	
	}

	

}
