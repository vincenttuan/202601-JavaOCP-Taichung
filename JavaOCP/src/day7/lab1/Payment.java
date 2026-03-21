package day7.lab1;

/** 
 *                 +---------+
 *                 | Payment |  <interface>
 *                 +---------+
 *                      ^
 *                      |   implements
 *             +-----------------+
 *             | AbstractPayment |  <abstract class>
 *             +-----------------+
 *              ^       ^       ^   
 *              |       |       |   extends
 * +------------+  +---------+  +----------+
 * | CreditCard |  | LinePay |  | ApplePay |
 * +------------+  +---------+  +----------+
 * */


public interface Payment {
	void pay(double amount); // 付款
	void refund(double amount); // 退款
}
