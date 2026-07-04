package filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.entity.Member;

//@WebFilter(urlPatterns = {"/member/delete", "/members", "/profile"})
@WebFilter(urlPatterns = {"/member/*"})
public class LoginFilter extends HttpFilter {
	
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// 判斷使否有登入
		// 若有登入一定可以在 session 變數中取得 member 物件資料
		HttpSession session = req.getSession();
		Member member = (Member)session.getAttribute("member");
		
		if(member == null) {
			// 尚未登入要透過 sendRedirect() 自動引導到登入頁面
			resp.sendRedirect("/EduCenter/login");
			return;
		}
		
		// 往下交付
		chain.doFilter(req, resp);
		
	}
	
}
