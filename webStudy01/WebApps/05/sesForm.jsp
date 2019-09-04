<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.LinkedHashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>우윷빛깔 SES ↖^0^↗</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	// function eventHandler(){
	// 	let form = $('form');
	// 	let selectedOp = $('form option:selected').val();
	// 	form.submit();
	// }
$(function () {
	$('select').change(function (e) {
		var pageIndex = $('select option:selected').val();
		location.href="<%=request.getContextPath()%>"+"/"+pageIndex;
	});
})
</script>
</head>
<body>
<%	
	Map<String, String[]> memberMap = new LinkedHashMap<>(); 
	memberMap.put("a001",new String[]{"바다","/ses/bada.jsp"});
	memberMap.put("a002",new String[]{"유진","/ses/eujin.jsp"});
	memberMap.put("a003",new String[]{"슈","/ses/sue.jsp"});
%>
	<form method="post">
		<select name="sesMember" ><%//onchange="eventHandler();"%>
		<%Iterator it = memberMap.keySet().iterator();
			while(it.hasNext()){
				String memberId = (String)it.next();
				String memberName = memberMap.get(memberId)[0];
				String memberPage = memberMap.get(memberId)[1];
			%>
			<option value=<%=memberPage%>><%=memberName%></option>
		<% }%>		
		</select>
	</form>
<!-- 	1.사용자는 멤버의 개인페이지에 대한 정보를 모름 -->
<!-- 	2.사용자는 모든 요청이 sesForm.jsp에 의해 처리되는걸로 착각함. -->
<!-- 	3.각멤버의 개인페이지에서는 sesForm방향으로 전달된 파라미터를 확인할 수 있도록 할것 -->
<!--	4.멤버의 개인페이지 결과 화면에서 다른 멤버를 선택할 수 있도록 -->
<!-- 	*** -->
<!-- 	1. 현재 요청에 포함된 모든 데이터를 삭제하고 도착지로 이동 -->
<!-- 	2. 클라이언트는 최종적으로 멤버의 개인페이지의 위치를 인지할 수 있음 -->
<%
// 	String pageParam = request.getParameter("sesMember");
// 	if(StringUtils.isNotBlank(pageParam)){
// // 		RequestDispatcher rd = request.getRequestDispatcher(pageParam);
// // 		pageContext.include(pageParam);
// 		String location = request.getContextPath()+pageParam;
// 		response.sendRedirect(location);
// 	}
%>
</body>

</html>