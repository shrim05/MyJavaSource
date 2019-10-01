<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>01/requestDesc.jsp</title>
<script type="text/javascript">
	console.log('testing');
</script>
</head>
<body>
	<h4>HttpServletRequest 의 메소드</h4>
	<pre>
		characterEncoding : <%=request.getCharacterEncoding() %>
		contentLength :  <%=request.getContentLength() %>
		contentType :  <%=request.getContentType() %> : body message mime
		contextPath	: <%=request.getContextPath() %> clinet side 절대 경로에 사용
		requestURI : <%= request.getRequestURI() %>
		 <!-- 서버쪽(서버사이드 언어.. 로컬기준은 서버가 됨 -->
		Server Info
		localAddr : <%=request.getLocalAddr() %>
		localName : <%=request.getLocalName() %>
		localPort : <%=request.getLocalPort() %>
		<!-- 클라이언트에 대한 정보 -->
		Client Info
		remoteAddr : <%=request.getRemoteAddr() %>
		remoteHost : <%=request.getRemoteHost() %>
		remotePort : <%=request.getRemotePort() %>
		queryString : <%=request.getQueryString() %>
		serverName : <%=request.getServerName() %>
		serverPort : <%=request.getServerPort() %>
		servletContext : <%= request.getServletContext().hashCode() %>
		<%=request.getServletContext().getContextPath() %>
	</pre>
	<img src="../images/Jellyfish.jpg" style="width:100px">
	<img src="<%=request.getContextPath()%>/images/Jellyfish.jpg">
</body>
</html>