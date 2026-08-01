<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>商品列表</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css">
	</head>
	<body class="product-admin-page">
	
		<%@ include file="titlebar.jsp" %>
		
		<main class="admin-container">
			<header class="admin-page-header">
				<div>
					<span class="admin-eyebrow">PRODUCT MANAGEMENT</span>
					<h1>商品列表</h1>
					<p>管理餐點分類、價格與庫存狀態。</p>
				</div>
				<a href="/McdonaldOrder/products?action=new" class="admin-button admin-button-primary">＋ 新增商品</a>
			</header>

			<div class="admin-card admin-table-card">
				<div class="admin-table-scroll">
				<table class="admin-table">
					<thead>
						<tr>
							<th>編號</th>
							<th>圖片</th>
							<th>名稱</th>
							<th>分類</th>
							<th>價格</th>
							<th>庫存</th>
							<th class="action-heading">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="product" items="${ products }">
							<tr>
								<td class="admin-id">#${ product.id }</td>
								<td>
									<div class="admin-thumbnail-box">
										<c:choose>
											<c:when test="${not empty product.imageBase64}">
												<img class="product-thumbnail" src="data:${ product.imageType };base64,${ product.imageBase64 }" alt="${ product.name }">
											</c:when>
											<c:otherwise>
												<span>無圖片</span>
											</c:otherwise>
										</c:choose>
									</div>
								</td>
								<td class="admin-product-name"><c:out value="${ product.name }" /></td>
								<td><span class="admin-category admin-category-${ product.category }">${ product.category }</span></td>
								<td class="admin-price">$${ product.price }</td>
								<td><span class="admin-stock">${ product.stock }</span></td>
								<td>
									<div class="admin-row-actions">
										<a href="/McdonaldOrder/products?action=edit&id=${ product.id }" class="admin-button admin-button-secondary admin-button-small">編輯</a>
										<form method="post" action="/McdonaldOrder/products?action=delete">
										<input type="hidden" name="id" value="${ product.id }">
											<button class="admin-button admin-button-danger admin-button-small" type="submit">刪除</button>
										</form>
									</div>
								</td>
							</tr>
						</c:forEach>
						<c:if test="${empty products}">
							<tr>
								<td colspan="7" class="admin-empty-state">目前沒有商品，請先新增商品。</td>
							</tr>
						</c:if>
					</tbody>
				</table>
				</div>
			</div>
		</main>
	</body>
</html>