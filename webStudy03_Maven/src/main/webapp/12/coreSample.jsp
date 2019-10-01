<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
	.green{
		background-color: green;
	}
</style>
</head>

<body>
1. 구구단을 2~9(1~9) table 출력, 단 구구단의 첫번째단과 세번째 단, 마지막 단의 컬러를 green;
<table>
<c:forEach var="i" begin="2" end="9" step="1" varStatus="vs">
<c:choose>
<c:when test="${vs.count eq 1 or vs.count eq 3 or vs.last}">
	<c:set var="clz" value="green" />
</c:when>
<c:otherwise>
	<c:set var="clz" value="normal" />
</c:otherwise>
</c:choose>
<tr class="${clz}">
<c:forEach var="j" begin="1" end="9" step="1" >
<td>${i} * ${j} = ${i*j }</td>
</c:forEach> 
</tr>
</c:forEach>
</table>
2.사용자로부터 특정사이트의 url을 입력 받음. 체크박스를 통해 소스로 가져올지 여부 결정.
==>해당 사이트 크롤링
<div id="naver">

</div>
<div id="daum">

</div>
<script type="text/javascript">
var naverTag = $("#naver");
var daumTag =$("#daum");
function crawling(paramObj){
	$.ajax({
		url : "crawler.jsp",
		data : {page:paramObj.page},
		dataType : "html",
		success : function(resp) {
	// 		var keywords = $(resp).find(".PM_CL_realtimeKeyword_base");
// 			var keywords = $(resp).find(".hotissue_builtin");
			var keywords = $(resp).find(paramObj.element);
	// 		naverTag.html(keywords);
			paramObj.tag.html(keywords);
		},
		error : function(errorResp) {
			console.log(errorResp.status);
		}
	});
}

setInterval(() => {
crawling({
	page:"naver",
	element:".PM_CL_realtimeKeyword_base",
	tag:naverTag
});
crawling({
	page:"daum",
	element:".hotissue_builtin",
	tag:daumTag
});
}, 1000);
</script>
<!-- <form> -->
<%-- <c:set var="toSource" value="${param.toSource}" /> --%>
<!-- <input type="url" name="siteURL" value=${param.siteURL} />  -->
<%-- <input type="checkbox" name="toSource" value="true" ${toSource eq 'true'?"checked":"" } >소스가져오기 --%>
<!-- <input type="submit" value="확인"> -->
<!-- </form> -->
<%-- <c:if test="${not empty param.siteURL}"> --%>
<!-- <div id="result"> -->
<%-- <c:import url="${param.siteURL}"  var="site" /> --%>
<%-- <c:out value="${site}" escapeXml="${toSource eq 'true'}"/> --%>
<!-- </div> -->
<%-- </c:if> --%>
</body>
</html>