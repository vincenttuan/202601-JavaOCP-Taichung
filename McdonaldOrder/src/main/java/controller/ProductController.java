package controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.dto.ProductDTO;
import service.ProductService;

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
@MultipartConfig(
		maxFileSize = 2*1024*1024, // 2MB
		maxRequestSize = 3*1024*1024 // 3MB
)
public class ProductController extends HttpServlet {
	
	private ProductService productService = new ProductService();
	
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
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		switch(action) {
			case "insert" -> insert(req, resp);
		}
		
	}
	
	// 新增商品
	private void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// 一般表單欄位
		String name = req.getParameter("name");
		String category = req.getParameter("category");
		String price = req.getParameter("price");
		String stock = req.getParameter("stock");
		// 上傳檔案表單欄位
		Part imagePart = req.getPart("imageFile");
		byte[] imageBytes = imagePart.getInputStream().readAllBytes();
		String imageBase64 = Base64.getEncoder().encodeToString(imageBytes);
		String imageType = imagePart.getContentType();
		
		// 透過表單欄位資料來建立 DTO
		ProductDTO dto = new ProductDTO();
		dto.setName(name);
		dto.setCategory(category);
		dto.setPrice(Integer.parseInt(price));
		dto.setStock(Integer.parseInt(stock));
		dto.setImageBase64(imageBase64);
		dto.setImageType(imageType);
		
		String title = "新增商品";
		String legend = "新增商品";
		String result = "新增成功";
		try {
			// 新增
			productService.create(dto);
		} catch (Exception e) {
			result = "新增失敗: " + e;
		}
		
		// 重導
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/product_result.jsp");
		req.setAttribute("title", title);
		req.setAttribute("legend", legend);
		req.setAttribute("result", result);
		rd.forward(req, resp);
		
		/*
		// 資料印出觀察
		String html = """
				name = %s <p/ >
				category = %s <p/ >
				price = %s <p/ >
				stock = %s <p/ >
				imageBase64 = %s <p/ >
				imageType = %s <p/ >
				""".formatted(name, category, price, stock, imageBase64, imageType);
		
		resp.getWriter().print(html);
		resp.getWriter().print("<img src='data:%s;base64,%s'>".formatted(imageType, imageBase64));
		*/
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
	private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<ProductDTO> products = productService.findAll();
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/product_list.jsp");
		req.setAttribute("products", products);
		rd.forward(req, resp);
		
	}
	
	
}
