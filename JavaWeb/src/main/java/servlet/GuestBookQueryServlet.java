package servlet;

import java.io.IOException;
import java.util.List;

import dao.GuestbookDao;
import entity.Guestbook;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/servlet/query/guestbook")
public class GuestBookQueryServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		// 查詢
		List<Guestbook> guestbooks = GuestbookDao.getInstance().queryAll();
		
		// html 內容
		String html ="""
				<html>
					<head>
						<meta charset="UTF-8">
						<title>訪客留言版-歷史紀錄</title>
					</head>
					<body>
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
		
		html = String.format(html, guestbooks.size(), getGuestbookTag(guestbooks));
		
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
