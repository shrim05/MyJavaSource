/**
 * 
 */
	var leftSrc =$('.leftSrc');
	var rightTarget = $('.rightTarget')
	var serverFileForm = $('#serverFileForm');
	var srcFile = $('#srcFile');
	var commandForm = $("#commandForm");
	var leftArea = $('#leftArea');
	var rightArea = $('#rightArea');
	$(".managerForm").on("submit",function(event){
		event.preventDefault();
		var queryString = $(this).serialize();
		var method = $(this).attr("method");
		$.ajax({
			url : $.getContextPath()+"/serverFileManager",
			method : method?method:"get",
			data : queryString,
			dataType : "json",
			success : function(resp) {
				console.log(resp);
				if(resp.leftFiles){
					let liTags = [];
					$(resp.leftFiles).each(function(index, element){
						let liTag = $("<li>").prop("id",element.id)
											.attr("class",element.file?"file":"dir")
											.text(element.displayname);
						liTags.push(liTag);
					});
					leftArea.html(liTags);
				}
				if(resp.rightFiles){
					let liTags = [];
					$.each(resp.rightFiles, function(){
						let element = this;
						let liTag = $("<li>").prop("id",element.id)
											.attr("class",element.file?"file":"dir")
											.text(element.displayname);
						liTags.push(liTag);
					});
					rightArea.html(liTags);
				}
			},
			error : function(errorResp) {
				console.log(errorResp.status);
			}
		});
		return false;
		
	});
	$('li').css({cursor:"pointer"});
	$('.groupUL').on("dblclick", '.dir', function(){
		if($(this).parent().prop("id")=='leftArea'){
			leftSrc.val($(this).prop("id"));
		}else{
			rightTarget.val($(this).prop("id"));
		}
		serverFileForm.submit();
	});
	$('#leftArea').on("click","li",function(){
		$(this).siblings("li").removeClass("active");		
		$(this).toggleClass("active");
		if($(this).hasClass("active")){
			srcFile.val($(this).prop("id"));
		}else{
			srcFile.val("");
		}
	});
