package adminServlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javabean.Dynamics;
import javabean.News;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import service.DynamicsService;
import util.IOUtils;
import factory.BasicFactory;

public class AddDynaServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  //编码问题
		DynamicsService service = BasicFactory.getFactory().getService(DynamicsService.class);
		
		try {
			
			String encode = this.getServletContext().getInitParameter("encode");
			Map<String, String> paramMap = new HashMap<String,String>();
			//1.上传图片
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1024*100);
			factory.setRepository(new File(this.getServletContext().getRealPath("WEB-INF/temp")));
			
			ServletFileUpload fileUpload = new ServletFileUpload(factory);
			fileUpload.setHeaderEncoding(encode);
			fileUpload.setFileSizeMax(1024*1024*1);
			fileUpload.setSizeMax(1024*1024*10);
			
			if(!fileUpload.isMultipartContent(request)){
				throw new RuntimeException("请使用正确的表单进行上传!");
			}
	
			List<FileItem> list = fileUpload.parseRequest(request);
			for(FileItem item : list){
				if(item.isFormField()){
					//普通字段
					String name = item.getFieldName();
					String value = item.getString(encode);
					paramMap.put(name, value);
				}else{
					//文件上传项
					String realname = item.getName();
					String uuidname = UUID.randomUUID().toString()+"_"+realname;

					String hash = Integer.toHexString(uuidname.hashCode());
					String upload = this.getServletContext().getRealPath("WEB-INF/upload");
					String dynamics_img = "/WEB-INF/upload";
					for(char c : hash.toCharArray()){
						upload+="/"+c;
						dynamics_img+="/"+c;
					}
					dynamics_img +="/"+uuidname;
					paramMap.put("dynamics_img", dynamics_img);
					
					File uploadFile = new File(upload);
					if(!uploadFile.exists())
						uploadFile.mkdirs();
					
					InputStream in = item.getInputStream();
					OutputStream out = new FileOutputStream(new File(upload,uuidname));
					
					IOUtils.In2Out(in, out);
					IOUtils.close(in, out);
					
					item.delete();
					
                }
				
			}
			Dynamics dynamics = new Dynamics();
			BeanUtils.populate(dynamics, paramMap);
			service.addDynamics(dynamics);
			JOptionPane.showMessageDialog(null, "协会动态添加成功", "提示",JOptionPane.PLAIN_MESSAGE); 
			response.setHeader("Refresh", "2;url=/QM/AdminDynaServlet");		
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}


}
