package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javabean.Comment;
import javabean.News;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommentService;
import factory.BasicFactory;

public class LeaveWordServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		CommentService service = BasicFactory.getFactory().getService(
				CommentService.class);
		List<Comment> list=service.findAllComment();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/leave_Word.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


}
