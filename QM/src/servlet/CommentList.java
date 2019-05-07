package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import service.CommentService;
import factory.BasicFactory;
import javabean.*;

public class CommentList extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommentService service = BasicFactory.getFactory().getService(
				CommentService.class);
		
		String text = request.getParameter("comment");

		User user=(User)request.getSession().getAttribute("user2");

		if(user==null){
			JOptionPane.showMessageDialog(null, "会员请先登录!!", " 错误提示", JOptionPane.ERROR_MESSAGE);
			request.getRequestDispatcher("/sign_In.jsp").forward(request,
					response);
		}
		else{
		Comment com=new Comment();
		com.setText(text);
		com.setUser_id(user.getId());
		com.setUsername(user.getUsername());
		
		
		com.setTime(new java.sql.Timestamp(System.currentTimeMillis()));
		//com.setTime(new java.sql.Date(System.currentTimeMillis())) ;  
//		
	    
		service.addComment(com);
		List<Comment> list=service.findAllComment();
		//倒序功能
		//Collections.reverse(list);
	    request.setAttribute("list", list);
		request.getRequestDispatcher("/leave_Word.jsp").forward(request, response);
		
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
