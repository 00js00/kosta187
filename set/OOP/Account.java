/**
* �ϻ��Ȱ�� ��ü�� �߻�ȭ�ϱ� ���� �𵨸� Ŭ���� ����
* ������� ��ü
*/ 
public class Account {



	//static �ʱ�ȭ ��(Ư���� ������ ��ɾ� ����)
	static {
		System.out.println("�ʱ�ȭ �� �����Դϴ�..1");
		System.out.println("�ʱ�ȭ �� �����Դϴ�..2");

	}

	//Ŭ���� (static) ����	
	public static final  String bankName = "�ϳ�����" ;
	

	// �ν��Ͻ� ��������
 	private String accountNum ;
	private String accountOwner ; 
	private int passwd ; 
	private long restMoney ;


	// ������
	Account(){
		this(null,null);
	}
	Account (String accountNum, String accountOwner){
	//		this.accountNum = accountNum;
	//		this.accountOwner = accountOwner;	
			this(accountNum, accountOwner , 1, 1);
			//�ڱ� �����ڿ��� �����θ� �ҷ��� �� �ߺ� ȣ�� ���� --> �� this = ���� Account this
	}
	// �������� �ƴ� - �����ε�

	Account (String accountNum, String accountOwner, int passwd, long restMoney){
			this.accountNum = accountNum;
			this.accountOwner = accountOwner;
			this.passwd = passwd;
			this.restMoney = restMoney;
	
	}

	// setter/getter �޼ҵ�
	public void setAccountNum (String accountNum){
		this.accountNum = accountNum;	
	}
public String getAccountNum(){
return accountNum;
}

	public void setAccountOwner (String accountOwner){
		this.accountOwner = accountOwner;	
	}
public String getAccountOwner(){
return accountOwner;
}
	public void setPasswd (int passwd){
		this.passwd = passwd;	
	}
int getPasswd(){
return passwd;
}

	public void setRestMoney (long restMoney){
		this.restMoney = restMoney;
	}
	long getrestMoney(){
		return restMoney;
	}



	// ���� �ν��Ͻ� ��밡��
	public long deposit(long money){
		restMoney += money; //�����ݾ׿� money�� ����
		return restMoney;
	}
	public long withdraw(long money){
		restMoney -= money;
		return restMoney;
	}
	public long getRestMoney(){
		return restMoney;
	}
	public boolean checkPasswd(int pw){
		return passwd == pw;	//��й�ȣ �³� Ȯ��	
	}
//class method (static method)
public static int sum(int a, int b){
return a + b ;
}


}
