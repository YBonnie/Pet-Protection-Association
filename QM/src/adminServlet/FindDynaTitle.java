package adminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javabean.Dynamics;
import javabean.News;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DynamicsService;
import factory.BasicFactory;

public class FindDynaTitle extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		DynamicsService service = BasicFactory.getFactory().getService(DynamicsService.class);
		
		String FindDynaTitle = request.getParameter("FindDynaTitle");
		List<Dynamics> DynamicsList = service.findDynamicsTitle(FindDynaTitle);
		request.setAttribute("DynamicsList", DynamicsList);
		request.getRequestDispatcher("/Administrator_interface/Management_association_dyna.jsp").forward(request,
				response);
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}


}
