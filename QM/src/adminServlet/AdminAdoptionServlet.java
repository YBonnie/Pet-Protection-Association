package adminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javabean.Adopt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdoptionService;
import factory.BasicFactory;

public class AdminAdoptionServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  //编码问题
		AdoptionService service = BasicFactory.getFactory().getService(
				AdoptionService.class);
		//1.调用Service查询所有商品
		List<Adopt> Adoptlist = service.findAllAdopt();
		System.out.print(Adoptlist);
//		把news所有数据保存到request域里面	
		request.setAttribute("Adoptlist", Adoptlist);

//		重定向回Management_adoption.jsp
	    request.getRequestDispatcher("/Administrator_interface/Management_adoption.jsp").forward(request,
				response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

	

}
