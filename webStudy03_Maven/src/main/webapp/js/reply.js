/**
 * 
 */
let replyBtn = $("#replyBtn");
let replyArea = $("#replyArea").hide();
let listForm = $("#listForm");
let insertForm = $("#insertForm");
let updateForm = $("#updateForm");
let deleteForm = $("#deleteForm");
let pageTag = $("[name='page']");
let listBody = $("#listBody"); 
let pagingArea = $("#pagingArea");
let updateModal = $("#updateModal").modal({show:false});

//------ 댓글 수정/삭제 UI
replyArea.on('click', 'button', function(){
  let toggle = $(this).data("toggle");
  if(toggle=="modal"){
	  updateModal.modal("show", $(this));
  }else if(toggle == "collapse"){
	  let target = replyArea.find($(this).data("target"));
	  replyArea.find(".collapse").not(this).collapse("hide");
	  target.collapse("toggle", $(this));
  }else if($(this).hasClass("delBtn")){
	  $(this).trigger('replyDelete', this);
  }
});

//------ 댓글 삭제
replyArea.on("replyDelete", ".delBtn", function(event){
	let reply = $(this).data("reply");
	deleteForm.find("[name='rep_no']").val(reply.rep_no);
	let password = $(this).prev(".delPassword:first").val();
	deleteForm.find("[name='rep_pass']").val(password);
	$(this).parent(".collapse").collapse("hide");
	deleteForm.submit();
});

//----- 댓글 삭제 collapse 이벤트 처리
replyArea.on("hidden.bs.collapse", ".collapse", function(){
	$(this).find(":input").val("");
});
replyArea.on("shown.bs.collapse", ".collapse", function(){
	$(this).find("input").focus();
});

//----- 댓글 수정 모달 이벤트 처리
updateModal.on("hidden.bs.modal", function(){
	$(this).find("form").get(0).reset();
});
updateModal.on("shown.bs.modal", function(event){
	replyArea.find(".collapse").collapse("hide");
	let btn = $(event.relatedTarget);
	let reply = btn.data("reply");
	$(this).find("#rep_no").val(reply.rep_no);
	$(this).find("#rep_content").val(reply.rep_content);
	$(this).find("#rep_pass").focus();
});

//------ 댓글 목록 조회
replyBtn.on("click", function(){
	paging(1);
	$(this).toggle();
});
pagingArea.on("click", "a", function(event){
	event.preventDefault();
	let page = $(this).data("page");
	if(page <= 0) return;
	paging(page);
	return false;
});
function paging(page){
	pageTag.val(page);
	listForm.submit();
}
//------- 댓글 목록 조회, 작성, 수정, 삭제
$([listForm[0], insertForm[0], updateForm[0], deleteForm[0]]).on("submit", function(event){
	event.preventDefault();
	let action = $(this).attr("action");
	let method = $(this).attr("method");
	let queryString = $(this).serialize();
	$.ajax({
		url:action,
		method:method?method:"get",
		data:queryString,
		dataType:"json",
		success:function(resp){
			if(resp.failed){
				replyArea.toastmessage('showToast', {
					text:resp.message
					, type:"warning"
					, stayTime:2000
					, position:"middle-center"
				});
				return false;
			}
			if(!resp.dataList || resp.dataList.length == 0) return false;
			let replyList = resp.dataList;
			let trTags = [];
			$(replyList).each(function(idx, reply){
				trTags.push(
					$("<tr>").append(
						$("<td>").text(reply.rep_writer)
						, $("<td>").text(reply.rep_date)
						, $("<td>").text(reply.rep_ip)
					)
				);	
				trTags.push(
					$("<tr>").append(
						$("<td colspan='2'>").text(reply.rep_content)
						, $("<td class='text-right'>").append(
							$("<button>")
								 .text("수정")
								 .addClass("btn btn-success mr-2")
								 .data({
									reply:reply
									, target:"#updateModal"
									, toggle:"modal"	
								 })
										 
							, $("<button>")
								 .text("삭제")
								 .addClass("btn btn-success")
								 .data({
									target:"#collapse_"+reply.rep_no
									, toggle:"collapse"	
								  })
						)
					)
				);
				trTags.push(
					$("<tr>")
						.html(
						   $("<td colspan='3'>").append(
								$("<div class='collapse form-inline justify-content-end'>").append(
									$("<input type='password' class='delPassword form-control' placeholder='비밀번호'>")
									, $("<button class='delBtn btn btn-warning ml-2 mr-10'>")
											.text("삭제").data("reply", reply)
								).prop("id", "collapse_"+reply.rep_no)
							)
						)
				)
			});
			listBody.html(trTags);
			pagingArea.html(resp.pagingHTML);
			replyArea.show();
			$(document).scrollTop($(document).height());
			insertForm.get(0).reset();
			updateModal.modal("hide");
			replyBtn.hide();
		},
		error:function(xhr){
			console.log(xhr.status);
		}
	});
	return false;
});