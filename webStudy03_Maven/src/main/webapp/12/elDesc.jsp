<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>14/elDesc.jsp</title>
</head>
<body>
<h4>표현언어(Expression Language)</h4>
<pre>
	:속성데이터를 표현하기 위한 목적의 스크립트 형태 언어 \${속성명 }
	<%
		String attr = "속성데이터";
		request.setAttribute("attr", "요청속성");
		pageContext.setAttribute("attr", attr);
	%>
	<%= attr %> ==> ${attr },${requestScope.attr }
	
	1. 속성데이터의 표현
	2. 연산자 지원
		1)산술연산자(+-/*) El에서는 + 는 concat연산 못함
			${1+2}, ${1+"2"} el에서는 피연산자가 아니라 연산자가 우선. + 는 concat연산을 못하기때문에 피연산자를 숫자로 인식
			${"1"+"2"}, \${"A"+"1" }=>예외발생, 
			${test }, <%=request.getAttribute("test") %>
			${test +3}, ${test1-test2}
		2)논리연산자(&&,||,!) =>(and or not)
		${true&&true }, ${true and true } , ${test and true } ,${test1 or test2 }, ${not test },
		${not test and true } 
		3)비교연산자(>,<,>=,<=,==,!=) => (gt , lt, ge, le, eq, ne)
		${3<4 },${3 lt 4 }, ${test eq 3 }, ${test1 ne test2 }
		4)단항연산자(empty)/증감연산자 사용불가
		empty : defined, null, length==0 or size==0? 을 체크함 
			<%
				pageContext.setAttribute("test", "");
				List<String> list = new ArrayList<>();
				pageContext.setAttribute("list", list);
				list.add("testValue");
			%>
		${empty test } , ${empty list }
		5)상함연산자(조건식?true:false)
		${not empty test?"있다":"없다"}
		${not empty test1 and not empty test2 ? test1+test2:"없다"}
	3. (속성으로 공유된)집합객체에 대한 접근방법
		<%
			String[] array = new String[]{"ele1","ele2"};
			pageContext.setAttribute("array", array);
			list.add("test2");
			Map<String, Object> map = new HashMap<>();
			map.put("key1","value1");
			map.put("key 2","value2");
			pageContext.setAttribute("map",map);
			Set set = new HashSet<>();
			set.add("value1");
			set.add("value2");
			pageContext.setAttribute("set",set);
			
		%>
		${array[1] },${array[6]}, 
<%-- 		<%=array[6] %> ${list.get(7)} --%> 얘는 터진다
		${list}, ${list.get(1)}, ${list[0]}
		${map }, ${map.key1 }, ${map["key 2"]}
		${set }
	4. (속성으로 공유된)객체에 대한 접근 방법
	<%
		MemberVO member = new MemberVO();
		pageContext.setAttribute("member", member);
		member.setMem_name("테스트");
	%>
	${member },${member.getMem_name() },${member.mem_name } getter를 호출
	5. EL의 기본객체(11가지)
		1)영역 (Scope) 객체 Map&lt;String,Object&gt;
		 pageScope, requestScope, sessionScope, applicationScope  =>맵
		 ${pageScope.member}, ${pageScope["member"] }
		 ${pageScope.member.mem_name},  ${pageScope["member"]["mem_name"]} , ${member.mem_name}
		 ${applicationScope.test} ${test}
		2)파라미터 객체: param(Map&lt;String,String&gt;), paramValues(Map&lt;String,String[]&gt;)
			<%=request.getParameter("param1") %>
			${param.param1},${paramValues.param1[1]}
		3)헤더 객체 : header(Map&lt;String,String&gt;), headerValues(Map&lt;String,String[]&gt;)
		${header.accept} 
		${header["user-agent"]}
		${headerValues["user-agent"]}
		
		4)쿠키객체 cookie(Map&lt;String,Cookie&gt;)
		${cookie.JSESSIONID},${cookie["JSESSIONID"]["value"]}
		${cookie.JSESSIONID.name}
		5)컨텍스트 파라미터 객체 : initParam
		<%=application.getInitParameter("service") %>
		${initParam.service }, ${initParam["service"] }
		6)pageContext
		<%=request.getContextPath() %>
		${pageContext.request.contextPath }
		${pageContext.request.method}
</pre>
</body>
</html>