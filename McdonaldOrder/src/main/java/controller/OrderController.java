package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dto.ProductDTO;
import service.ProductService;

/**
 * 點餐流程
 * 
 * 會依照 action 的參數內容:
 * -- GET -------------------------
 * ""         -> 訂購商品主頁
 * "cart"     -> 購物車頁
 * "checkout" -> 結帳頁
 * "history"  -> 歷史訂單頁
 * "success"  -> 交易成功頁
 * 
 * -- POST -------------------------
 * "insert"   -> 新增至購物車
 * "update"   -> 修改購物車中的商品
 * "remove"   -> 移除購物車中的商品
 * "checkout" -> 進行結帳
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
			case "cart"     -> showCart(req, resp); // 購物車頁
			case "checkout" -> System.out.println("結帳頁");
			case "history"  -> System.out.println("歷史訂單頁");
			case "success"  -> System.out.println("交易成功頁");
			default         -> showProduct(req, resp); // 訂購商品主頁
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		if(action == null) action = "";
		
		switch(action) {
			case "insert" -> addToCart(req);
			case "update" -> System.out.println("修改購物車商品");
			case "remove" -> System.out.println("移除購物車商品");
			case "checkout" -> System.out.println("進行結帳");
		}
		
		// 重導到購物車 (Get 請求)
		resp.sendRedirect(req.getContextPath() + "/order?action=cart");
		
		// 取得購物車資料
		/*
		HttpSession session = req.getSession();
		List<ProductDTO> cart = (List)session.getAttribute("CART");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain;charset=UTF-8");
		resp.getWriter().print("Add to cart, ");
		
		cart.forEach(p -> {
			try {
				resp.getWriter().print("{" + p.getId() + ", " + p.getName() + "} ");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		*/
	}
	
	/** 
	 * 新增商品到購物車
	 */
	private void addToCart(HttpServletRequest req) {
		long productId = Long.parseLong(req.getParameter("productId"));
		// 取得商品資料
		ProductDTO productDTO = productService.findById(productId);
		
		// 取得購物車
		HttpSession session = req.getSession();
		List<ProductDTO> cart = null;
		if(session.getAttribute("CART") == null) { // 判斷 session 變數中是否有購物車資訊
			cart = new ArrayList<>(); // 建立新的購物車
		} else {
			cart = (List<ProductDTO>)session.getAttribute("CART"); // 沿用 session 變數中的購物車
		}
		
		// 將商品資料放入到購物車
		cart.add(productDTO);
		
		// 將購物車存放到 session 變數中 
		session.setAttribute("CART", cart);
	}
	
	
	/**
	 * 顯示購物車資訊
	 * 
	 * */
	private void showCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 重導到購物車頁面
		req.getRequestDispatcher("/WEB-INF/views/cart.jsp").forward(req, resp);
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






