package kr.or.ddit.homework;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

public class ImageServiceImpl implements IImageService {
	
	private static ImageServiceImpl service= null;
	
	private ImageServiceImpl() {
		super();
	}
	
	public static ImageServiceImpl getInstance() {
		if(service==null) {
			service = new ImageServiceImpl();
		}
		return service;
	}

	@Override
	public void copy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = request.getServletContext();
		String filePath = request.getParameter("fileName");
		String targetUri = "/07"+filePath;
		String outPath = context.getRealPath(targetUri);
		File targetFile = new File(outPath);
		try(
			InputStream is = context.getResourceAsStream(filePath);
			FileOutputStream fos = new FileOutputStream(targetFile);
		){
			IOUtils.copy(is, fos);
		}
		request.setAttribute("result","copy");
		ImageFolderServlet servlet = ImageFolderServlet.getInstance();
		servlet.doGet(request, response);
	}

	@Override
	public void move(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		String filePath = request.getParameter("fileName");
		String targetUri = "/07"+filePath;
		String outPath = context.getRealPath(targetUri);
		File targetFile = new File(outPath);
		
		try(
			InputStream is = context.getResourceAsStream(filePath);
			FileOutputStream fos = new FileOutputStream(targetFile);
		){
			IOUtils.copy(is, fos);
		}
		File deleteFile = new File(context.getRealPath(filePath));
		deleteFile.delete();
		request.setAttribute("result","move");
		ImageFolderServlet servlet = ImageFolderServlet.getInstance();
		servlet.doGet(request, response);
	}

	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		String filePath = request.getParameter("fileName");
		File deleteFile = new File(context.getRealPath(filePath));
		deleteFile.delete();
		request.setAttribute("result","delete");
		ImageFolderServlet servlet = ImageFolderServlet.getInstance();
		servlet.doGet(request, response);
		
	}
}
