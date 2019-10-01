<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>prod update form</title>
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
<c:if test="${not empty message }">
	<script>
		alert("${message}");
	</script>
</c:if>
<table>
<form method="post">
	<tr><td>prod_id  		</td><td><input type="hidden" required readonly name="prod_id" value="${prod.prod_id}"><span class="errors">${errors.prod_id}</span></td></tr>      
	<tr><td>prod_name       </td><td><input type="text" required name="prod_name" value="${prod.prod_name       }"><span class="errors">${errors.prod_name}</span></td></tr>      
	<tr><td>prod_properstock</td><td><input type="text" name="prod_properstock" value="${prod.prod_properstock}"><span class="errors">${errors.prod_properstock}</span></td></tr>      
	<tr><td>prod_totalstock </td><td><input type="text" name="prod_totalstock" value="${prod.prod_totalstock }"><span class="errors">${errors.prod_totalstock}</span></td></tr>      
	<tr><td>prod_img        </td><td><input type="text" name="prod_img" value="${prod.prod_img        }"><span class="errors">${errors.prod_img}</span></td></tr>      
	<tr><td>prod_outline    </td><td><input type="text" name="prod_outline" value="${prod.prod_outline    }"><span class="errors">${errors.prod_outline}</span></td></tr>      
	<tr><td>prod_sale       </td><td><input type="text" name="prod_sale" value="${prod.prod_sale       }"><span class="errors">${errors.prod_sale}</span></td></tr>      
	<tr><td>prod_price      </td><td><input type="text" name="prod_price" value="${prod.prod_price      }"><span class="errors">${errors.prod_price}</span></td></tr>      
	<tr><td>prod_cost       </td><td><input type="text" name="prod_cost" value="${prod.prod_cost       }"><span class="errors">${errors.prod_cost}</span></td></tr>      
	<tr><td>prod_lgu        </td><td>
		<select name="prod_lgu">
			<option value>분류선택</option>
		</select>
	<span class="errors">${errors.prod_lgu}</span></td></tr>      
	<tr><td>prod_buyer      </td><td>
		<select name="prod_buyer">
			<option value>거래처선택</option>
		</select>
	<span class="errors">${errors.prod_buyer}</span></td></tr>      
	<tr><td>prod_unit       </td><td><input type="text" name="prod_unit" value="${prod.prod_unit       }"><span class="errors">${errors.prod_unit}</span></td></tr>      
	<tr><td>prod_detail     </td><td><input type="text" name="prod_detail" value="${prod.prod_detail     }"><span class="errors">${errors.prod_detail}</span></td></tr>      
	<tr><td>prod_delivery   </td><td><input type="text" name="prod_delivery" value="${prod.prod_delivery   }"></td></tr>      
	<tr><td>prod_color      </td><td><input type="text" name="prod_color" value="${prod.prod_color      }"></td></tr>      
	<tr><td>prod_mileage    </td><td><input type="text" name="prod_mileage" value="${prod.prod_mileage    }"></td></tr>      
	<tr><td>prod_qtysale    </td><td><input type="text" name="prod_qtysale" value="${prod.prod_qtysale    }"></td></tr>      
	<tr><td>prod_insdate    </td><td><input type="text" name="prod_insdate" value="${prod.prod_insdate    }"></td></tr>      
	<tr><td>prod_qtyin      </td><td><input type="text" name="prod_qtyin" value="${prod.prod_qtyin   }"></td></tr>      
	<tr><td>prod_size       </td><td><input type="text" name="prod_size" value="${prod.prod_size       }"></td></tr>
	<tr><td  colspan="2"><button type="submit" >제출</button>
	<button type="reset">취소</button><td></tr>
</form>
</table>
<script type="text/javascript">
	var prod_lguTag = $("[name='prod_lgu']");
	prod_lguTag.generateLprod("${pageContext.request.contextPath}");
	var prod_buyerTag = $("[name='prod_buyer']");
	prod_buyerTag.generateBuyer("${pageContext.request.contextPath}");
	
	$(prod_lguTag).on("change", function(){
		let lguCode = $(this).val();
		if(!lguCode) return;
		let options = $(prod_buyerTag).find("option:gt(0)");
		$(options).hide();
		let lguOptions = $(prod_buyerTag).find("option."+lguCode);
		$(lguOptions).show();
	});
	
	
	
	
	
	
</script>
</body>
</html>