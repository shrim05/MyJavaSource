<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
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
<title>Insert title here</title>
<script type="text/javascript">
	<c:if test="${not empty message }">
			alert("${message }");
	</c:if>
	$(function(){
		var modalTag = $("#imageViewModal");
		modalTag.on("hide.bs.modal", function(){
			$(this).find(".modal-body").empty();
		});
		$(".viewImage").on("click", function(){
			var lic_code = $(this).data("code");
			var lic_name = $(this).data("name");
			modalTag.find("#imageViewModalTitle").text(lic_name+" 자격증 사본");
			modalTag.find(".modal-body").html(
				$("<img>").attr({
						src:"<c:url value='/alba/licenseImage.do?al_id=${alba.al_id}&lic_code='/>"+lic_code
						, style:"width:50%;height:50%;"		
					})	
			);
			modalTag.modal();
		});	
	});
</script>
</head>
<body>
	<!-- 한명의 알바생의 정보를 table 태그로 UI 구성 -->
	<h4>${alba.al_name }의 정보</h4>
	<table class="table table-bordered">
		<tr>
			<th>아이디</th>
			<td>${alba.al_id }</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${alba.al_name }</td>
		</tr>
		<tr>
			<th>나이</th>
			<td>${alba.al_age }</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>${alba.al_address }</td>
		</tr>
		<tr>
			<th>휴대폰</th>
			<td>${alba.al_hp }</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${alba.al_mail }</td>
		</tr>
		<tr>
			<th>성별</th>
			<td>${"M" eq alba.al_gen ? "남":"여" }</td>
		</tr>
		<tr>
			<th>혈액형</th>
			<td>${alba.al_btype }형</td>
		</tr>
		<tr>
			<th>최종학력</th>
			<td>${alba.gr_name }</td>
		</tr>
		<tr>
			<th>자격증</th>
			<td>
			<table>
				<c:forEach items="${alba.licenseList }" var="licAlba" varStatus="vs">
					<c:if test="${not empty licAlba.lic_code }">
						<tr>
							<td class="col-wd-50">${licAlba.lic_name }</td> 
							<td class="col-wd-50">
								<input type="button" class="btn btn-info viewImage" 
									value="자격증사본보기" data-code="${licAlba.lic_code }" data-name="${licAlba.lic_name }"/>
							</td>
						</tr>	
					</c:if>
				</c:forEach>
			</table>
			</td>
		</tr>
		
		<tr>
			<th>특기사항</th>
			<td>${alba.al_spec }</td>
		</tr>
		<tr>
			<th>자기소개</th>
			<td>${alba.al_desc }</td>
		</tr>
		<tr>
			<th>경력사항</th>
			<td>${alba.al_career }</td>
		</tr>
		<tr>
			<td colspan="2">
				<c:url value="/alba/albaUpdate.do" var="albaUpdateURL">
					<c:param name="who" value="${alba.al_id }" />
				</c:url>
				<c:url value="/alba/albaDelete.do" var="albaDeleteURL">
					<c:param name="who" value="${alba.al_id }" />
				</c:url>
				<input type="button" value="수정" class="btn btn-primary"
					onclick="location.href='${albaUpdateURL }';" />
				<input type="button" value="삭제"  class="btn btn-primary"
					onclick="location.href='${albaDeleteURL }';" />
				<button type="button" onclick="history.back();"  class="btn btn-primary">뒤로가기</button>	
			</td>
		</tr>
	</table>
	
<div class="modal fade" id="imageViewModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="imageViewModalTitle">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>











