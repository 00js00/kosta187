package kr.or.kosta.entitiy;

import javax.swing.JOptionPane;

/**
 * 예외 처리
 * @author 서지원
 *
 */
public class AccountException extends Exception {
	/*
	 *  에러 코드값 저장할 수 있는 메소드 추가
	 */
	private int errorCode;

	public int getErrorCode() {
		return errorCode;
	}

	public AccountException() {
		this("계좌처리중 예기치 않은 에러가 발생하였습니다.", -1);
	}

	public AccountException(String message, int errorCode) {
		super(message);
		JOptionPane.showMessageDialog(null, message, "에러", JOptionPane.ERROR_MESSAGE);
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {
		return "AccountException [errorCode=" + errorCode + ", getMessage()=" + getMessage() + "]";
	}

}
