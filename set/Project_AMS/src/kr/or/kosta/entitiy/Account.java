package kr.or.kosta.entitiy;

/**
 * 일상생활의 객체를 추상화하기 위한 모델링 클래스 정의 은행계좌 객체
 * 
 * @author 서지원
 */

public class Account {

	/**
	 * 은행이름 : KOSTA 은행
	 */
	public static final String bankName = "KOSTA 은행";

	private String accountNum;
	private String accountOwner;
	private int passwd;
	private long restMoney;

	/*
	 * 생성자
	 */
	public Account() {
		this(null, null);
	}

	public Account(String accountNum, String accountOwner) {
		this(accountNum, accountOwner, 1, 1);
	}

	public Account(String accountNum, String accountOwner, int passwd, long restMoney) {
		this.accountNum = accountNum;
		this.accountOwner = accountOwner;
		this.passwd = passwd;
		this.restMoney = restMoney;
	}

	/*
	 *  setter/getter 메소드
	 */
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}

	public String getAccountOwner() {
		return accountOwner;
	}

	public void setPasswd(int passwd) {
		this.passwd = passwd;
	}

	int getPasswd() {
		return passwd;
	}

	public void setRestMoney(long restMoney) {
		this.restMoney = restMoney;
	}

	long getrestMoney() {
		return restMoney;
	}

	/*
	 *  현재 잔액 계산
	 */
	public long deposit(long money) throws AccountException {
		if (money <= 0) {
			throw new AccountException("입금하고자 하는 금액은 음수일 수 없습니다", -97);
		}
		return money;
	}

	public long withdraw(long money) throws AccountException {
		if (money <= 0) {
			throw new AccountException("출금하고자 하는 금액은 음수일 수 없습니다", -98);
		}
		if (money > restMoney) {
			throw new AccountException("잔액이 부족합니다.", -99);
		}
		return money;
	}

	public long getRestMoney() {
		return restMoney;
	}

	/*
	 *  비밀번호 일치여부 확인
	 */
	public boolean checkPasswd(int pw) {
		return passwd == pw;
	}

	@Override
	public boolean equals(Object check) {
		boolean eq = false;
		if (check instanceof Account) {
			eq = toString().equals(check.toString());
		}
		return eq;
	}

	/*
	 *  출력기능
	 */
	@Override
	public String toString() {
		return String.format("%-15s%-25s%-15s%,-15d" , "입출금계좌" ,getAccountNum(),getAccountOwner(),getrestMoney());
	}

	/*
	 *  더하기 메소드
	 */
	public static int sum(int a, int b) {
		return a + b;
	}

}
