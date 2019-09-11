<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js">
</script>
</head>
<body>
	클라이언트 현재 시간 : <span id="client"></span>
	서버의 현재 시간 : <span id="server"> </span>

<script type="text/javascript">
	var client = document.querySelector("#client")
	var server = document.querySelector("#server")
	setInterval(() => {
		var now = new Date();
		client.innerHTML = now;
	    $.ajax({
	//         type: "get",
	        url: "getServerTime.jsp",
	//         data: "param=value&param2=value2",
	        dataType: "json", //Accept 요청 헤더 결정 ex) Accept:text/plain == Content-Type (따라서 응답 헤더에도 동일한 방식으로 설정해줘야함) 
	        success: function (response) {
	            server.innerHTML = response.time;
	        },
	        error: function(errorResponse) {
				console.log(errorResponse.status);
			}
	    });
	}, 1000);
</script>
</body>
</html>