<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form id="leftForm" action="<%=request.getContextPath()%>/module/layout.do" method="get">
	<input type="hidden" name="command" />
</form>
<ul>
	<li><a href="#" id="standard">스탠다드jsp</a></li>
	<li><a href="#" id="gugudan">구구단</a></li>
	<li><a href="#" id="calendar">달력</a></li>
	<li><a href="#" id="time">시간확인</a></li>
	<li><a href="#" id="image">이미지뷰어</a></li>
	<li><a href="#" id="explorer">server Explorer</a></li>
</ul>

<script type="text/javascript">
	var leftform = $('#leftForm');
	$(function(){
		$('#leftMenu a').on('click',function(){
			let command = $(this).prop('id');
			leftform.find("[name='command']").val(command);
			leftform.submit();
		});
	});
</script>