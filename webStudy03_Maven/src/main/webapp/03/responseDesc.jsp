<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
//  response.setContentType("text/plain");
   	response.setHeader("Content-Type", "text/html"); //정석적인 처리
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03/responseDesc.jsp</title>
</head>
<body>
<h4>Http 프로토콜의 응답 데이터 패키징 방식</h4>
<pre>
	1. Response Line 	: Status code(응답상태 코드), Protocol
		** status code : 명령에 처리 결과를 의미하는 숫자 체계
		100(since Http ver 1.1) : ING... (websocket(http 비연결성=>연결유지)ex.push메시지) => 계속 연결을 해놓겠다
			http : stateless(무상태, 비상태유지) 
		200 : OK (success)
		300 : 완전한 처리를 위해 사용자의 추가 액션이 필요한 상황.  
			304(Not Modified) (ex) 캐시 사용 시(서버에서 변경된점없으니 전송x 캐시에서 찾아봐라~=>추가적인 액션요구))
			302/307(Moved)(요청자원의 위치가 변경됨. 새로운 위치를 기준으로 요청 발생 요구)
		400 : client side fail, 
			400(Bad Request), 404(Not Found), 405(Method Not Allowed), 415(Media Not Supported)
			403(Forbidden), 401(UnAthorized) <!-- 보안관련 에러 // 인증(신원증명)/인가(신분-권한) 안됨-->  
		500 : server side fail, 500(Internal Server Error)
		=>상태코드 또한 객체 . 위 객체를 다루기 위해 아래 메소드 사용
		HttpServletResponse.setStatus / sendError(주로 이 메소드 사용)
		
	2. Response Header	: response body 의 데이터에 대한 메타 데이터
		<!-- 헤더 사용 목적에 따라-->
		1) MIME 변경 : () Content-Type
			(방법)
			- page 지시자의 contentType 속성
			- response.setContentType
			- response.setHeader
			
		2) 캐시 제어 : Pragma(Http 1.0에서 사용) (캐시 사용여부), Cache-Control(1.1) (캐시 사용여부), Expires(all) (유효기간설정)
		<%
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0); //문자열 입력시 타입안정성이 보장되지 않으므로 , 추가로 메소드 제공
			//fireFox ver40 버그 : no-cache 인식 안됨. no-store 만 인식 => 추가 메서드 제공
			response.addHeader("Cache-Control", "no-store");
			//response.setHeader("Expires", "0"); //시간 기준 1970 0101 00:00:00
		%>
		3) auto request 발생 : Refresh
			:<a href="<%=request.getContextPath()%>/03/autoRequest.jsp">/03/autoRequest.jsp 참고</a>		
		4) 페이지 이동(***)	: Location
			:<a href="${pageContext.request.contextPath}/05/flowControl.jsp">/05/flowControl.jsp</a>
	3. Response Body(MessageBody)	:
	
</pre>
<img src="<%=request.getContextPath() %>/images/Jellyfish.jpg" />
</body>
</html>