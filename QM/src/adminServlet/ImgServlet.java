package adminServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.Adopt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdoptionService;
import factory.BasicFactory;

public class ImgServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.根据id查找出商品
//			AdoptionService service = BasicFactory.getFactory().getService(
//		AdoptionService.class);
//		Adopt adopt = service.findAdoptById(request.getParameter("id"));
		//2.获取商品url,输出图片
		//String AptImage = adopt.getAptImage();
		String imgurl =request.getParameter("imgurl"); 
		request.getRequestDispatcher(imgurl).forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	
	}

	

}
