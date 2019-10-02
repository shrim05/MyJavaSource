<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>prodList</title>
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/bootstrap-4.3.1-dist/css/bootstrap.min.css">
<script type="text/javascript"
   src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
   src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script type="text/javascript"
   src="${pageContext.request.contextPath}/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/generateLprodAndBuyer.js"></script>
</head>
<body>
<form id="searchForm">
<input type="hidden" name="page" />
<input type="hidden" name="prod_lgu" value="${pagingVO.searchVO.prod_lgu }"/>
<input type="hidden" name="prod_buyer" value="${pagingVO.searchVO.prod_buyer}"/>
<input type="hidden" name="prod_name" value="${pagingVO.searchVO.prod_name}"/>

</form>
<div id="searchUI">
		<select id="prod_lgu">
			<option value>분류선택</option>
		</select>
		<select id="prod_buyer">
			<option value>거래처선택</option>
		</select>
		<input type="text" id="prod_name" value="${pagingVO.searchVO.prod_name}" >
		<input type="button" id="searchBtn" value="검색">
</div>
<c:url value="/prod/prodInsert.do" var="insertURL"/>
<button type="button" onclick="location.href='${insertURL}';">신규상품 등록</button>

<table>
	<thead>
		<tr>
			<th>상품코드</th>
			<th>상품명</th>
			<th>상품분류명</th>
			<th>거래처명</th>
			<th>구매가</th>
			<th>판매가</th>
			<th>마일리지</th>
		</tr>
	</thead>
	<tbody>
		<c:set var="prodList" value="${pagingVO.dataList }" />
		<c:forEach var="prod" items="${prodList}">
			<c:url value="/prod/prodView.do" var="viewURL" >
				<c:param name="prod_id" value="${prod.prod_id}" />
			</c:url>
			
		<tr>
			<td>${prod.prod_id}</td>		
			<td><a href="${viewURL}">${prod.prod_name}</a></td>		
			<td>${prod.lprod_nm}</td>		
			<td>${prod.buyer_name}</td>		
			<td>${prod.prod_cost}</td>		
			<td>${prod.prod_price}</td>		
			<td>${prod.prod_mileage}</td>		
		</tr>
		</c:forEach>
	</tbody>
		<tfoot>
			<tr>
				<td colspan="7">
				<div id="pagingArea">
					${pagingVO.pagingHTML}
				</div>
				</td>
			</tr>
		</tfoot>
	</table>
<script type="text/javascript">
	var searchUI = $('#searchUI');
	var prod_lguTag = $("#prod_lgu");
	var prod_buyerTag = $("#prod_buyer");
	var pageTag = $("[name='page']");
	var searchBtn = $("#searchBtn")
	var searchForm = $('#searchForm');
	var prod_name = $('#prod_name');
	$('#pagingArea').on("click","a",function(){
		var page = $(this).data("page");
		if(page<=0) return;
		pageTag.val(page);
		searchForm.submit();
	});
	$(prod_lguTag).generateLprod("${pageContext.request.contextPath}",
			"${pagingVO.searchVO.prod_lgu}");
	$(prod_lguTag).on("change", function(){
		let lguCode = $(this).val();
		if(!lguCode) return;
		$(prod_buyerTag).generateBuyer({
					cPath : "${pageContext.request.contextPath}",
					lgu : lguCode,
					selectedBuyer : "${pagingVO.searchVO.prod_buyer}"
				});
	});
	$(prod_lguTag).trigger("change");
	
	searchBtn.on("click", function(){
		let child = searchUI.find(":input");
		$(child).each(function(idx, ele){
			let id = $(this).prop("id");
			let value = $(this).val();
			searchForm.find("[name='"+id+"']").val(value);
			searchForm.submit();
		});
	});
	
</script>
</body>
</html>