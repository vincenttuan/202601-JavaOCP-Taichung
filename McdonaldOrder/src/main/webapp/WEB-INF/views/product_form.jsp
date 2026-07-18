<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>新增商品</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 15px">
		
		<form class="pure-form" method="post" action="/McdonaldOrder/products?action=insert">
			
			<fieldset>
				<legend>新增商品</legend>
				商品名稱: <input id="name" name="name" type="text" maxlength="100" required /><br />
				商品分類: <select id="category" name="category" required>
							<option value="BURGER">BURGER 漢堡</option>
							<option value="SNACK">SNACK 小點</option>
							<option value="DRINK">DRINK 飲品</option>
						</select><br />
				商品價格: <input type="number" id="price" name="price" min="0" step="5" required /><br />
				商品庫存: <input type="number" id="stock" name="stock" min="0" step="1" required /><br />
				商品圖片: <input type="file" id="imageFile" name="imageFile" accept="image/png,image/jpeg" /><br />
				
				<button type="submit" class="pure-button pure-button-primary">儲存</button>
			</fieldset>
			
		</form>
		
		
	</body>
</html>