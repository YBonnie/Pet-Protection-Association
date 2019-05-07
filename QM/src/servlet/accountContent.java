package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.Account;
import javabean.News;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AccountService;
import factory.BasicFactory;

public class accountContent extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		AccountService service = BasicFactory.getFactory().getService(
				AccountService.class);
		
		String id = request.getParameter("id");
		Account account=service.findAccountById(id);
		request.setAttribute("account", account);
		request.getRequestDispatcher("/account_list.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	
	}

}
