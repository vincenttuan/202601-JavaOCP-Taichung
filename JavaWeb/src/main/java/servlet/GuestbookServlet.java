package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/servlet/guestbook"})
public class GuestbookServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 進行編碼(讓中文不亂碼)
		req.setCharacterEncoding("UTF-8"); // 請求(request)編碼 - 給 HTTP 看的
		resp.setCharacterEncoding("UTF-8"); // 回應(response)編碼 - 給 HTTP 看的
		resp.setContentType("text/html;charset=UTF-8"); // 給瀏覽器看的內容編碼
		
		// 取得 request 資料
		String nickname = req.getParameter("nickname"); // 取得暱稱
		String content = req.getParameter("content"); // 取得留言內容
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
		String time = sdf.format(new Date()); // 留言時間
		
		// html 內容
		String html ="""
				<html>
					<head>
						<meta charset="UTF-8">
						<title>訪客留言版</title>
					</head>
					<body>
						您輸入的內容: <br />
						nickname = %s <br />
						content = %s <br />
						留言時間: %s <br />
					</body>
				</html>
				""";
		
		html = String.format(html, nickname, content, time);
		
		// 回應 html 內容
		resp.getWriter().print(html);
		
	}
	
}
