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

public class AdminDynaServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  //编码问题
		DynamicsService service = BasicFactory.getFactory().getService(DynamicsService.class);
		
		List<Dynamics> DynamicsList = service.findAllDynamics();
		
//		把news所有数据保存到request域里面	
		request.setAttribute("DynamicsList", DynamicsList);

//		重定向回Management_association_dyna.jsp
	    request.getRequestDispatcher("/Administrator_interface/Management_association_dyna.jsp").forward(request,
				response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}


}
