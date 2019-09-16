<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>10/cookieDesc.jsp</title>
</head>
<body>
<h4>Cookie</h4>
<pre>
	: Http 의 statless 단점을 보완하기 위한 최소한의 상태정보가 클라이언트 쪽에 저장되는 개념
	
	쿠키 사용 단계
	서버 사이드
	1. 쿠키 객체 생성
	2. 응답에 실어 전송
	
	클라이언트 사이드
	3. 브라우저별로 쿠키 저장소에 저장
	4. 다음번 요청에 실려서 서버로 재전송
	
	서버 사이드
	5. 재전송된 쿠키 확보 
	
	** 쿠키 속성의 종류
	1. name(required) : 영문자/숫자+ _ 만 허용
	2. value(required) : 모든문자허용, 단 RFC2396규약에 따라 특수문자는 %인코딩, url인코딩 필요
	3. path(optional) : 기본값 (쿠키생성할 때 경로반영)
						path의 하위경로로 발생하는 요청에 대해서만 재전송됨.
	4. domain/host : 기본값은 쿠키생성 도메인/호스트 반영
					.naver.com 같은 형태로 특정 기관의 모든 호스트로 재전송 가능(레벨구조 적용)(동시에 path 설정도 함께 해줘야한다)
	5. maxAge : 기본값은 session의 만료 시간과 동일
			0 : maxAge를 제외한 나머지 속성들이 모두 동일한 쿠키의 경우, 삭제
		   -1 : 브라우저가 종료 시 해당 쿠키도 삭제 
				
	
	<a href="<%=request.getContextPath()%>/10/viewCookie.jsp">동일 경로에서 쿠키 확인하기</a>
	<a href="<%=request.getContextPath()%>/09/viewCookie.jsp">다른 경로에서 쿠키 확인하기</a>
	<a href="<%=request.getContextPath()%>/10/10_inner/viewCookie.jsp">동일 깊이 (하위 경로)에서 쿠키 확인하기</a>
	
	<%	
		String value = URLEncoder.encode("한글값!","UTF-8");
		Cookie cookie = new Cookie("testCookie",value);
		response.addCookie(cookie);//하나이상 가능
		Cookie targeting = new Cookie("pathCookie","specificPathCookie");
// 		targeting.setPath(request.getContextPath()+"/09");
		targeting.setPath("/"); //모든경로
		response.addCookie(targeting);
		
		Cookie allDomainCookie = new Cookie("allDomain","allDomainCookie");
// 		allDomainCookie.setDomain("mail.kwongle.com");
		allDomainCookie.setPath("/");
		response.addCookie(allDomainCookie);
		
		Cookie allLiveCookie = new Cookie("allLive","allLiveCookie");
// 		allLiveCookie.setMaxAge(60*60*24*2);
// 		allLiveCookie.setPath("/"); //maxAge 외에 다른 값이 다른 경우 다른 쿠키로 판단함 
		allLiveCookie.setMaxAge(0);
		response.addCookie(allLiveCookie);
	%>
</pre>

</body>
</html>