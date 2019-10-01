<%@page import="java.util.Map"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="kr.or.ddit.vo.DataBasePropertyVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>08/jdbcDesc.jsp</title>
</head>
<body>
<h2>JDBC(Java DataBase Connectivity)</h2>
<pre>
	: Facade 패턴을 이용하여 데이터베이스와 자바 어플리케이션을 연결하는 방법: Driver
	(파사드 패턴: 객체를 사용할 때 직접 사용하지않고 매개체를 활용하여 이용 ex)리모컨)
	1. 벤더가 제공하는 driver 를 classpath 에 추가
	2. driver class loading (ClassLoader 사용)
	3. 로딩된 driver 를 통해 connection (개방, 연결)
	4. Query (쿼리)객체 생성  
		1) Statement : Sql injection 취약(동적쿼리)
		2) PreparedStatement : 정적 쿼리 지향 (쿼리 파리미터 활용)
		3) CallableStatement : function(함수) or 프로시저를 호출 
	5. Query 실행(SQL) :
		1) ResultSet executeQuery : select
		2) int executeUpdate : insert, update, delete (row count 반환)
	6. 질의 결과(raw data) 사용
	7**(중요). 사용한 자원 release (close) 
</pre>
<%
	Map<String, Object> dataMap = (Map) request.getAttribute("dataMap");
	List<DataBasePropertyVO> list = (List) dataMap.get("list");
	String[] headers = (String[])dataMap.get("headers");
%>
<table>
	<thead>
		<tr>
	<% 
		for(String header : headers){	
	%>
			<th><%=header %></th>
	<%
	}
	%>
		</tr>
	</thead>
	<tbody>
	<tr>
	<%
		if(list.size()>0){
			for(DataBasePropertyVO tmp : list){
	%>
		<td><%=tmp.getProperty_name()%></td>
		<td><%=tmp.getProperty_value()%></td>
		<td><%=tmp.getDescription()%></td>
		</tr>
	<%			
			}
		}else{
	%>			
		<td colspan="3"> 조회된 결과가 없음</td>
		</tr>
	<%	
		}
	%>
	</tbody>
</table>
</body>
</html>