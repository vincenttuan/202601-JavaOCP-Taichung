<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${ formTitle }商品</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 15px">
		
		<!-- Title bar -->
		<%@ include file="titlebar.jsp" %>
		
		<form class="pure-form" method="post" enctype="multipart/form-data" action="/McdonaldOrder/products?action=${ formAction }">
			
			<fieldset>
				<legend>${ formTitle }商品</legend>
				<input type="hidden" name="id" value="${ product.id }" />
				商品名稱: <input id="name" name="name" type="text" maxlength="100" required value="${ product.name }" /><br />
				商品分類: <select id="category" name="category" required>
							<option value="BURGER" ${ product.category == 'BURGER' ? 'selected' : '' }>BURGER 漢堡</option>
							<option value="SNACK"  ${ product.category == 'SNACK' ? 'selected' : ''  }>SNACK 小點</option>
							<option value="DRINK"  ${ product.category == 'DRINK' ? 'selected' : ''  }>DRINK 飲品</option>
						</select><br />
				商品價格: <input type="number" id="price" name="price" min="0" step="5" required value="${ product.price }" /><br />
				商品庫存: <input type="number" id="stock" name="stock" min="0" step="1" required value="${ product.stock }" /><br />
				商品圖片: <input type="file" id="imageFile" name="imageFile" accept="image/png,image/jpeg" /><br />
				
				<!-- 圖片預覽 -->
				<img id="imagePreview"
					 src="data:${ product.imageType };base64,${product.imageBase64}" 
					 alt="${ product.name }" 
					 style="width:200px;display: ${empty product.imageBase64} ? 'none' : 'block'">
				
				<p />
				<button type="submit" class="pure-button pure-button-primary">${ formTitle }</button>
			</fieldset>
			
		</form>
		
		<script>
			// 圖片預覽
			document.getElementById("imageFile").onchange = function() {
				const file = this.files[0];
				if(!file) return;
				const reader = new FileReader();
				reader.onload = function(e) {
					document.getElementById("imagePreview").src = e.target.result;
					document.getElementById("imagePreview").style.display = "block";
				}
				reader.readAsDataURL(file);
			}
		</script>
		
	</body>
</html>