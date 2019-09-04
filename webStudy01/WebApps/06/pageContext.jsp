<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06/pageContext.jsp</title>
</head>
<body>
<h4>PageContext 기본객체</h4>
	: 하나의 JSP 페이지에 대한 모든 정보를 가진 객체
	
	1. 나머지 8개 기본객체를 확보
		<%=request == pageContext.getRequest() %>
		<%=response == pageContext.getResponse() %>
		<%=request.getContextPath() %> ${pageContext.request.contextPath} <!-- 표현언어에서는 pageContext외 기본객체를 사용 못하기때문에 pageContext를 통해 기본객체 사용 -->
	2. Scope를 접근할 때 
		<% 
// 			request.setAttribute("attr", "value"); 주석처리해도 아래 pageContext에서 설정.. 같은 객체 참조 
			pageContext.setAttribute("attr", "value", pageContext.REQUEST_SCOPE);
		%>
		<%= request.getAttribute("attr") %>
		<!-- pageContex 객체에 있는 다른 기본 객체의 메소드를 사용하는 방법들.. 자기 자신의 맵도 가지고있기 때문에 오버로딩된 메서드에서 scope 범위 지정(상수로 정해져있음) -->
		<%= pageContext.getAttribute("attr",pageContext.REQUEST_SCOPE) %>
	3. 흐름제어(flow control) : request dispatch 방식
		<%
			String path = "/02/standard.jsp";
// 			RequestDispatcher rd = request.getRequestDispatcher(path);
// 			rd.forward(request, response);
// 			pageContext.forward(path); //request의 dispatcher 객체도 한방에 사용가능! 
// 			rd.include(request, response);
			pageContext.include(path); //페이지 컨텍스트는 include 실행 하기전에 버퍼를 방출 시키고 페이지 이동.(1->2->4->5->6->3) 
			//에러가 나더라도 버퍼 방출 후 에러 발생하므로 따라서 예외처리가 중요해짐
		%>
	4. 에러데이터 확보

</body>
</html>