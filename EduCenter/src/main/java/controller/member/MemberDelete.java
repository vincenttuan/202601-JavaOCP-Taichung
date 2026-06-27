package controller.member;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dao.MemberDao;
import model.entity.Member;

@WebServlet(urlPatterns = {"/member/delete"})
public class MemberDelete extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 判斷使否有登入
		HttpSession session = req.getSession();
		Member member = (Member)session.getAttribute("member");
		
		if(member == null) {
			// 尚未登入要透過 sendRedirect() 自動引導到登入頁面
			resp.sendRedirect("/EduCenter/login");
			return;
		}
		
		// 判斷使否是 Admin 角色
		if(!member.getRole().equals("ADMIN")) {
			resp.sendError(403, "權限不足");
			return;
		}
		
		// 取得 id 參數內容
		int id = Integer.parseInt(req.getParameter("id")); // 字串轉數字
		
		// 執行刪除
		MemberDao memberDao = MemberDao.getInstance();
		memberDao.delete(id);
		
		// 自動重新導向 /members
		resp.sendRedirect("/EduCenter/members");
	}
	
}
