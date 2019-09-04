<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%-- <meta http-equiv="Refresh" content="10;url=https://www.naver.com"> 실제로는 응답메세지의 바디부분이지만 헤더처럼 해석시킬 수 있음 --%>
<title>03/autoRequest.jsp</title>
</head>
<body>
<h4>자동 요청을 발생시키는 방법</h4>
<span id="secArea">10</span>초 뒤에 네이버로 이동함
<pre>
	1. server side 방식 : response header 중 Refresh 사용
		<%
// 			response.setIntHeader("Refresh", 1);//1초마다 요청
			Date now = new Date();
		%>
		<%= now %>
	2. client side 방식 : 
		1)HTML : meta 태그 이용
		2)Javascript : setInterval / setTimeout
</pre>
<script type="text/javascript">
// 	var span = document.querySelector('#secArea');
// 	var seconds = 10;
// 	var jobId = setInterval(() => {
// 		span.innerHtml = --seconds ;
// 		if(second===0) clearInterval(jobId);
// 	}, 1000);
	var test = 23;
	setTimeout(function() {
		let test2 = 89;
// 		location.reload();
// 		window.history.back(); //뒤로가기
		window.history.go(1);  //앞으로가기 -1뒤로가기
	},1000);

</script>
</body>
</html>