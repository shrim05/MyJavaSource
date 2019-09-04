<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>01/resourceIdentify</title>
</head>
<body>
<pre>
URI(Uniform Resource Identifier) : 
URL(Uniform Resource Locator) : 위치를 기준으로 자원 식별 (단점: 위치가 변경될 시 다른 자원이 식별될 수 있음 )
URN(Uniform Resource Name) : 자원에 이름을 부여한 후 등록, 등록된 인덱스를 이용 (단점: 중복된 이름 / 모든 자원에 대한 인덱스가 필요. 현실적으로 어려움)
URC(Uniform Resource Content) : 하나의 자원이 가질 수 있는 여러가지 속성데이터=> 컨텐츠. 컨텐츠를 가지고 식별 (기준에 따라 식별성이 떨어짐)

<% 
	String uri = request.getRequestURI();
	String url = request.getRequestURL().toString();
%>

<%= uri %>
<%= url %>

경로 표기 방식
1. 상대경로 표기 : 현재 위치를 기준으로 자원을 식별하는 방법
	ex)../images/Koala.jpg
2. 절대경로 표기 : 경로의 루트부터 전체를 표기하여 식별하는 방법
	ex) http://localhost/webStudy01/images/Koala.jpg
	현재 위치(이 주소가 사용되고 있는 위치)에서 기억된 정보는 생략가능.
	** 클라이언트 사이드 절대 경로 표기 : ip매핑 되어있는 도메인네임 이후의 모든 경로가 표기됨
	** 서버 사이드 절대 경로 표기 : context name 이 후의 모든 경로가 표기됨 
</pre>
<img src="../images/Koala.jpg" style="width:150px" />
절대경로(생략가능 정보-브라우저가 알고 있는 정보 ex: 호스트명-는 생략해서 기술 가능 => ip주소는 dns 서버에서 변환해서 전달하기 때문에 클라이언트에서 알 수 있음
따라서 생략가능)
<!-- <img src="[http:]//localhost/webStudy01/images/Koala.jpg" style="width:300px" /> -->
<img src="/webStudy01/images/Koala.jpg" style="width:300px" /> 


</body>
</html>