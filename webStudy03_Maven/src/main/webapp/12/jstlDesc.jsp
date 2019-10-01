<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>12/jstlDesc</title>
<style type="text/css">
	.red{
		background-color: red;
	}
</style>
</head>
<body>
<h4>JSTL(Jsp Standard Tag Library)</h4>
<pre>
	: 커스텀 태그의 집합 라이브러리
	
	1. 빌드패스에 jar 추가
	2. taglib 지시자를 이용해 커스텀 태그 로딩 
	3. &lt;prefix:tagname &gt;
	JSTL 종류
	1. Core 태그 (c접두어)
	 1)EL변수 (속성) 지원 : set(생성, 할당), remove(삭제)
	 	** remove 시 반드시 scope 를 설정할 것.
	<c:set var="data" scope="page" value="3" />
	${data * 3 }
<%-- 	 <% pageContext.setAttribute("data", 3); %> --%>
	<c:remove var="data" scope="request"/> <%//scope 미설정시 모든 스코프의 같은 이름 다 지움 %>
	${data }
	<c:remove var="data" scope="page"/> <%//scope 미설정시 모든 스코프의 같은 이름 다 지움 %>
	${data }
	<c:set var="test" value="테스트" />
	2. 조건문(단일, 다중), 반복문
	if : 단일 조건문 (else가 없어서 두번의 if문이 필요함. test 속성에 조건식이 들어감)
	<c:if test="${empty test }">
		test는 없다
	</c:if>
	else 가 없어서 if문 두번 써야함
	<c:if test="${not empty test }">
		test는 있다
	</c:if>
	choose
	<c:choose>
		<c:when test="${empty test}">
			test 없다
		</c:when>
		<c:otherwise>
			test 있다
		</c:otherwise>
	</c:choose>
	forEach
		for(선언절; 조건절; 증감절)
		<c:forEach var="i" begin="1" end="10" step="2" varStatus="vs" >
			${i}
			<span>index: ${vs.index }, count:${vs.count }</span>
		</c:forEach>
		for(임시블럭변수 :반복대상 컬렉션)
		<c:set var="array" value='<%=new String[]{"a","b","c"} %>' />
		${array[0] }
		
		LoopTagStatus 객체
			int : begin, end, step, index, count
			boolean : first, last
		<c:forEach items="${array}" var="element" varStatus="vs" >
			<c:if test="${vs.count eq 2 }">
				<c:set var="clzName" value="red" />
			</c:if>
			<c:if test="${vs.count ne 2 }">
				<c:set var="clzName" value="normal" />
			</c:if>
			<span class="${clzName }">${element } ${not vs.last ?"," :"" }</span>
		</c:forEach>
	forTokens
	ex) int i = 4;
	<c:forTokens items="아버지 가방에 들어가신다" delims=" " var="token">
		${token }
	</c:forTokens>
	
	3) URL 재처리 : url, redirect 주소를 클라이언트에서 서버사이드 방식 처럼 쓸 수 있게해줌
	<c:url value="/member/memberView.do" var="viewURL">
		<c:param name="param1" value="value1"/>
		<c:param name="param2" value="value2"/>
	</c:url>
	${viewURL }
<%-- 	<c:redirect url="/02/standard.jsp" /> --%>
	
	4) 기타: import, out
	<c:out value="<span>태그바디</span>" escapeXml="false" />
	<c:import url="https://www.naver.com"  var="naver" />
	<c:out value="${naver }" />
<%-- <jsp:include page="https:www.naver.com" />  같은 컨텍스트 내부에서만 처리--%>
</pre>

</body>
</html>