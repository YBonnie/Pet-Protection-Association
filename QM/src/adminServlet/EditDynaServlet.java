package adminServlet;

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

public class EditDynaServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  //编码问题
		DynamicsService service = BasicFactory.getFactory().getService(DynamicsService.class);
		
		 //1.获取要查询的id
		String id =request.getParameter("id");
		//2.调用Service中根据id查找客户的方法
		Dynamics dynamics = service.findDynamicsById(id);
				if(dynamics == null){
					throw new RuntimeException("找不到该协会动态信息!");
				}
				//3.将查找到的客户信息存入request域中,请求转发到AdminEditNews.jsp页面展示
				request.setAttribute("dynamics", dynamics);
				request.getRequestDispatcher("/Administrator_interface/AdminEditDynamics.jsp").forward(request, response);

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

	

}
