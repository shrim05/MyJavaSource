package kr.or.ddit.servlet04;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.servlet04.service.DataBasePropertyServiceImpl;
import kr.or.ddit.servlet04.service.IDataBasePropertyService;

@WebServlet("/jdbcDesc")
public class JdbcDescControllerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IDataBasePropertyService service = new DataBasePropertyServiceImpl();
		
		Map<String, Object> dataMap = new HashMap<>();
		service.readAndLoggingDataBaseProperty(dataMap);
		
	 	req.setAttribute("dataMap",	dataMap);
		
		String view = "/WEB-INF/views/jdbcDesc.jsp";
		req.getRequestDispatcher(view).forward(req, resp);;
		
	}
}
