package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dto.OrderItemDTO;
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
			case "checkout" -> showCheckout(req, resp);
			case "history"  -> System.out.println("歷史訂單頁");
			case "success"  -> showSuccess(req, resp); //交易成功頁
			default         -> showProduct(req, resp); // 訂購商品主頁
		}
		
		// Log 查看購物車 session 的資料並印出
		printSessionData("CART", req);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		if(action == null) action = "";
		
		switch(action) {
			case "insert" -> addToCart(req);
			case "update" -> updateCart(req);
			case "remove" -> removeFromCart(req);
			case "checkout" -> checkout(req, resp);
		}
		
		if(action.equals("checkout")) {
			// 重導到結帳成功頁
			resp.sendRedirect(req.getContextPath() + "/order?action=success");
		} else {
			// 重導到購物車 (Get 請求)
			resp.sendRedirect(req.getContextPath() + "/order?action=cart");
		}
	}
	
	/**
	 * 進行結帳
	 * */
	private void checkout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得 session 資料
		HttpSession session = req.getSession(false);
		
		if(session == null && session.getAttribute("CART") == null) {
			throw new RuntimeException("無購物車資訊");
		}
		
		// 取得結帳資訊
		String customerName = req.getParameter("customerName");
		String customerPhone = req.getParameter("customerPhone");
		Map<ProductDTO, Integer> cart = (Map)session.getAttribute("CART");
		if(cart.size() == 0) {
			throw new RuntimeException("購物車內沒有商品");
		}
		
		// 執行結帳服務
		
		
		// 清除購物車相關 session 資料
		session.setAttribute("CART", null);
		session.setAttribute("cartCount", 0);
		
	}
	
	/**
	 * 修改購物車商品數量
	 * */
	private void updateCart(HttpServletRequest req) {
		
		long productId = Long.parseLong(req.getParameter("productId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		
		// 取得 session CART 的資料
		HttpSession session = req.getSession(false);
		if(session != null && session.getAttribute("CART") != null) {
			
			Map<ProductDTO, Integer> cart = (Map)session.getAttribute("CART");
			
			// 判斷商品訂購數量
			if(quantity <= 0) {
				
				// 找到該商品並移除
				cart.keySet().removeIf(dto -> dto.getId().equals(productId));
				
			} else {
				// 找到該商品並修改數量
				for(ProductDTO dto : cart.keySet()) {
					if(dto.getId().equals(productId)) {
						cart.put(dto, quantity);
						break;
					}
				}
			}
			
			// 重新設定購物車商品數量
			updateCartCount(cart, session);
			
			// session 回存
			session.setAttribute("CART", cart);
		}
	}
	
	/**
	 * 移除指定的購物車商品
	 * */
	private void removeFromCart(HttpServletRequest req) {
		long productId = Long.parseLong(req.getParameter("productId"));
		// 取得 session CART 的資料
		HttpSession session = req.getSession(false);
		if(session != null && session.getAttribute("CART") != null) {
			
			Map<ProductDTO, Integer> cart = (Map)session.getAttribute("CART");
			
			// 移除購物車商品
			cart.keySet().removeIf(dto -> dto.getId().equals(productId));
			
			// 重新設定購物車商品數量
			updateCartCount(cart, session);
			
			// session 回存
			session.setAttribute("CART", cart);
		}
		
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
		// key=商品, value=累積數量
		Map<ProductDTO, Integer> cart = null;
		
		
		if(session.getAttribute("CART") == null) { // 判斷 session 變數中是否有購物車資訊
			cart = new LinkedHashMap<>(); // 建立新的購物車
		} else {
			cart = (Map)session.getAttribute("CART"); // 沿用 session 變數中的購物車
		}
		
		// 將商品資料放入到購物車
		cart.put(productDTO, cart.getOrDefault(productDTO, 0) + 1);
		
		// 將購物車存放到 session 變數中 
		session.setAttribute("CART", cart);
		
		// 設定 cartCount 件數
		updateCartCount(cart, session);
	}
	
	// 更新購物車商品數量設定到 session 變數中
	private void updateCartCount(Map<ProductDTO, Integer> cart, HttpSession session) {
		// 設定 cartCount 件數
		int cartCount = cart.values().stream().mapToInt(Integer::intValue).sum();
		// 將件數存放到 session 變數中
		session.setAttribute("cartCount", cartCount);
	}
	
	/**
	 * 顯示結帳完成
	 * */
	private void showSuccess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/order_success.jsp");
		rd.forward(req, resp);
	}
	
	/**
	 *  顯示結帳頁
	 * */
	private void showCheckout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 檢查是否購物車有商品
		HttpSession session = req.getSession(false);
		
		// 若購物車中沒有商品就重導到購物車頁
		if(session == null || session.getAttribute("cartCount") == null || (Integer)session.getAttribute("cartCount") <= 0) {
			resp.sendRedirect(req.getContextPath() + "/order?action=cart");
			return;
		}
		
		// 重導到結帳頁
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/checkout.jsp");
		rd.forward(req, resp);
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
	
	// 印出目前的 session 資料
	private void printSessionData(String name, HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if(session != null) {
			System.out.printf("session 資料 %s = %s%n", name, session.getAttribute(name));
		}
	}
	
}






