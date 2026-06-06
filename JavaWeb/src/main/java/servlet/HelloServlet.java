package servlet;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/servlet/hello", "/servlet/welcome"})
public class HelloServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 編碼設定
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String html ="""
				<html>
					<head>
						<title>
							Hello Page
						</title>
					</head>
					<body>
						<h1>
							Hello World ! <p />
						</h1>
						<h2>
							from: %s <p />
							time: %s
						</h2>
					</body>
				</html>
				""";
		
		String message = html.formatted(req.getServletPath(), new Date());
		
		// 包裝 HTTP Response 送出
		resp.getWriter().print(message);
		
	}
	
}
