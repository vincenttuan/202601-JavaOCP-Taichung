package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 商品 Controller
 * 
 * GET:
 * 給予 UI 畫面
 * 商品列表 /products?action=list 或 /products
 * 商品新增 /products?action=new
 * 商品修改 /products?action=edit&id=1
 * 
 * POST:
 * 修改資料庫
 * 新增 /products?action=insert
 * 修改 /products?action=update
 * 刪除 /products?action=delete
 * 
 * */

@WebServlet("/products")
public class ProductController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		String id = req.getParameter("id");
		
		switch(action) {
			case "new" -> showCreateForm(req, resp);
			case "edit" -> showEditForm(req, resp);
			default -> showList(req, resp);
		}
		
	}
	
	// 顯示新增表單
	private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/product_form.jsp");
		rd.forward(req, resp);
		
	}
	
	// 顯示修改表單
	private void showEditForm(HttpServletRequest req, HttpServletResponse resp) {
		
	}
	
	// 顯示商品列表
	private void showList(HttpServletRequest req, HttpServletResponse resp) {
		
	}
	
	
}
