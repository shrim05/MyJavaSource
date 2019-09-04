<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02/gugudan.jsp</title>
<style type="text/css">
table {
	border: 1px solid black;
	border-collapse: collapse;
}

tr, td {
	border: 1px solid black;
	text-align: center;
	margin: 10px;
}

.blue {
	background-color: blue;
}
</style>
</head>
<body>
	<h4>구구단</h4>
	<!-- 2~9단까지의 구구단을 table태그로 출력 -->
	<table>
	<%! private String gugudan(int dan, int mul){
			return String.format("%d*%d=%d", dan,mul,(dan*mul));
		}
		int globalMinDan = 2;
		int globalMaxDan = 9;
		private StringBuffer tonggugudan(){
			StringBuffer table = new StringBuffer();
			table.append("<table>");
			for(int dan=globalMinDan; dan<=globalMaxDan ; dan++){
				String className ="normal";
				if(dan==3){
					className = "blue"; 
				} 
				table.append("<tr class="+className+">");
				for(int mul=1;mul<10; mul++){
				table.append("<td>"+gugudan(dan,mul)+"</td>");
					}
				}
			table.append("</table>");
			return table;
		}
		%>
		<%
		String temp1 = request.getParameter("minDan");
		String temp2 = request.getParameter("maxDan");
		
		int minDan = 2;
		int maxDan = 9;
		if(temp1==null||!temp1.matches("\\d") 
				||temp2==null||!temp2.matches("\\d")){
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		minDan=Integer.parseInt(request.getParameter("minDan"));
		maxDan=Integer.parseInt(request.getParameter("maxDan"));
		globalMinDan = minDan;
		globalMaxDan = maxDan;
		for(int dan=minDan; dan<=maxDan ; dan++){
			String className ="normal";
			if(dan==3){
				className = "blue"; 
			}%> 
			<tr class=<%=className %>>
			<%
			for(int mul=1;mul<10; mul++){
				%>
			<td><%=gugudan(dan,mul) %></td>
			<%		
				}
			}
			%>
		</tr>
	</table>
	<br><br>
	<%=tonggugudan() %>
</body>
</html>