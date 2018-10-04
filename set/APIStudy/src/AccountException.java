
public class AccountException extends Exception {
//String message;
	// 에러 코드값 저장할 수 있는 메소드 추가
	private int errorCode;

	public int getErrorCode() {
		return errorCode;
	}

	public AccountException() {
		this("계좌처리중 예기치 않은 에러가 발생하였습니다.", -9);
	}

	public AccountException(String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {
		return "AccountException [errorCode=" + errorCode + ", getMessage()=" + getMessage() + "]";
	}

}
