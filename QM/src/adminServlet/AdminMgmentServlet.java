package adminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import javabean.Comment;
import javabean.Pet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommentService;
import factory.BasicFactory;

public class AdminMgmentServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  //编码问题
		CommentService service = BasicFactory.getFactory().getService(
				CommentService.class);
	
		
		List<Comment> CommentList = service.findAllComment();
//		把user所有数据保存到request域里面	
		//Collections.reverse(CommentList);
		request.setAttribute("CommentList", CommentList);
		
//		重定向回Management_message.jsp
	    request.getRequestDispatcher("/Administrator_interface/Management_message.jsp").forward(request,
				response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	
	}


}
