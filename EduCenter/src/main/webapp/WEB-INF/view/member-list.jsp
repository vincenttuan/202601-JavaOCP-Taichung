<%@page import="model.entity.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Member> members = (List<Member>)request.getAttribute("members");
%>    
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
				</tr>
			</thead>
			<tbody>
			<% for(Member member : members) { %>
				<tr>
					<td><%=member.getId() %></td>
					<td><%=member.getUsername() %></td>
					<td><%=member.getFullname() %></td>
					<td><%=member.getEmail() %></td>
					<td><%=member.getRole() %></td>
				</tr>
			<% } %>
			</tbody>
		</table>
		
		
	</body>
	
	<jsp:include page="footer.jsp" />
	
</html>