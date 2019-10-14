<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
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
<link rel="stylesheet" href="${cPath }/toastmessage/css/jquery.toastmessage.css" />	
<script type="text/javascript" src="${cPath }/toastmessage/jquery.toastmessage.js"></script>	
</head>
<body>
	<h4>${board.board_name }</h4>
	<table class="table table-bordered">
		<tr>
			<th>글제목</th>
			<td>${board.bo_title }</td>
		</tr>
		<tr>
			<th>작성자(${board.bo_pass })</th>
			<td>${board.bo_writer }</td>
		</tr>
		<tr>
			<th>아이피</th>
			<td>${board.bo_ip }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${board.bo_date }</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${board.bo_hit }</td>
		</tr>
		<tr>
			<th>추천수</th>
			<td>
				<span id="likeArea">${board.bo_like }</span>
				<c:if test="${likeable}">
					<button type="button" id="likeBtn" >추천</button>
				</c:if>
			</td>
		</tr>
		<tr>
			<th>원글번호</th>
			<td>${board.bo_parent }</td>	
		</tr>
		<tr>
			<th>첨부파일</th>
			<td>
				<c:if test="${not empty board.attatchList }">
					<c:forEach items="${board.attatchList }" 
							var="attatch" varStatus="vs">
						<c:url value="/board/download.do" var="downloadURL">
							<c:param name="what" value="${attatch.att_no }" />
						</c:url>	
						<a href="${downloadURL }" data-toggle="tooltip" 
							data-placement="top" title="다운로드 : ${attatch.att_downcount }">${attatch.att_filename }</a>
						${not vs.last?",":"" }
					</c:forEach>
					<script type="text/javascript">
						$("[data-toggle='tooltip']").tooltip();
					</script>
				</c:if>
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${board.bo_content }</td>
		</tr>
		<tr>
			<td colspan="2">
				<c:url value="/board/boardUpdate.do" var="updateURL">
					<c:param name="what" value="${board.bo_no }" />
				</c:url>
				<input type="button" class="btn btn-info" value="수정" 
					onclick="location.href='${updateURL}';"
				/>
				<input type="button" class="btn btn-info" value="삭제" 
					data-toggle="modal" data-target="#deleteBoardModal"
				/>
				<c:url value="/board/boardInsert.do" var="insertURL">
					<c:param name="bo_parent" value="${board.bo_no }" />
				</c:url>
				<input type="button" class="btn btn-info"
					value="답글쓰기" 
					onclick="location.href='${insertURL }';"	
				/>
				<input type="button" class="btn btn-info" 
						value="뒤로가기"  onclick="history.back();"/>
				<input type="button" class="btn btn-info" 
						value="목록으로"  onclick="location.href='<c:url value="/board/boardList.do"/>';"/>
				<input type="button" id="replyBtn" class="btn btn-info" value="댓글보기"/>
			</td>
		</tr>
	</table>
	<form id="insertForm" action="${cPath }/board/replyInsert.do" method="post">
		<input type="hidden" name="page" />
		<input type="hidden" name="bo_no" value="${board.bo_no }" />
		<input type="hidden" name="rep_ip" value="${pageContext.request.remoteAddr }"/>
		<table class="table col-8 ml-4">
			<tr>
			<td class="w-50">
				<input type="text" name="rep_writer" required class="form-control" placeholder="작성자"/>
			</td>
			<td class="w-50">
				<input type="password" name="rep_pass" required class="form-control" placeholder="비밀번호"/>
			</td>	
			</tr>
			<tr>
				<td colspan="2" class="align-middle">
					<textarea rows="4" cols="50" name="rep_content" class="col-10" maxlength="200" placeholder="200 자 이내"></textarea>
					<input type="submit" class="btn btn-success col-1 mb-5" value="저장" />
				</td>
			</tr>
		</table>
	</form>
	<table id="replyArea" class="table table-borderless col-8">
		<tbody id="listBody">
		
		</tbody>
		<tfoot id="pagingArea">
		
		</tfoot>
	</table>
	<form id="listForm" action="${cPath }/board/replyList.do">
		<input type="hidden" name="page"/>
		<input type="hidden" name="bo_no" value="${board.bo_no }"/>
	</form>
	<form id="deleteForm" action="${cPath }/board/replyDelete.do" method="post">
		<input type="hidden" name="page" />
		<input type="hidden" name="bo_no" value="${board.bo_no }"/>
		<input type="hidden" name="rep_no" />
		<input type="hidden" name="rep_pass" />
	</form>

<div id="deleteBoardModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
	    <div class="modal-header">
	        <h5 class="modal-title">글삭제</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
		</div>
	      <form action="${cPath }/board/boardDelete.do" method="post">
	      	  <input type="hidden" name="bo_no" id="bo_no"  value="${board.bo_no }"/>
		      <div class="modal-body">
		          <div class="form-group">
		            <input type="password" class="form-control" name="bo_pass" id="bo_pass" required placeholder="비밀번호"/>
		          </div>
		      </div>
		      <div class="modal-footer">
		        <button type="submit" class="btn btn-primary">삭제</button>
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
		      </div>
	      </form>
    </div>
  </div>
</div>	
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">댓글수정</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form id="updateForm" action="${cPath }/board/replyUpdate.do" method="post">
      	  <input type="hidden" name="page" />	
      	  <input type="hidden" name="bo_no" id="bo_no"  value="${board.bo_no }"/>
      	  <input type="hidden" name="rep_no" id="rep_no" />
	      <div class="modal-body">
	          <div class="form-group">
	            <input type="password" class="form-control" name="rep_pass" id="rep_pass" required placeholder="비밀번호"/>
	          </div>
	          <div class="form-group">
	            <label for="message-text" class="col-form-label">내용:</label>
	            <textarea class="form-control" id="rep_content" name="rep_content" maxlength="200" placeholder="200 자 이내"></textarea>
	          </div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
	        <button type="submit" class="btn btn-primary">수정</button>
	      </div>
      </form>
    </div>
  </div>
</div>
<script type="text/javascript" src="${cPath }/js/reply.js"></script>
<script type="text/javascript">
	let likeArea = $('#likeArea');
	let likeBtn = $('#likeBtn');
	let deleteBoardModal = $("#deleteBoardModal");
	
	likeBtn.on('click',function(){
		$.ajax({
			url : "${cPath}/board/boardLike.do",
			data : {
				what: ${board.bo_no}				
			},
			dataType : "text",
			success : function(resp) {
				if(resp=="OK"){
					likeArea.text(parseInt(likeArea.text().trim())+1);
					likeBtn.remove();
				}
			},
			error : function(errorResp) {
				console.log(errorResp.status);
			}
		});
	});
	
	deleteBoardModal.on("hidden.bs.modal", function(){
		$(this).find("form").get(0).reset();
	});
	deleteBoardModal.on("shown.bs.modal", function(){
		$(this).find("#bo_pass").focus();
	});
	
	<c:if test="${not empty message }">
		$(document).toastmessage('showWarningToast', '${message }');
		<c:remove var="message" scope="session"/>
	</c:if>	
</script>
</body>
</html>



