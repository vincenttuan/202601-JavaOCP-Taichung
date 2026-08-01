package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.ProductDTO;
import service.ProductService;

/**
 * 點餐流程
 * 
 * 會依照 action 的參數內容:
 * ---------------------------
 * ""         -> 訂購商品主頁
 * "cart"     -> 購物車頁
 * "checkout" -> 結帳頁
 * "history"  -> 歷史訂單頁
 * "success"  -> 交易成功頁
 * 
 * */
@WebServlet("/order")
public class OrderController extends HttpServlet {
	
	private ProductService productService = new ProductService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		if(action == null) action = "";
		
		switch (action) {
			case "cart"     -> System.out.println("購物車頁");
			case "checkout" -> System.out.println("結帳頁");
			case "history"  -> System.out.println("歷史訂單頁");
			case "success"  -> System.out.println("交易成功頁");
			default         -> showProduct(req, resp); // 訂購商品主頁
		}
	}
	
	/** 訂購商品主頁 
	 * 	查詢可點餐商品
	 * */
	private void showProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<ProductDTO> products = productService.findAll();
		req.setAttribute("products", products);
		req.setAttribute("categories", productService.getCategories());
		
		// 重導到訂購商品主頁
		req.getRequestDispatcher("/WEB-INF/views/order_main.jsp").forward(req, resp);
	}
	
	
}






