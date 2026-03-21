package day7.lab1;

/** 
 *                 +---------+
 *                 | Payment |  <interface>
 *                 +---------+
 *                      ^
 *                      |
 *             +-----------------+
 *             | AbstractPayment |  <abstract class>
 *             +-----------------+
 *              ^       ^       ^   
 *              |       |       | 
 * +------------+  +---------+  +----------+
 * | CreditCard |  | LinePay |  | ApplePay |
 * +------------+  +---------+  +----------+
 * */


public interface Payment {
	void pay(double amount); // 付款
	void refund(double amount); // 退款
}
