
public class Account {
	private String accountNum;
	private String accountOwner;
	private int passwd;
	private long restMoney;
	
	private final String bankName = "하나은행";
			
	Account(){
		this(null,null,0,0);
	}
	Account(String accountNum, String accountOwner, int passwd, long restMoney){
		this.accountNum = accountNum;
		this.accountOwner = accountOwner;
		this.passwd = passwd;
		this.restMoney = restMoney;
	}
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public String getAccountOwner() {
		return accountOwner;
	}
	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}
	public int getPasswd() {
		return passwd;
	}
	public void setPasswd(int passwd) {
		this.passwd = passwd;
	}
	public long getRestMoney() {
		return restMoney;
	}
	public void setRestMoney(long restMoney) {
		this.restMoney = restMoney;
	}
	
	public void deposit(long money) {
		this.restMoney += money;
	}
	
	public void withdraw(long money) {
		this.restMoney -= money;
		if ( restMoney  < 0) {
			System.out.println("출금불가");
		}
	}
	
	public boolean checkPasswd(int passwd) {
		if(this.passwd == passwd) {
			System.out.println("true");
		}
		return false;
	}
}
