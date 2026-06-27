package controller.member;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.MemberDao;
import model.entity.Member;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 建立請求分派器
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/login.jsp");
		rd.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接收網頁表單內容 利用 getParameter()
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		// 驗證帳密
		Member member = MemberDao.getInstance().login(username, password);
		
		// 若 member = null 表示沒有找到該會員資料也就是登入失敗
		if(member == null) {
			// 建立請求分派器
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/login.jsp");
			req.setAttribute("result", username + " login fail (登入失敗)");
			rd.forward(req, resp);
		} else {
			// 建立請求分派器
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/login.jsp");
			req.setAttribute("result", username + " login OK (登入成功)");
			rd.forward(req, resp);
		}
		
	}
	
}
