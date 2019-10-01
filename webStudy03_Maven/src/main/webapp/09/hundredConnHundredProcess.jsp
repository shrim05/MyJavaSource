
<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.or.ddit.db.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>100Conn100Process</title>
</head>
<body>
<%
	long startTime = System.currentTimeMillis();
	for(int i=1 ; i<=100 ; i++){
	StringBuffer sql =new StringBuffer();
	sql.append(" SELECT MEM_ID, MEM_NAME, MEM_HP");
	sql.append(" FROM MEMBER                    ");
	sql.append(" WHERE MEM_ID = ?				");
	MemberVO mv = null;
	try(
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	){
		pstmt.setString(1, "a001");
		ResultSet rs =  pstmt.executeQuery();
		if(rs.next()){
			mv = new MemberVO();
			mv.setMem_id(rs.getString("MEM_ID"));
			mv.setMem_name(rs.getString("MEM_NAME"));
			mv.setMem_hp(rs.getString("MEM_HP"));
		}
	}
%>
<%=mv %>
<%} %>
<%=System.currentTimeMillis() - startTime%>ms
</body>
</html>