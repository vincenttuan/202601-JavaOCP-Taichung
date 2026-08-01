<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>購物車</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css" >
	</head>
	<body class="cart-page">
		<%@ include file="titlebar.jsp" %>
		<main>
			<h1>購物車 (${fn:length(sessionScope.CART)}) 件 </h1>
			
			<div class="cart">
				<table>
					<thead>
						<tr>
							<th>商品</th>
							<th>單價</th>
							<th>數量</th>
							<th>小計</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${sessionScope.CART}">
							<tr>
								<td>
									<img valign="bottom" width="50" src="data:${item.imageType};base64,${item.imageBase64}" alt="${item.name}">
									${item.name}
								</td>
								<td>$${item.price}</td>
								<td>1</td>
								<td>${item.price*1}</td>
								<td>
									<button class="remove" type="submit">移除</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
			</div>
			
		</main>
		
	</body>
</html>