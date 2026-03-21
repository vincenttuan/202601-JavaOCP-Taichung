package day7.lab2;

/** 
 *                    +---------+
 *                    | Ticket |  <interface>
 *                    +---------+
 *                         ^
 *                         |   implements
 *              +---------------------+
 *              |    AbstractTicket   |  <abstract class>
 *              +-------------------- +
 *              ^          ^          ^   
 *              |          |          |   extends
 * +------------+  +---------------+  +--------------+
 * |  VIPTicket |  | StudentTicket |  | NormalTicket |
 * +------------+  +---------------+  +--------------+
 * 
 * */

public interface Ticket {
	double book(int qty);   // 訂票 -> 回傳總金額(含手續費)
	double refund(int qty); // 退票 -> 回傳退款金額
	double calculateFee(double amount); // 手續費
}
