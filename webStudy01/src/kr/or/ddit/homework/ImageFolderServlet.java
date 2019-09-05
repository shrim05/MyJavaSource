package kr.or.ddit.homework;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

@WebServlet("/ImageFolderServlet")
public class ImageFolderServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = request.getServletContext();
		Map<String, String> fileMap = new HashMap<>();
		Set images = context.getResourcePaths("/images");
		Iterator it = images.iterator();
		while(it.hasNext()) {
			String webResourcePath = it.next().toString();
			String filePath = context.getRealPath(webResourcePath);
			String type = context.getMimeType(webResourcePath);
			if(type.equals("image/jpeg")) {
				String imgFileName = webResourcePath.substring(webResourcePath.lastIndexOf('/')+1,webResourcePath.length());
				fileMap.put(webResourcePath,imgFileName);
			}
		}
		
		String result = (String) request.getAttribute("result");
		if(result!=null) {
			request.setAttribute("result", result);
		}
		request.setAttribute("images", fileMap);
		
		String path = "/WEB-INF/views/imagesFolderView.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String command = request.getParameter("command");
		String filePath = request.getParameter("fileName");
		IImageService service =  ImageServiceImpl.getInstance();
		if(command!=null) {
			if(StringUtils.isNotBlank(command)||StringUtils.isNotBlank(filePath)) {
				if(command.equals("COPY")) {
					service.copy(request, response);
				}else if(command.equals("MOVE")) {
					service.move(request, response);
				}else if(command.equals("DELETE")) {
					service.delete(request, response);
				}
			}//blankCheckEnd
			else {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST,"파일명 또는 명령이 올바르지않음");
			}
		}//command null check end
		else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST,"명령 선택이 올바르지않음");
		}
	}

}
