<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${ title }</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css">
	</head>
	<body class="product-admin-page">
		
		<%@ include file="titlebar.jsp" %>
		
		<main class="admin-container admin-result-container">
			<section class="admin-card admin-result-card">
				<div class="admin-result-icon ${fn:contains(result, '失敗') ? 'admin-result-error' : ''}">
					${fn:contains(result, '失敗') ? '!' : '✓'}
				</div>
				<span class="admin-eyebrow">OPERATION RESULT</span>
				<h1>${ legend }</h1>
				<p class="admin-result-message">${ result }</p>
				<div class="admin-result-actions">
					<a href="/McdonaldOrder/products?action=new" class="admin-button admin-button-primary">新增商品</a>
					<a href="/McdonaldOrder/products?action=list" class="admin-button admin-button-secondary">查看商品列表</a>
				</div>
			</section>
		</main>
	</body>
</html>