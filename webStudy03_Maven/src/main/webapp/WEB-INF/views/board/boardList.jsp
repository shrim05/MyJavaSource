<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/bootstrap-4.3.1-dist/css/bootstrap.min.css">
<style type="text/css">
	a{
		cursor: pointer;
	}
</style>	
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
</head>
<body>
<!-- 행번호, 글번호, 제목, 작성자, 작성일, 조회수, 추천수 -->
<!-- screensize : 7, blockSize : 5 -->
<!-- 검색 조건 : 전체, 작성자, 제목, 내용 -->
<h4>자유게시판 </h4>
<table class="table table-bordered">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>추천수</th>
		</tr>
	</thead>
	<tbody id="listBody">
		<c:set var="boardList" value="${pagingVO.dataList }" />
		<c:choose>
			<c:when test="${not empty boardList }">
				<c:forEach items="${boardList }" var="board">
					<tr>
						<td>${board.rnum }</td>
						<td><a data-bono="${board.bo_no }" data-toggle="tooltip" data-placement="top" title="글번호:${board.bo_no }">${board.bo_title }</a></td>
						<td>${board.bo_writer }</td>
						<td>${board.bo_date }</td>
						<td>${board.bo_hit }</td>
						<td>${board.bo_like }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="6">
						조건에 맞는 글이 없음.
					</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="6">
				<form action="?" id="searchForm" class="form-inline justify-content-center mb-3">
					<input type="hidden" name="page" />
					<select name="searchType" class="form-control mr-2">
						<option value>전체</option>
						<option value="title">제목</option>
						<option value="writer">작성자</option>
						<option value="content">내용</option>
					</select>
					<input type="text" class="form-control mr-2" name="searchWord" />
					<input type="submit" class="btn btn-info mr-2" value="검색" />
					<input type="button" class="btn btn-info" 
						value="새글쓰기" 
						onclick="location.href='<c:url value="/board/boardInsert.do"/>';"
					/>
				</form>
				<div id="pagingArea">
					${pagingVO.pagingHTML }
				</div>
			</td>
		</tr>
	</tfoot>
</table>
<script type="text/javascript">
	var listBody = $("#listBody");
	var pagingArea = $("#pagingArea");
	var searchForm = $("#searchForm");
	var pageTag = $("[name='page']");
	
	listBody.on("click", "a", function(){
		let bono = $(this).data("bono");
		location.href="${cPath}/board/boardView.do?what="+bono;
	});
	
	$("[data-toggle='tooltip']").tooltip();
	
	var makeUI = function(resp){
		let boardList = resp.dataList;
		let trTags = [];
		$(boardList).each(function(index, board) {
			let trTag = $("<tr>").append(
							$("<td>").text(board.rnum),
							$("<td>").html(
								$("<a>").attr({
									title:"글번호 : "+board.bo_no
								})
								.data("placement", "top")
								.data("bono", board.bo_no)
								.tooltip()		
								.html(board.bo_title)
							),
							$("<td>").text(board.bo_writer),
							$("<td>").text(board.bo_date),
							$("<td>").text(board.bo_hit),
							$("<td>").text(board.bo_like)
						);
			trTags.push(trTag);
		});
		listBody.html(trTags);
		pagingArea.html( resp.pagingHTML );
		pageTag.val("1");
	}
	
	window.onpopstate = function(event){
		console.log(event);
		let pagingVO = event.state;
		if(!pagingVO) return;
		makeUI(pagingVO);
	}
	
	searchForm.on("submit", function(event){
		event.preventDefault();
		var action = $(this).attr("action");
		var method = $(this).attr("method");
		var queryString = $(this).serialize();
		$.ajax({
			url : action,
			method :method,
			data : queryString,
			dataType : "json", // REST 방식
			success : function(resp) {
				window.history.pushState(resp, "boradList", "?"+queryString);
				makeUI(resp);
			},
			error : function(errorResp) {
				console.log(errorResp.status);
			}
	
		});
		return false;
	});
	pagingArea.on("click", "a", function(event){
		event.preventDefault();
		let page = $(this).data("page");
		if(page<1) return false;
		pageTag.val(page);
		searchForm.submit();
		return false;
	});
	
</script>
</body>
</html>




