/**
 * 
 */
$.fn.generateLprod = function(cPath){
		let prod_lguTag = this;
		$.ajax({
			url : cPath+"/prod/getLprodList.do",
			dataType : "json",
			success : function(resp) {
				let options = [];
				$.each(resp, function(i,lprod){
					options.push(
					$("<option>").text(lprod.lprod_nm).attr({value:lprod.lprod_gu})
					);
				});
				$(prod_lguTag).append(options);
			},
			error : function(errorResp) {
				console.log(errorResp.status);
			}
		});
	};
	

$.fn.generateBuyer=function(cPath){
	let prod_buyerTag = this;
	$.ajax({
		url : cPath+"/prod/getBuyerList.do",
		dataType : "json",
		success : function(resp) {
			let options = [];
			$.each(resp, function(i,buyer){
				options.push(
				$("<option>").text(buyer.buyer_name)
							.attr({"value":buyer.buyer_id,
								 "class":buyer.buyer_lgu
									 })
				);
			});
			$(prod_buyerTag).append(options);
		},
		error : function(errorResp) {
			console.log(errorResp.status);
		}
	});
};
