package adminServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AccountService;
import factory.BasicFactory;

public class DelAccountServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		AccountService service = BasicFactory.getFactory().getService(
				AccountService.class);
		
		String id = request.getParameter("id");
		service.delAccount(id);
//		重定向回/AdminAccountServlet
		 request.getRequestDispatcher("/AdminAccountServlet").forward(request,
					response);
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	
	}

	

}
