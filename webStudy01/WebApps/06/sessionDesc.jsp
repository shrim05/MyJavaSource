<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06/sessionDesc.jsp</title>
</head>
<body>
<h2>HttpSession</h2>
<pre>
<<<<<<< HEAD
세션:	- 시간 : 한 유저가 해당 어플리케이션을 의미있게 사용하고 있는 기간 (사용시작~종료 , WEB)
	- 통로 : 한 세션내에서 두 피어사이에 설정된 유일한 통로(주로 데이터베이스에서 사용하는 의미)
세션의 생명주기(lifecycle)
시작: 최초의 요청이 서버에 전달된 시점. 
	세션의 프로퍼티 : 생성시점, 식별자(세션아이디), 마지막 요청 시점 
	*생성시점 : <%=new Date(session.getCreationTime()) %>
	*세션아이디: <%= session.getId() %>
	*마지막요청시점: <%=new Date(session.getLastAccessedTime()) %>
	<%=session.getMaxInactiveInterval() %>s
	<%session.setMaxInactiveInterval(120); %>
	<%//내 세션이 만료되면 설정한 값도 사라짐 %>
	*재설정 후 마지막요청시점: <%=session.getMaxInactiveInterval() %>s
	<a href="sessionDesc.jsp;jsessionid=<%=session.getId()%>">세션유지를위한 링크</a>
	한 세션내에서 발생하는 요청을 식별하는 방법
	session tracking mode
	1) Cookie : JSESSIONID 같은 세션을 식별자를 포함하는 쿠키를 전송하고 저장하고 재전송하는 방법으로 식별. 
	2) URL : jsessionid 세션 파리미터를 전송하여 세션을 식별 (보안 취약함, url rewriting 문제)
	3) SSL(Secure Socket Layer) : 두피어사이의 데이터가 암호화되어 전달되며, 암호문내에 세션 식별자 포함
								: 인증서가 필요함(openSSL =>개발목적으로 사용되는 인증서. 보통은 사업자번호가 있어야 등록할 수 있음) 
종료: 
	1) 세션 만료시간 이내에 새로운 요청이 발생하지 않을 때 (톰캣:30분)
	2) 브라우저 종료 : 클라이언트쪽에서는 쿠키가 삭제됨 (서버내에서는 id가 살아있고 만료시간이 지난 후 만료)
	3) 특정 쿠키 삭제시 : " 위와 같음
	4) 명시적 로그아웃(invalidate) : 서버사이드 코드이기때문에 즉시 세션id 삭제
	세션 삭제 <%session.invalidate();%>
=======
생성시점 : <%=new Date(session.getCreationTime()) %>
세션아이디: <%= session.getId() %>
세션의 라이프사이클 : 집에서 추가
>>>>>>> branch 'master' of https://github.com/shrim05/MyJavaSource.git
</pre>
</body>
</html>