package adminServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommentService;
import factory.BasicFactory;

public class DelCommentsServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  //编码问题
		CommentService service = BasicFactory.getFactory().getService(
				CommentService.class);
		
		String id = request.getParameter("id");
		service.delComment(id);
//		重定向回/AdminMgmentServlet
		 request.getRequestDispatcher("/AdminMgmentServlet").forward(request,
					response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
