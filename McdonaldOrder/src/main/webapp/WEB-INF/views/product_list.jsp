<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>商品列表</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 15px">
	
		<!-- Title bar -->
		<%@ include file="titlebar.jsp" %>
		
		<div class="pure-form">
			<fieldset>
				<legend>商品列表</legend>
				
				<table class="pure-table pure-table-bordered">
					<thead>
						<tr>
							<th>編號</th>
							<th>圖片</th>
							<th>名稱</th>
							<th>分類</th>
							<th>價格</th>
							<th>庫存</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="product" items="${ products }">
							<tr>
								<td>${ product.id }</td>
								<td><img width="70" src="data:${ product.imageType };base64, ${ product.imageBase64 }" alt="${ product.name }"></td>
								<td>${ product.name }</td>
								<td>${ product.category }</td>
								<td>${ product.price }</td>
								<td>${ product.stock }</td>
								<td>
									
									<form method="post" action="/McdonaldOrder/products?action=delete">
										<input type="hidden" name="id" value="${ product.id }">
										<button type="submit">刪除</button>
									</form>
								
								</td>
							</tr>
						</c:forEach>
					</tbody>
					
				</table>
				
			</fieldset>
		</div>
	
		
		
		
	</body>
</html>