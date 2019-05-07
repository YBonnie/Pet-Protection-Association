package adminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javabean.Adopt;
import javabean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import service.AdoptionService;
import service.UserService;
import factory.BasicFactory;

public class FindAdoptName extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		AdoptionService service = BasicFactory.getFactory().getService(AdoptionService.class);
		
		String aptName = request.getParameter("FindAdoptName");
		List<Adopt> Adoptlist = service.AdminfindAdoptByName(aptName);
		System.out.print(Adoptlist);
		JOptionPane.showMessageDialog(null, "查找成功", "提示",JOptionPane.PLAIN_MESSAGE);
		request.setAttribute("Adoptlist", Adoptlist);
		
		request.getRequestDispatcher("/Administrator_interface/Management_adoption.jsp").forward(request,
				response);
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	
	}

	
}
