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

@WebServlet(urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 建立請求分派器
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/register.jsp");
		rd.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 設定編碼
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;utf-8");
		
		// 取得表單資料
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String fullname = req.getParameter("fullname");
		String email = req.getParameter("email");
		String role = req.getParameter("role");
		
		// 建立 Member 物件
		Member member = new Member();
		member.setUsername(username);
		member.setPassword(password);
		member.setFullname(fullname);
		member.setEmail(email);
		member.setRole(role);
		
		// 取得 Dao 物件
		MemberDao memberDao = MemberDao.getInstance();
		
		// 回應訊息
		String msg = "Register OK";

		// 註冊會員資料(將資料存放到資料庫中)
		try {
			memberDao.register(member);
		} catch (Exception e) {
			 msg = "Register Fail: " + e.getMessage();
		}
		
		// 建立請求分派器
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/register.jsp");
		req.setAttribute("msg", msg); // 透過 setAttribute 方法將資料傳給 jsp
		rd.forward(req, resp);
		
		
	}
	
	
}
