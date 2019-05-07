package adminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javabean.Comment;
import javabean.Pet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommentService;
import factory.BasicFactory;

public class FindCommentTimer extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  //编码问题
		CommentService service = BasicFactory.getFactory().getService(
				CommentService.class);
		
		String CommentTimer = request.getParameter("FindCommentTimer");
		System.out.print(CommentTimer);
		List<Comment> CommentList = service.findCommentTimer(CommentTimer);
		request.setAttribute("CommentList", CommentList);
		request.getRequestDispatcher("/Administrator_interface/Management_message.jsp").forward(request,
				response);
	
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
