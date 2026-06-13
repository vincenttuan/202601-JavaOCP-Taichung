package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/servlet/guestbook"})
public class GuestbookServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得 request 資料
		String nickname = req.getParameter("nickname");
		String content = req.getParameter("content");
		
		// 印出資料
		resp.getWriter().print("nickname = " + nickname);
		resp.getWriter().print(", ");
		resp.getWriter().print("content = " + content);
		
	}
	
}
