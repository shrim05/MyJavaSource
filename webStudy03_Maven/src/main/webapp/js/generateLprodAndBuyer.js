/**
 * 
 */
$.fn.generateLprod = function(cPath,selectedLgu){
		let prod_lguTag = this;
		$.ajax({
			url : cPath+"/prod/getLprodList.do",
			dataType : "json",
			success : function(resp) {
				let options = [];
				$.each(resp, function(i,lprod){
					options.push(
					$("<option>").text(lprod.lprod_nm).attr({value:lprod.lprod_gu}).
					prop("selected",lprod.lprod_gu==selectedLgu)
					);
				});
				$(prod_lguTag).append(options);
				$(prod_lguTag).trigger("change");
			},
			error : function(errorResp) {
				console.log(errorResp.status);
			}
		});
	};
	

$.fn.generateBuyer=function(param){
	let cPath = param.cPath;
	let lgu = param.lgu;
	let selectedBuyer = param.selectedBuyer;
	let prod_buyerTag = this;
	$.ajax({
		url : cPath+"/prod/getBuyerList.do",
		data:{
			prod_lgu:lgu?lgu:""
		},
		dataType : "json",
		success : function(resp) {
			let options = [];
			$.each(resp, function(i,buyer){
				options.push(
				$("<option>").text(buyer.buyer_name)
							.attr({"value":buyer.buyer_id,
								 "class":buyer.buyer_lgu
									 }).prop("selected",buyer.buyer_id==selectedBuyer)
				);
			});
			var delOptions = $(prod_buyerTag).find("option:gt(0)");
			$(delOptions).remove();
//			$(prod_buyerTag).remove("option:gt(0)");
			
			$(prod_buyerTag).append(options);
		},
		error : function(errorResp) {
			console.log(errorResp.status);
		}
	});
};
