<%@page import="sun.reflect.ReflectionFactory.GetReflectionFactoryAction"%>
<%@page import="org.apache.commons.io.IOUtils"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.InputStream"%>
<%@page import="kr.or.ddit.servlet01.DescriptionServlet"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>07/applicationDesc.jsp</title>
</head>
<body>
<h4>ServletContext application</h4>
<pre>
	: 서블릿의 어플리케이션과 서버에 대한 정보를 가진 객체
	컨텍스트 하나를 기준으로 싱글톤의 형태
	ServletContext --> <%=application.hashCode() %>
	<a href="<%=request.getContextPath() %>/gugudan">구구단 서블릿</a>
	대표적 사용용도
	1. 서버의 정보 확보 : <%=application.getServerInfo() %>
		서블릿 스펙 버전 체크 : <%=application.getMajorVersion()+"."+application.getMinorVersion() %>
	2. 로그 기록(logging) : 시스템 분석 또는 디버깅 목적
	<% 
	application.log("디버깅목적으로 기록");//현업에서는 현재 로깅 프레임워크를 사용하여 db에 기록을 남김..=>파싱작업 필요x,인덱스 자동완성, 집계 편리 
	%>
	3. 웹 리소스 확보 (http url을 통해 접근할 수 있는 리소스)
		파일시스템 절대 경로 getRealPath(uri);
		URL getResource(uri);
		입력스트림(inputStream) getResourceAsStream(uri);
		MimeText getMimeType(파일명); <%=application.getMimeType("Desert.jpg") %>
		
	**리소스를 확보하는 방법 : 변경되지 않는 주소를 기준으로
	1. File System Resource 
		<%
			//루트부터시작되는 파일시스템의 절대 경로
// 			File file1 = new File("D:/contents/Desert.jpg"); 
		%>
	2. Classpath Resource
			<%DescriptionServlet.class.getResource("Desert.jpg"); %> 
	3. Web Resource
		<%	
			String uri = "/images/Desert.jpg"; //컨텍스트 path는 배포시점에서 설치 폴더에 따라 변경됨
// 			String path = application.getRealPath(uri); //서버사이드 기준으로 경로
// 			File srcFile = new File(path);
			String path = application.getResource(uri).getFile();
			String targetUri = "/07/Desert.jpg";
			String outPath = application.getRealPath(targetUri);
// 			byte[] buffer = new byte[1024];
			File targetFile = new File(outPath);
			try(
// 			FileInputStream fis = new FileInputStream(srcFile);
			InputStream is = application.getResourceAsStream(uri);
			FileOutputStream fos = new FileOutputStream(targetFile);
			){
// 				int cnt = -1;
// 				//	Stream copy
// 				while((cnt = fis.read(buffer))!=-1){
// 					fos.write(buffer, 0, cnt);
// 				}//while end
				IOUtils.copy(is,fos);
			}
		%>
<%= path %>
<img src="<%=request.getContextPath()+targetUri %>"/>
</pre>

</body>
</html>