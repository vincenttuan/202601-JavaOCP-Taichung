package test;

import model.dao.OrderDAO;

public class TestOrderDAO {

	public static void main(String[] args) {
		OrderDAO orderDAO = new OrderDAO();
		orderDAO.findAllOrders().forEach(System.out::println);

	}

}
