package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.Dynamics;
import javabean.News;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DynamicsService;
import factory.BasicFactory;

public class dynaContentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		DynamicsService service = BasicFactory.getFactory().getService(
				DynamicsService.class);
		String id = request.getParameter("id");
		Dynamics dynamics=service.findDynamicsById(id);
		request.setAttribute("dynamics", dynamics);
		request.getRequestDispatcher("/association_Dynamics_content1.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}


}
