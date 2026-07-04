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
		String code = req.getParameter("code");
		
		// 建立 HttpSession 物件用來存放登入資訊
		HttpSession session = req.getSession();
				
		// 驗證 code
		String sessionCode = session.getAttribute("code").toString(); // 取得在 session 中的 code
		boolean passCode = sessionCode.equals(code); // code 比對 
		
		// 若驗證碼驗證失敗
		if(!passCode) {
			// 建立請求分派器
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/login.jsp");
			req.setAttribute("result", "驗證碼錯誤");
			rd.forward(req, resp);
			return;
		}
		
		// 驗證帳密
		Member member = MemberDao.getInstance().login(username, password);
		
		// 若 member = null 或 code 比對失敗 表示沒有找到該會員資料也就是登入失敗
		if(member == null) {
			// 建立請求分派器
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/login.jsp");
			req.setAttribute("result", username + " login fail (登入失敗)");
			rd.forward(req, resp);
		} else {
			// 登入成功, 將 member 資料放到 session 變數中
			// 目的讓其他 servlet 與 jsp 都可以自由取得 member 資料
			session.setAttribute("member", member);
			
			// 建立請求分派器
			//RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/login.jsp");
			//req.setAttribute("result", username + " login OK (登入成功)");
			//rd.forward(req, resp);
			
			// 登入成功, 外部重導到會員中心
			//resp.sendRedirect("http://localhost:8080/EduCenter/profile");
			resp.sendRedirect("/EduCenter/profile");
			
			// 登入成功, 內部重導到會員中心
			//RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/profile.jsp");
			//rd.forward(req, resp);
			
			return;
		}
		
	}
	
}
