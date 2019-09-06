package kr.or.ddit.servlet02;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.enums.CommandType;

@WebServlet("/imagesFolderProcess")
public class ImageViewerModel2Servlet extends HttpServlet{
	private ServletContext application;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		application = getServletContext(); 
		String imagesURI = "/images";
		String imagesPath = application.getRealPath(imagesURI);
		String targetURI = "/07";
		String targetPath = application.getRealPath(targetURI);
		File imagesFolder = new File(imagesPath);
		File targetFolder = new File(targetPath);
		application.setAttribute("imagesFolder", imagesFolder);
		application.setAttribute("targetFolder", targetFolder);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		File imagesFolder = (File)application.getAttribute("imagesFolder");
		File targetFolder = (File)application.getAttribute("targetFolder");
		String[] files = imagesFolder.list((dir, name)->{
										String mime = application.getMimeType(name);
										return mime!=null && mime.startsWith("image/");
									});
		String[] targetFiles = targetFolder.list();
		req.setAttribute("imageFiles", files);
		req.setAttribute("targetFiles", targetFiles);
		String view = "/WEB-INF/views/imagesFolderView.jsp";
		req.getRequestDispatcher(view).forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String filename = req.getParameter("filename");
		String command = req.getParameter("command");
		int status = 200;
		if(StringUtils.isBlank(filename) || StringUtils.isBlank(command)) {
			status = HttpServletResponse.SC_BAD_REQUEST;
			resp.sendError(status);
		}else {
			File imagesFolder = (File)application.getAttribute("imagesFolder");
			File imageFile = new File(imagesFolder, filename);
			if(!imageFile.exists()) {
				status = HttpServletResponse.SC_NOT_FOUND;
				resp.sendError(status);
			}
			try {
				CommandType commandType = CommandType.valueOf(command);
				if(status==200) {
					File targetFolder = (File)application.getAttribute("targetFolder");
					commandType.commandProcess(imageFile, targetFolder);
				}
			}catch(IllegalArgumentException e) {
				status = HttpServletResponse.SC_BAD_REQUEST;
				resp.sendError(status);
			}
			if(status==200) {
				resp.sendRedirect(req.getContextPath()+"/imagesFolderProcess");
			}else {
				resp.sendError(status);
			}
		}
	}
}
