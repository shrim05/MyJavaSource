package kr.or.ddit.servlet05;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/module/layout.do")
public class PageModulization extends HttpServlet {
	Properties service;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String serviceFile = getServletContext().getInitParameter("service");
		service = new Properties();
		InputStream in = getClass().getResourceAsStream(serviceFile);
		try {
			service.loadFromXML(in);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String command = req.getParameter("command");
		int status=200;
		
		if(command!=null) {
			if(!service.containsKey(command)) {
				status=HttpServletResponse.SC_NOT_FOUND;
				resp.sendError(status,"찾으시는 페이지 없음");
			}else {
				req.setAttribute("path", service.get(command));
			}
		}
		if(status==200) {
			String viewName = "/WEB-INF/views/layout.jsp";
			req.getRequestDispatcher(viewName).forward(req, resp);
		}
	}
}


