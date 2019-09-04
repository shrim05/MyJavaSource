package kr.or.ddit.servlet01;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sampleProcess")
public class SampleProcessServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String numParam = req.getParameter("numParam");
		if(numParam!=null && numParam.matches("\\d+")) {
			System.out.println(Integer.parseInt(numParam) * 300);
		}
		String textParam = req.getParameter("textParam");
		String radioParm = req.getParameter("radioParam");
		String[] checkParam = req.getParameterValues("checkParam");
		String selectParam1 = req.getParameter("selectParam1");
		String[] selectParam2 = req.getParameterValues("selectParam2");
		
		
		
		Map<String, String[]> pMap = req.getParameterMap();
		Set<String> nameSet = pMap.keySet();
		Iterator<String> it = nameSet.iterator();
		while (it.hasNext()) {
			String pName = (String) it.next();
			String[] values = pMap.get(pName);
			System.out.printf("%s : %s \n",pName, Arrays.toString(values));
		}
		
		
		
//		Enumeration<String> es = req.getParameterNames();
//		
//		while (es.hasMoreElements()) {
//			String temp = (String) es.nextElement();
//			String[] tempArr = req.getParameterValues(temp);
//			System.out.println(temp + " : " + Arrays.toString(tempArr));
//			
//		}
	}
}
