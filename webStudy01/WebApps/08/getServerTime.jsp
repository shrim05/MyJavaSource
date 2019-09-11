<%@page import="java.util.Date"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String now  = new Date().toString();
%>
{	,
	"time":"<%=now %>"
}