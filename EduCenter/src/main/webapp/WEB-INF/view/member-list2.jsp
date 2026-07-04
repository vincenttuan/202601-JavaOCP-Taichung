<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>會員資料列表(Member List)</title>
	</head>
	<jsp:include page="header.jsp" />
	
	<body class="container">
		<h2>會員資料列表</h2>
		
		<table class="pure-table pure-table-bordered">
			<thead>
				<tr>
					<th>id</th>
					<th>username</th>
					<th>fullname</th>
					<th>email</th>
					<th>role</th>
					<th>create time</th>
					<th>delete</th>
				</tr>
			</thead>
			<tbody>
				<!-- null 的判斷 -->
				<c:if test="${empty members}">
					<tr>
						<td colspan="7" align="center">無此權限或無資料</td>
					</tr>
				</c:if>
				
				<!-- 資料迴圈列表 -->
				<c:forEach var="member" items="${members}">
					<tr>
						<td>${member.id}</td>
						<td>${member.username}</td>
						<td>${member.fullname}</td>
						<td>${member.email}</td>
						<td>${member.role}</td>
						<td>${member.createTime}</td>
						
						<td>
							<a href="/EduCenter/member/delete?id=${member.id}" class="pure-button">Delete</a>
						</td>
					</tr>
					
				</c:forEach>
				
			</tbody>
		</table>
	</body>
	
	<jsp:include page="footer.jsp" />
	
</html>