<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%! 
	long factorial(int leftOp){
		if(leftOp<=0) throw new IllegalArgumentException("피연산자 확인 : " + leftOp);
		if(leftOp==1){
			return 1;
		}else{
			return leftOp * factorial(leftOp-1);
		}
	}
%>
<%
	request.setCharacterEncoding("UTF-8");
	String leftParam = request.getParameter("leftOp");
	long result = -1;
	if(leftParam != null && leftParam.matches("^1?[0-9]$")){
		int leftOp = Integer.parseInt(leftParam);
		result = factorial(leftOp);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03/factorial</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js">
</script>
</head>
<body>
재귀호출구조. rescursive call
action , href 처럼 다음요청의 주소를 기술하는 속성에 값이 생략되면 현재 주소가 그대로 반영된다
	<form id="facForm" >
		피연산자 : <input type="number" name="leftOp" min="1" max="99" />
				<input type="submit" value="submit">
				<input type="reset" value="reset">
				<input type="button" value="button">
	
	</form>

<%if(result!=-1){ %>
<div>
	<%= String.format("%s != %d", leftParam, result) %>
</div>
<%} %>
</body>
<script type="text/javascript">
	$('#facForm').on('submit', (event)=>{
		var form = event.target;
		console.log(form);
		console.log(form.leftOp);
		console.log(form.leftOp.value);
		var leftOp = form.leftOp.value;
		console.log(typeof leftOp);
		//1~19
		var regex = /^1?[0-9]$/igm;//ignore case m//multi Line;
		var valid =regex.test(leftOp) 
		if(!valid){
			alert('피연산자 부정확함');
		}
		return valid;
	});
</script>
</html>