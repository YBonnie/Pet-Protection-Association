package adminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javabean.Account;
import javabean.Pet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AccountService;
import factory.BasicFactory;

public class AdminAccountServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		AccountService service = BasicFactory.getFactory().getService(
				AccountService.class);
		List<Account> AccountList = service.findAllAccount();
//		把Account所有数据保存到request域里面	
		request.setAttribute("AccountList", AccountList);
	
//		重定向回Management_account.jsp
	    request.getRequestDispatcher("/Administrator_interface/Management_account.jsp").forward(request,
				response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}



}
