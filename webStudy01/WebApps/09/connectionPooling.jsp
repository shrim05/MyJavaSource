<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>Connection Pooling 을 이용한 성능 향상</h4>
<pre>
	1. 메모리(공간)
	2. 소요시간(시간)
		: latency time(지연시간) + processing time(처리시간)
		
	풀링 vs 논 풀링
	1) 한번의 커넥션 한번의 처리 : 14ms => 1ms
	2) 백번의 커넥션 백번의 처리 : 1049ms 1046ms 933ms =>16ms
	3) 한번의 커넥션 백번의 처리 : 53ms 10ms => 1ms
	
	
	
</pre>
</body>
</html>