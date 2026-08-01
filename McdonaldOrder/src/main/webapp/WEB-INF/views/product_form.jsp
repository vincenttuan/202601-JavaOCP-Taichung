<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${ formTitle }商品</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css">
	</head>
	<body class="product-admin-page">
		
		<%@ include file="titlebar.jsp" %>
		
		<main class="admin-container admin-form-container">
			<header class="admin-page-header">
				<div>
					<span class="admin-eyebrow">PRODUCT MANAGEMENT</span>
					<h1>${ formTitle }商品</h1>
					<p>填寫商品資料並確認庫存與售價。</p>
				</div>
				<a href="/McdonaldOrder/products?action=list" class="admin-button admin-button-secondary">返回商品列表</a>
			</header>

			<form class="admin-card admin-product-form" method="post" enctype="multipart/form-data" action="/McdonaldOrder/products?action=${ formAction }">
				<input type="hidden" name="id" value="${ product.id }" />

				<div class="admin-form-grid">
					<label class="admin-field admin-field-wide" for="name">
						<span>商品名稱</span>
						<input id="name" name="name" type="text" maxlength="100" required value="${ product.name }" placeholder="請輸入商品名稱">
					</label>

					<label class="admin-field" for="category">
						<span>商品分類</span>
						<select id="category" name="category" required>
							<option value="BURGER" ${ product.category == 'BURGER' ? 'selected' : '' }>BURGER 漢堡</option>
							<option value="SNACK"  ${ product.category == 'SNACK' ? 'selected' : ''  }>SNACK 小點</option>
							<option value="DRINK"  ${ product.category == 'DRINK' ? 'selected' : ''  }>DRINK 飲品</option>
						</select>
					</label>

					<label class="admin-field" for="price">
						<span>商品價格</span>
						<div class="admin-input-prefix">
							<span>$</span>
							<input type="number" id="price" name="price" min="0" step="1" required value="${ product.price }">
						</div>
					</label>

					<label class="admin-field" for="stock">
						<span>商品庫存</span>
						<input type="number" id="stock" name="stock" min="0" step="1" required value="${ empty product.stock ? 10 : product.stock }">
					</label>

					<label class="admin-field admin-field-wide" for="imageFile">
						<span>商品圖片</span>
						<input class="admin-file-input" type="file" id="imageFile" name="imageFile" accept="image/png,image/jpeg">
						<small>支援 JPG、PNG，檔案上限 2 MB。</small>
					</label>
				</div>
				
				<div class="admin-image-preview-box">
					<span>圖片預覽</span>
					<img id="imagePreview"
						 class="image-preview ${empty product.imageBase64 ? 'image-preview-hidden' : ''}"
						 src="data:${ product.imageType };base64,${product.imageBase64}"
						 alt="${ product.name }">
					<p class="image-preview-hint ${not empty product.imageBase64 ? 'image-preview-hidden' : ''}">選擇圖片後會顯示在這裡</p>
				</div>

				<div class="admin-form-actions">
					<a href="/McdonaldOrder/products?action=list" class="admin-button admin-button-secondary">取消</a>
					<button type="submit" class="admin-button admin-button-primary">${ formTitle }商品</button>
				</div>
			</form>
		</main>
		
		<script>
			// 圖片預覽
			document.getElementById("imageFile").onchange = function () {

		    const file = this.files[0];
		    if (!file) return;
		
		    //-------------------------
		    // 圖片預覽
		    //-------------------------
		    const reader = new FileReader();
		
		    reader.onload = function (e) {
		        imagePreview.src = e.target.result;
		        imagePreview.classList.remove("image-preview-hidden");
		        document.querySelector(".image-preview-hint").classList.add("image-preview-hidden");
		    };
		
		    reader.readAsDataURL(file);
		
		    //-------------------------
		    // 自動解析檔名
		    //-------------------------
		
		    const filename = file.name.replace(/\.[^.]+$/, "");
		
		    // 商品價格(最後一串數字)
		    const priceMatch = filename.match(/(\d+)$/);
		
		    if (!priceMatch)
		        return;
		
		    const price = parseInt(priceMatch[1]);
		
		    // 去掉最後價格
		    let body = filename.replace(/\d+$/, "");
		
		    // 去掉前面的 m12345 或 d12345
		    body = body.replace(/^[md]\d+/i, "");
		
		    const name = body;
		
		    //-------------------------
		    // 填資料
		    //-------------------------
		
		    document.getElementById("name").value = name;
		    document.getElementById("price").value = price;
		
		    //-------------------------
		    // 分類判斷
		    //-------------------------
		
		    let category = "BURGER";
		
		    if (file.name.startsWith("d")) {
		
		        const snackNames = [
		            "玉米湯"
		        ];
		
		        category = snackNames.includes(name)
		                ? "SNACK"
		                : "DRINK";
		
		    } else {
		
		        const snackKeywords = [
		            "雞塊",
		            "薯條",
		            "雞腿",
		            "沙拉",
		            "玉米",
		            "派",
		            "麥脆雞"
		        ];
		
		        const isSnack = snackKeywords.some(k => name.includes(k));
		
		        category = isSnack
		                ? "SNACK"
		                : "BURGER";
		    }
		
		    document.getElementById("category").value = category;
		
		};
		</script>
		
	</body>
</html>