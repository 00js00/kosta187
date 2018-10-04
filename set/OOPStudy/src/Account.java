/**
 * 일상생활의 객체를 추상화하기 위한 모델링 클래스 정의 은행계좌 객체
 */
public class Account {

	// static 초기화 블럭(특수한 목적의 명령어 실행)
	static {
		System.out.println("starting..1");
		System.out.println("starting..2");

	}

	@Override
	public boolean equals(Object check) {
		boolean eq = false;
		if (check instanceof Account) {
			eq = toString().equals(check.toString());
		}
		return eq;
	}

	// 클래스 (static) 변수
	/**
	 * 
	 */
	public static final String bankName = "하나은행";

	// 인스턴스 변수선언
	private String accountNum;
	private String accountOwner;
	private int passwd;
	private long restMoney;

	// 생성자
	Account() {
		this(null, null);
	}

	Account(String accountNum, String accountOwner) {
		// this.accountNum = accountNum;
		// this.accountOwner = accountOwner;
		this(accountNum, accountOwner, 1, 1);
		// 자기 생성자에서 스스로를 불러올 때 중복 호출 가능 --> 이 this = 뒤의 Account this
	}
	// 문법에러 아님 - 오버로딩

	Account(String accountNum, String accountOwner, int passwd, long restMoney) {
		this.accountNum = accountNum;
		this.accountOwner = accountOwner;
		this.passwd = passwd;
		this.restMoney = restMoney;

	}

	// setter/getter 메소드
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

	// 위에 인스턴스 사용가능
	public long deposit(long money) throws AccountException {
		if (money <= 0) {
			throw new AccountException("출금하고자 하는 금액은 음수일 수 없습니다", -2);
		}
		return money;
	}
//		restMoney += money; // 기존금액에 money를 누적
//		return restMoney;
//	}

	public long withdraw(long money) throws AccountException {
		if (money <= 0) {
			throw new AccountException("출금하고자 하는 금액은 음수일 수 없습니다", -1);
		} // 강제로 발생시키고 호출한 쪽에 다시 보내고!
		if (money > restMoney) {
			throw new AccountException("잔액이 부족합니다.", -2);
		}
		return money;
	}

	public long getRestMoney() {
		return restMoney;
	}

	public boolean checkPasswd(int pw) {
		return passwd == pw; // 비밀번호 맞나 확인
	}

	// 출력기능
	@Override
	public String toString() {
		return getAccountNum() + "\t" + getAccountOwner() + "\t" + "****" + "\t" + getrestMoney();

	}

//	public
//class method (static method)
	public static int sum(int a, int b) {
		return a + b;
	}

}
