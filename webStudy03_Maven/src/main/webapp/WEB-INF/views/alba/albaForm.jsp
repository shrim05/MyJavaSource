<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>02/albaForm.jsp</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/bootstrap-4.3.1-dist/css/bootstrap.min.css">
<style type="text/css">
	.error{
		color: red;
	}
	.matched{
		display: none;
	}
</style>	
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function(){
		let imageArea = $("#imageArea");
		let lic_codes = $("[name='lic_codes']");
		//기존 자격증 삭제 처리시 테스트 코드
		$(".delBtn").on("click", function(){
			var delLic_code = $(this).data("code");
			$("#albaForm").append(
					$("<input>").attr({
						type:"text"
						, name:"deleteLic_codes"
						, value:delLic_code
					})
			);
			$(this).closest("span").remove();
			$(lic_codes).find("[value='"+delLic_code+"']").removeClass("matched");
		});	
		$("[name='lic_codes']").on("blur", function(){
			$(this).nextAll("[name='lic_images']").remove();
			imageArea.empty();
			var selectTag = $(this);
			var options = $(this).val();
			$(options).each(function(idx, optVal){
				selectTag.after(
					$("<input>").attr({
						type:"file"
						, 'class':"form-control"
						, name:"lic_images"
						, required:true
						, id:"file_"+idx
					})	
				);
				imageArea.prepend(
					$("<img>").hide()
							  .addClass("file_"+idx)
							  .css({width:"100px", height:"100px"})
				);
			});
		});
		
		$("#licenseArea").on("change", "[type='file']", function(){
			var files = $(this).prop("files");
			var id = $(this).prop("id");
			if(!files) return;
			for(var idx in files){
				let reader = new FileReader();
				reader.onloadend = function(event){
					let imgTag = imageArea.find("."+id);
					imgTag.attr("src", event.target.result);
					imgTag.show();
				}
				reader.readAsDataURL(files[idx]);
			}
		});
	});
</script>
</head>
<body>
<h4>알바천국 가입 및 수정 양식</h4>
<form method="post" id="albaForm" enctype="multipart/form-data">
<input type="hidden" name="al_id" value="${alba.al_id }" />
	<table class="table table-bordered">
			<tr>
				<th>이름</th>
				<td>
				<div class="form-group form-inline">
				<input type="text" name="al_name" required class="form-control col-6"
					value="${alba.al_name }" />
				<span class="error form-control-plaintext col-6">${errors["al_name"] }</span></div></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><div class="form-group form-inline"><input type="text" name="al_age" required class="form-control col-6"
					value="${alba.al_age }" />
				<span class="error form-control-plaintext col-6">${errors["al_age"] }</span></div></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><div class="form-group form-inline"><input type="text" name="al_address" required class="form-control col-6"
					value="${alba.al_address }" />
				<span class="error form-control-plaintext col-6">${errors["al_address"] }</span></div></td>
			</tr>
			<tr>
				<th>휴대폰</th>
				<td><div class="form-group form-inline"><input type="text" name="al_hp" required class="form-control col-6"
					value="${alba.al_hp }" />
				<span class="error form-control-plaintext col-6">${errors["al_hp"] }</span></div></td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
				<div class="form-check form-check-inline">
					<input type="radio" name="al_gen" id="al_gen_m" value="M" class="form-check-input"
						${empty al_gen or "M" eq alba.al_gen?"checked":"" } />
							<label for="al_gen_m"  class="form-check-label">남</label>
				</div>			
				<div class="form-check form-check-inline">
					<input type="radio" name="al_gen" id="al_gen_f" value="F" class="form-check-input"
							${"F" eq alba.al_gen ? "checked":"" } /><label for="al_gen_f" class="form-check-label">여</label>
				</div>
				<span class="error">${errors["al_gen"] }</span></td>
			</tr>
			<tr>
				<th>혈액형</th>
				<td>
					<select name="al_btype" required  class="form-control col-6">
						<option value="A"  ${"A" eq alba.al_btype ? "selected":"" }>A형</option>
						<option value="B"  ${"B" eq alba.al_btype ? "selected":"" }>B형</option>
						<option value="AB" ${"AB" eq alba.al_btype ? "selected":"" }>AB형</option>
						<option value="O"  ${"O" eq alba.al_btype ? "selected":"" }>O형</option>
					</select>
				<span class="error form-control-plaintext col-6">${errors["al_btype"] }</span>
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><div class="form-group form-inline"><input type="text" name="al_mail" required  class="form-control col-6"
					value="${alba.al_mail }" />
				<span class="error form-control-plaintext col-6">${errors["al_mail"] }</span></div></td>
			</tr>
			<tr>
				<th>최종학력</th>
				<td><div class="form-group form-inline">
					<select name="gr_code"  class="form-control col-6">
						<c:forEach items="${grades }" var="grade">
							<option value="${grade.gr_code }" ${grade.gr_code eq alba.gr_code ? "selected":"" }>${grade.gr_name }</option>
						</c:forEach>
					</select>
					<script>
						$("[name='al_grade']").val("${alba.gr_code }");
					</script>
				<span class="error form-control-plaintext col-6">${errors["gr_code"] }</span></div></td>
			</tr>
			<tr>
				<th>자격증</th>
				<td>
					<c:forEach items="${alba.licenseList }" var="licAlba" varStatus="vs">
						<c:if test="${not empty licAlba.lic_code }">
							<span>
								${licAlba.lic_name } 
								<input type="button" class="btn btn-info delBtn" value="삭제" 
										data-code="${licAlba.lic_code }"/>
								${!vs.last?"|":"" }
							</span>
						</c:if>
					</c:forEach>
				<div id="licenseArea" class="row">	
					<div class="form-group col-6">
						<select name="lic_codes" class="form-control" multiple size="6">
							<c:forEach items="${licenses }" var="license">
								<c:set var="matched" value="${false }"/>
								<c:forEach items="${alba.licenseList }" var="licAlba">
									<c:if test="${licAlba.lic_code eq license.lic_code }">
										<c:set var="matched" value="${true }"/>
									</c:if>
								</c:forEach>
								<option value="${license.lic_code }" class="${matched?'matched':'normal' }">${license.lic_name }</option>
							</c:forEach>
						</select>
						<span class="error form-control-plaintext">${errors["lic_codes"] }</span>
					</div>
					<div id="imageArea" class="col-6">
					
					</div>
				</div>
				</td>
			</tr>
			<tr>
				<th>특기사항</th>
				<td><div class="form-group form-inline"><textarea  name="al_spec"  class="form-control col-6">${alba.al_spec }</textarea>
				<span class="error form-control-plaintext col-6">${errors["al_spec"] }</span></div></td>
			</tr>
			<tr>
				<th>자기소개</th>
				<td><div class="form-group form-inline"><textarea  name="al_desc"  class="form-control col-6">${alba.al_desc }</textarea>
				<span class="error form-control-plaintext col-6">${errors["al_desc"] }</span></div></td>
			</tr>
			<tr>
				<th>경력사항</th>
				<td><div class="form-group form-inline"><textarea  name="al_career"  class="form-control col-6">${alba.al_career }</textarea>
				<span class="error form-control-plaintext col-6">${errors["al_career"] }</span></div></td>
			</tr>
			<tr>
			<td colspan="2">
				<button type="submit" class="btn btn-primary">등록</button>
				<button type="reset" class="btn btn-primary">취소</button>
				<button type="button" onclick="history.back();" class="btn btn-primary">뒤로가기</button>
				<button type="button" onclick="location.href='<c:url value="/alba/albaList.do"/>';" class="btn btn-primary">목록으로</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>