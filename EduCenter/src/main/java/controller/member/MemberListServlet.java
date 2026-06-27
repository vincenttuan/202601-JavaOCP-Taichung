package controller.member;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dao.MemberDao;
import model.entity.Member;

/**
 * 全部會員資料列表:
 * 要登入才可以使用且角色需為 ADMIN
 * 若尚未登入要透過 sendRedirect() 自動引導到登入頁面
 * */
public class MemberListServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 判斷使否有登入
		// 若有登入一定可以在 session 變數中取得 member 物件資料
		HttpSession session = req.getSession();
		Member member = (Member)session.getAttribute("member");
		
		if(member == null) {
			// 尚未登入要透過 sendRedirect() 自動引導到登入頁面
			resp.sendRedirect("/EduCenter/login");
			return;
		}
		
		// 有登入, 就重導到 member-list.jsp
		// 建立請求分派器
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/member-list.jsp");
		
		// 將所有會員資料傳給 jsp
		MemberDao memberDao = MemberDao.getInstance();
		List<Member> members = memberDao.findAll();
		req.setAttribute("members", members);
		
		// 重導
		rd.forward(req, resp);
		
	}
	
}
