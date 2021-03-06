package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import factory.BasicFactory;

public class LogoutServlet extends HttpServlet {



	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  //编码问题
		//对于get提交只能手动的解决
		UserService service = BasicFactory.getFactory().getService(UserService.class);
		if(request.getSession(false)!=null){
			request.getSession().invalidate();
		}
		response.sendRedirect(request.getContextPath()+"/IndexList");

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
