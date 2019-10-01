<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/bootstrap-4.3.1-dist/css/bootstrap.min.css">
<script type="text/javascript"
   src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
   src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script type="text/javascript"
   src="${pageContext.request.contextPath}/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
<title></title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>회원아이디</th>
				<th>회원명</th>
				<th>휴대폰</th>
				<th>이메일</th>
				<th>주소</th>
				<th>마일리지</th>
			</tr>
		</thead >
		<tbody id="listBody">
		</tbody>
		<tfoot>
			<tr>
			<td colspan="6" id="pagingArea">
			</td>
			</tr>
		</tfoot>
	</table>
<script type="text/javascript">
	var listBody =$('#listBody');
	var pagingArea = $('#pagingArea');
	pagingArea.on("click","a",function(){
		let page = $(this).data("page");
		paging(page);
	});
	
	function paging(page){
		if(page<1) return false;
		$.ajax({
			data : "page="+page,
			dataType : "json",
			success : function(resp) {
	// 			code="";
				let memberList = resp.dataList;
				let trTags = [];
				$.each(memberList,function(i,v){
	// 				code += "<tr><td>"+v.mem_id+"</td><td>"+v.mem_name+"</td>"+"<td>"+v.mem_hp+"</td>";
	// 				code += "<td>"+v.mem_mail+"</td><td>"+v.mem_add1+" "+v.mem_add2+"</td><td>"+v.mem_mileage+"</td></tr>";
					let trTag = $("<tr>").append(
						$("<td>").text(v.mem_id),
						$("<td>").text(v.mem_name),
						$("<td>").text(v.mem_hp),
						$("<td>").text(v.mem_mail),
						$("<td>").text(v.mem_add1),
						$("<td>").text(v.mem_mileage)
					).prop('id',v.mem_id);
					trTags.push(trTag);
				});
				listBody.html(trTags);
				pagingArea.html(resp.pagingHTML);
			},
			error : function(errorResp) {
				console.log(errorResp.status);
			}
		});
		
	}
	
	
	$('#listBody').on("click","tr",function(){
		console.log($(this).prop('id'));
	});
	
	paging(1);
</script>
</body>
</html>