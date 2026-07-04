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
		
		// 因為 LoginFilter 已經過濾過, 所以能到達這邊一定有 member 資料
		HttpSession session = req.getSession();
		Member member = (Member)session.getAttribute("member");
		
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
