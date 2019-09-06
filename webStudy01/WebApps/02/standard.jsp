<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02/standard.jsp</title>
</head>
<body>
<h4>JSP 표준 구성 요소</h4>
Scope practice
<div style="background-color: yellow;">
<%= pageContext.getAttribute("pageAttr")%><br>
<%= pageContext.getAttribute("requestAttr", PageContext.REQUEST_SCOPE)%><br>
<%= pageContext.getAttribute("sessionAttr",pageContext.SESSION_SCOPE)%><br>
<%= application.getAttribute("applicationAttr")%><br>
</div>

<pre>
	1. 정적 텍스트 : 텍스트, HTML , CSS, Javascript
	2. JSP 스크립트 요소 : <% %>
		1) directive(지시자) &lt;%@ 지시자명 지시자속성들%&gt;
			지시자종류
			- page(required) : JSP 페이지에 대한 설정 정보(전처리)를 명시 
			- include(optional) : 정적 내포 
			- taglib(optional) : 태그 라이브러리를 사용할 때
		2) scriptlet(스크립트릿요소) <% //java code %>
		<% 
		//스크립트릿 요소안의 코드는 지역변수화됨 (service메서드 아래)
// 			System.out.println("출력 where?" + request.getServerName());
			String today = new Date().toString();
		%>
		3) expression(표현식)	:  <%= today %>
							: 응답 데이터로 출력할 요소에 사용
		4) declaration(선언부) : 전역변수나 메소드 선언에 사용
		 <%! 
		 	Date globalToday;
			public void test(){
				
			}
		 %> 	
		5) comment(주석)	<%-- --%>
			- client side : HTML, Javascript
			- server side : Java, JSP
			
	3. 기본 객체(9가지)
	4. JSP 액션태그
	5. EL(표현언어)
	6. JSTL
	<%
// 	if(1==1)
// 	throw new NullPointerException("강제발생예외");
	%>
	
		
html
<!-- 			test -->
script
<script type="text/javascript">
// 	test
</script>

java 
<% 
// test
%>

jsp <%-- <% test %> --%>
		
</pre>

</body>
</html>