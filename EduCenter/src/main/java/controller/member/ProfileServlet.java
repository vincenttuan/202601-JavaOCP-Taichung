package controller.member;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dao.MemberDao;
import model.entity.Member;

/**
 * 會員中心:
 * 要登入才可以使用
 * 若尚未登入要透過 sendRedirect() 自動引導到登入頁面
 * */
@WebServlet(urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 因為 LoginFilter 已經過濾過, 所以能到達這邊一定有 member 資料
		// 直接重導到 profile.jsp
		// 建立請求分派器
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/profile.jsp");
		rd.forward(req, resp);
	}
	
	/**
	 * 修改會員資料
	 * */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 因為資料可能內涵中文, 所以需要先編碼
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		// 取得表單資料
		String fullname = req.getParameter("fullname");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String role = req.getParameter("role");
		
		// 從登入資料中取得 id --------------------------------------
		HttpSession session = req.getSession();
		Member member = (Member)session.getAttribute("member");
		
		if(member == null) {
			// 尚未登入要透過 sendRedirect() 自動引導到登入頁面
			resp.sendRedirect("/EduCenter/login");
			return;
		}
		Integer id = member.getId();
		// -----------------------------------------------------
		
		// 進行修改
		MemberDao memberDao = MemberDao.getInstance();
		memberDao.update(id, password, fullname, email, role);
		
		// 修改完畢後需登出
		resp.sendRedirect("/EduCenter/logout");
		
	}
	
}
