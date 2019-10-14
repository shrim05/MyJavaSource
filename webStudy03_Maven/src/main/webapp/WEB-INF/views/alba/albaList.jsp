<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/bootstrap-4.3.1-dist/css/bootstrap.min.css">
<style type="text/css">
	.error{
		color: red;
	}
</style>	
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function clickHandler(albaId){
		location.href="${pageContext.request.contextPath }/alba/albaView.do?who="+albaId;
	}
</script>
</head>
<body>
<table class="table table-striped table-bordered">
	<thead class="table-header thead-dark">
		<tr>
			<th>알바생아이디</th>
			<th>알바생이름</th>
			<th>알바생나이</th>
			<th>알바생주소</th>
			<th>알바생휴대폰</th>
		</tr>
	</thead>
	<tbody id="listBody">
		<c:set value="${pagingVO.dataList }" var="albaList" />
		<c:choose>
			<c:when test="${not empty albaList }">
				<c:forEach items="${albaList }" var="alba">
					<tr>
						<td>${alba.al_id }</td>
						<td>
							<a href="javascript:clickHandler('${alba.al_id }')">${alba.al_name }</a>
						</td>
						<td>${alba.al_age }</td>
						<td>${alba.al_address }</td>
						<td>${alba.al_hp }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="5">
						알바생 엄슴.
					</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="5">
				<form id="searchForm">
					<input type="hidden" name="searchType" value="${pagingVO.searchMap.searchType}"/>
					<input type="hidden" name="searchWord" value="${pagingVO.searchMap.searchWord }"/>
					<input type="hidden" name="page"/>
				</form>
				<div id="searchUI" class="form-inline justify-content-center mb-3">
					<select id="searchType" class="form-control mr-2">
						<option value ${empty pagingVO.searchMap.searchType ? "selected":"" }>전체</option>	
						<option value="name" ${pagingVO.searchMap.searchType eq 'name' ? "selected":"" }>이름</option>	
						<option value="address" ${pagingVO.searchMap.searchType eq 'address' ? "selected":"" }>지역</option>	
						<option value="hp" ${pagingVO.searchMap.searchType eq 'hp' ? "selected":"" }>휴대폰</option>	
					</select>
					<input  class="form-control mr-2" type="text" id="searchWord" value="${pagingVO.searchMap.searchWord }"/>
					<input id="searchBtn" class="btn btn-info mr-2" type="button" value="검색" />
					<a class="btn badge-info" 
						href="${pageContext.request.contextPath }/alba/albaInsert.do">신규등록하러 가기</a>
				</div>
				<div id="pagingArea">
				${pagingVO.pagingHTML }
				</div>
			</td>
		</tr>
	</tfoot>	
</table>
<script type="text/javascript">
var searchUI = $("#searchUI");
var searchBtn = $("#searchBtn");
var searchForm = $("#searchForm");
var pageTag = $("[name='page']");
var pagingArea = $("#pagingArea");

pagingArea.on("click", "a", function(){
	let page = $(this).data("page");
	if(page<=0) return;
	pageTag.val(page);
	searchForm.submit();
});

searchBtn.on("click", function(){
	let child = searchUI.find(":input");
	$(child).each(function(index, element){
		let id = $(this).prop("id");
		let value = $(this).val();
		searchForm.find("[name='"+id+"']").val(value);
	});
	searchForm.submit();
});
</script>
</body>
</html>
