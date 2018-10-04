package kr.or.kosta.entitiy;

/**
 * Account를 확장한 Minus Account
 * 
 * @author 서지원
 *
 */
public class MinusAccount extends Account {
	private long borrowMoney;

	/*
	 * 생성자
	 */
	public MinusAccount() {
		this(null, null, 0, 0, 0);
	}

	public MinusAccount(String accountNum, String accountOwner, int passwd, long restMoney, long borrowMoney) {
		super(accountNum, accountOwner, passwd, restMoney);
		this.borrowMoney = borrowMoney;
	}

	public long getBorrowMoney() {
		return borrowMoney;
	}

	public void setBorrowMoney(long borrowMoney) {
		this.borrowMoney = borrowMoney;
	}

	/*
	 * 출력
	 */
	@Override
	public String toString() {
		return String.format("%-13s%-25s%-15s%,-15d", "마이너스계좌", getAccountNum(), getAccountOwner(),
				super.getRestMoney() - getBorrowMoney()) + String.format("%,-15d", getBorrowMoney());
	}
}
