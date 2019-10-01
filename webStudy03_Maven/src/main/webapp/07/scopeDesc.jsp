<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>07/scopeDesc.jsp</title>
</head>
<body>
<h4>Scope(영역)</h4>

<pre>
	: 웹앱내에서 데이터(attribute)를 공유하기 위한 저장공간
	=> 각 기본객체가 가진 Map&lt;String, Object&gt;
	모든 scope는 해당영역에 대한 제어를 담당하는 각 기본객체와 생명주기와 동일
	저장 공간 선택시 , 최소한의 저장 scope를 선택함
	1. page Scope : PageContext
	2. request Scope : HttpServletRequest
	3. Session Scope : HttpSession
	4. Application Scope : ServletContext
	<%
		pageContext.setAttribute("pageAttr", "페이지속성");
		request.setAttribute("requestAttr", "요청속성");
		session.setAttribute("sessionAttr", "세션속성");
		application.setAttribute("applicationAttr", "어플리케이션속성");
// 		pageContext.forward("/02/standard.jsp");
// 		request.getRequestDispatcher("/02/standard.jsp").include(request, response);
		response.sendRedirect(request.getContextPath()+"/02/standard.jsp");
	%>
	
</pre>


</body>
</html>