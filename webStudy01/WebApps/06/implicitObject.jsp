<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06/implicitObject.jsp</title>
</head>
<body>
<h4>기본(내장)객체</h4>
<pre>
	:JSP 컨테이너에 의해 서블릿 소스가 파싱될 때 기본 제공되는 객체(_JSPService 메소드의 지역변수 형태)
	***PageContext pageContext <a href="<%=request.getContextPath()%>/06/pageContext.jsp"> /06/pageContext.jsp</a>
	HttpServletRequest request : http 프로토콜의 요청에 대한 정보를 캡슐화
	HttpServletResponse response : http 프로토콜의 응답에 대한 정보를 캡슐화
	JSPWriter out : 한 JSP페이지의 출력 버퍼에 대한 정보를 캡슐화
	HttpSession session : 한 유저가 한브라우저를 이용한 상황에서 해당 유저에 대한 정보를 캡슐화
		세션 : 유저가 어플리케이션을 사용하고 있는 기간(시간) +
			  해당 기간내에 두 피어사이에 의미있게 형성된 통로
			 http stateless 단점을 보완하기 위한 최소한의 상태 정보를 서버상에서 유지
			 <a href="${pageContext.request.contextPath}/06/sessionDesc.jsp">/06/sessionDesc.jsp</a>
	ServletContext application : 어플리케이션(컨텍스트)과 서버에 대한 정보를 캡슐화
			 <a href="<%=request.getContextPath() %>/07/applicationDesc.jsp">/06/sessionDesc.jsp</a>
	
	ServletConfig config : 서블릿에 대한 메타데이터 객체(JSP에서는 별 쓸일이 없음)
	Object page : this (현재 페이지 인스턴스 자체)
	Throwable exception : 어플리케이션에서 발생할 수 있는 모든 비정상적인 상황에 대한 정보 => 에러 /예외 캡슐화 (에러처리 페이지(isErrorPage="true")에서 에러 객체 사용)
	
	ServletContext --> <%=application.hashCode() %>
	 
</pre>
</body>
</html>