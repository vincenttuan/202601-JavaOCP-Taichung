package day11;

// 自訂例外
public class LoginFailException extends Exception {
	public LoginFailException(String message) {
		super(message);
	}
}
