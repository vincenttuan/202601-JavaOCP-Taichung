package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/servlet/game/employee", "/servlet/game/boss"})
public class GameServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String message = "Game ";
		String servletPath = req.getServletPath();
		
		switch (servletPath) {
			case "/servlet/game/employee":
				message += "GG";
				break;
			case "/servlet/game/boss":
				message += "Enjoy";
				break;	
		}
		
		resp.getWriter().print(message);
	}
	
}
