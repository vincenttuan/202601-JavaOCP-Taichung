package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dao.GuestbookDao;
import entity.Guestbook;
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
		
		// -- 儲存留言紀錄 ------------------------------
		GuestbookDao dao = GuestbookDao.getInstance();
		dao.add(nickname, content, time);
		
		// -- 查詢留言紀錄 ------------------------------
		List<Guestbook> guestbooks = dao.queryAll();
		
		// html 內容
		String html ="""
				<html>
					<head>
						<meta charset="UTF-8">
						<title>訪客留言版</title>
					</head>
					<body>
						<div>
							<fieldset>
								<legend>您輸入的內容:</legend>
								nickname = %s <br />
								content = %s <br />
								留言時間: %s <br />
							</fieldset>
						</div>
						<hr />
						<div>
							<fieldset>
								<legend>訪客留言版-歷史紀錄</legend>
								資料筆數: %d <br />
								資料內容: <br />
								<table border="1">
									<thead>
										<tr>
											<th>序號</th><th>暱稱</th><th>留言內容</th><th>留言時間</th>
										</tr>
									</thead>
									<tbody>
										%s
									</tbody>
								<table>
							</fieldset>
						</div>
					</body>
				</html>
				""";
		
		html = String.format(html, nickname, content, time, guestbooks.size(), getGuestbookTag(guestbooks));
		
		// 回應 html 內容
		resp.getWriter().print(html);
	}
	
	// 產生每一筆留言紀錄的 <tr> 標籤
	private String getGuestbookTag(List<Guestbook> guestbooks) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<guestbooks.size();i++) {
			Guestbook gb = guestbooks.get(i);
			
			String tr = """
					<tr>
						<td>%s</td><td>%s</td><td>%s</td><td>%s</td>
					</tr>
					""";
			
			sb.append(String.format(tr, gb.getId(), gb.getNickname(), gb.getContent(), gb.getTime()));
		}
		
		return sb.toString();
	}
	
}
