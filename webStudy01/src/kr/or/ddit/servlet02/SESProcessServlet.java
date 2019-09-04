package kr.or.ddit.servlet02;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

/**
 * Servlet implementation class SESProcessServlet
 */
@WebServlet("/sesProcess")
public class SESProcessServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sesMember = request.getParameter("sesMember");
		Map<String, String[]> memberMap = new LinkedHashMap<>(); 
		memberMap.put("a001",new String[]{"바다","/ses/bada.jsp"});
		memberMap.put("a002",new String[]{"유진","/ses/eujin.jsp"});
		memberMap.put("a003",new String[]{"슈","/ses/sue.jsp"});
		if(StringUtils.isNotBlank(sesMember)){
			if(!memberMap.containsKey(sesMember)){
				response.sendError(HttpServletResponse.SC_NOT_FOUND, "해당 멤버는 존재하지 않음");
				return;
			}
			String[] record = memberMap.get(sesMember);
//	 		String path = "/WEB-INF"+record[1];
			String path = "/05"+record[1];
			//WEB-INF 폴더 아래로 리소스가 위치된다면 클라이언트 쪽에서는 접근이 불가, 따라서 서버사이드에서 이동이 가능하도록 dispatch방식으로 설계해야함
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
//	 		rd.include(request, response);
//	 		response.sendRedirect(request.getContextPath()+path);
			return;
		}else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST,"멤버선택이 올바르지 않음");
		}
	}

}
