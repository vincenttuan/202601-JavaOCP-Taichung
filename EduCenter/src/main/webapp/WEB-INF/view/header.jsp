<%@ page import="model.entity.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String welcomeMessage = "[尚未登入] ";
	Member member = (Member)session.getAttribute("member");
	if(member != null) {
		welcomeMessage = "Hi " + member.getFullname() + " (" + member.getRole() + ") 您好 ! ";
	}
	
	boolean isLogin = false; // 是否有登入
	boolean isAdmin = false; // 使否是 ADMIN 的角色
	// 判斷是否有登入
	if(member != null) {
		isLogin = true;
		// 判斷是否是 ADMIN 的角色
		if(member.getRole().equals("ADMIN")) {
			isAdmin = true;
		}
	}
%>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">

<style>
    .header {
        background: #1f2937;
        color: white;
        padding: 12px 20px;
    }

    .header a {
        color: white;
        margin-right: 15px;
        text-decoration: none;
        font-weight: bold;
    }

    .header a:hover {
        text-decoration: underline;
    }

    .container {
        width: 900px;
        margin: 20px auto;
    }
</style>

<div class="header">
	<%=welcomeMessage %>
	
	<% if(!isLogin) { %>
		<a href="/EduCenter/login">登入</a>
		<a href="/EduCenter/register">註冊</a>
	<% } %>
	
	<% if(isLogin) { %>
		<a href="/EduCenter/member/profile">會員中心</a>
	<% } %>
	
	<% if(isLogin && isAdmin) { %>
		<a href="/EduCenter/member/list">會員列表(ADMIN)</a>
	<% } %>
	
	<% if(isLogin) { %>
		<a href="/EduCenter/logout">登出</a>
	<% } %>
</div>
