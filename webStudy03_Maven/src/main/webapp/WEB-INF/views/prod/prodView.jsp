<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4 class="text-center">${prod.prod_name}</h4>
	<c:if test="${not empty message }">
		<script>
		alert("${message}");
	</script>
	</c:if>
	<table>
		<thead>
			<tr>
				<th>상품코드</th>
				<th>상품명</th>
				<th>상품분류명</th>
				<th>거래처명</th>
				<th>구매가</th>
				<th>판매가</th>
				<th>마일리지</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${prod.prod_id}</td>
				<td>${prod.prod_name}</td>
				<td>${prod.lprod_nm}</td>
				<td>
					<table>
						<thead>
							<tr>
								<th>거래처코드</th>
								<th>거래처이름</th>
								<th>거래처책임자</th>
								<th>연락처</th>
								<th>주소</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${prod.buyer.buyer_id }</td>
								<td>${prod.buyer.buyer_name }</td>
								<td>${prod.buyer.buyer_charger}</td>
								<td>${prod.buyer.buyer_comtel}</td>
								<td>${prod.buyer.buyer_add1}</td>
						</tbody>
					</table>
				</td>
				<td>${prod.prod_cost}</td>
				<td>${prod.prod_price}</td>
				<td>${prod.prod_mileage}</td>
			</tr>
			<tr>
				<td colspan="2"><c:url value="/prod/prodUpdate.do"
						var="updateURL">
						<c:param name="prod_id" value="${prod.prod_id }"></c:param>
					</c:url>
					<button type="button" onclick="location.href='${updateURL}';">상품수정</button>
				</td>
			</tr>
		</tbody>
	</table>
	<h4>구매기록</h4>
	<table>
		<thead>
			<tr>
				<th>회원아이디</th>
				<th>회원명</th>
				<th>휴대폰</th>
				<th>이메일</th>
				<th>소재지</th>
			</tr>
		</thead>
		<tbody>
		<c:choose>
		<c:when test="${not empty prod.memberList }">
		
			<c:forEach items="${prod.memberList}" var="member" >
				<tr>
					<td>${member.mem_id }</td>
					<td>${member.mem_name }</td>
					<td>${member.mem_hp }</td>
					<td>${member.mem_mail }</td>
					<td>${member.mem_add1 }</td>
				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="5">
					구매 기록이 없음
				</td>
			</tr>
		</c:otherwise>
		</c:choose>
		</tbody>
	</table>
</body>
</html>