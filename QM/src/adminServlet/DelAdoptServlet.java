package adminServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import service.AdoptionService;
import factory.BasicFactory;

public class DelAdoptServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  //编码问题
		AdoptionService service = BasicFactory.getFactory().getService(
				AdoptionService.class);
		String id = request.getParameter("id");
		service.delAdoption(id);
		JOptionPane.showMessageDialog(null, "删除成功", "提示",JOptionPane.PLAIN_MESSAGE);
//		重定向回/AdminAdoptionServlet
		 request.getRequestDispatcher("/AdminAdoptionServlet").forward(request,
					response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	
	}


}
