<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${ title }</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="15px">
		<div class="pure-form">
			<fieldset>
				<legend>${ legend }</legend>
				${ result } <p />
				<a href="/McdonaldOrder/products?action=new" class="pure-button pure-button-primary">新增商品</a>
				<a href="/McdonaldOrder/products?action=list" class="pure-button pure-button-primary">查詢商品</a>
			</fieldset>
		</div>
	</body>
</html>