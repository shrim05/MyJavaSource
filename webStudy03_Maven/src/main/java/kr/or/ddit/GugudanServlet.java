package kr.or.ddit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gugudan")
public class GugudanServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		try(
//			InputStream is = req.getInputStream();
//			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//			
//			){
//				String tmp = null;
//				while ((tmp = reader.readLine())!=null) {
//					System.out.printf("=======>%s\n", tmp);
//				}	
//		}
		String minParam = req.getParameter("minDan");
		String maxParam = req.getParameter("maxDan");
		//검증
		int minDan = 2;
		int maxDan = 9;
		if(minParam!=null && minParam.matches("[0-9]{1,2}")&&
				maxParam!=null && maxParam.matches("[0-9]{1,2}")) {
			minDan = Integer.parseInt(minParam);
			maxDan = Integer.parseInt(maxParam);
		}
		
		resp.setContentType("text/html;charset=UTF-8");
		StringBuffer template = readTemplate("gugudan.tmpl");
	
		StringBuffer gugudan = new StringBuffer();
		
		for (int i = minDan; i <= maxDan; i++) { 
			gugudan.append("<tr>");
			for (int j = 1; j < 10; j++) {
				int result = i * j;
				gugudan.append("<td>");
				gugudan.append(i + " * " + j + " = "+ result +"</td>");
			}
			gugudan.append("</tr>");
		}
		
		int idx = template.indexOf("@gugudan");
		StringBuffer html = template.replace(idx, idx+"@gugudan".length(), gugudan.toString());
		idx = html.indexOf("@cnt");
		html = html.replace(idx, idx+"@cnt".length(), (9-1+1)+"");
		
		
		try(
			PrintWriter out = resp.getWriter();
		){
			out.println(html);
			out.println(getServletContext().hashCode());
		}
	}

	private StringBuffer readTemplate(String name) throws IOException {
		StringBuffer template = new StringBuffer();
		try(
		InputStream is = GugudanServlet.class.getResourceAsStream("gugudan.tmpl");
		BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8")); //InputStreamReader 어댑터 (바이트 캐릭터 타입간 중간매개)
		){	
			String tmp = null;
			while((tmp=reader.readLine())!=null){
				template.append(tmp + "\n");
			}
		}
		return template;
	}
}
