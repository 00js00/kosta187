/**
* ���α׷� ������ ���� ���ø����̼� Ŭ���� ����
*/

class AccountExample {
	public static void main(String[] args) {
		System.out.println("���� ���� ���ø����̼� ���۵�...");
			//��ü �ٷ�� ���� ����
			//Ŭ�����κ��� ��ü(�ν��Ͻ�) ����
			
			//Account account; //���� (���۷���) ���� // ��������(class) + ���ϴ� ���� �̸�(���� ����)
		//	account = new Account();
			
			// �ν��Ͻ��� �Ӽ��� ��ɻ��
			//���� �����ϴ� ��� ���� 
			//���ؼ� �����ؾ��� : account
			//account.accountNum = "1111-2222-333333";
		//	account.accountOwner = "������";
		//	account.restMoney = 100000;
		//	account.passwd = 1234;
			//System.out.println(account.accountNum);

			Account account;
			account = new Account( "1111-2222-333333", "������",1234, 100000); //new ������
			




			// ���� �ó����� ����
			int passwd = 1234;
			boolean result = account.checkPasswd(passwd);
			if (result){
				long money= account.deposit(100000); //money ��������
				System.out.println("�Ա� �� �ܾ� : " + money);	
				money = account.withdraw(10000);
				System.out.println("��� �� �ܾ� : " + money);	
				
			}else {
				System.out.println("��й�ȣ�� Ȯ���ϼ���.");
			}

		//���� ������
		Account account2 = new Account();
		//account2.accountOwner = "";  // ���������� data type �ѹ��� ���ְ� �������� �����Ͽ���
									/// ������.. class�� ���� �� �� ���� �ʱ�ȭ��
		//string �� class Ÿ���� - null�� �ʱ�ȭ�� / �ٸ��ֵ��� 0���� �ʱ�ȭ��
		account2.setAccountNum("1111-2222-3333-3333"); // set �غ���
		System.out.println(account2.getAccountNum()); // getter �޼ҵ� ����
	//	System.out.println(account2.accountOwner);
	//	System.out.println(account2.restMoney);
	//	System.out.println(account2.passwd);





		Account account3 = new Account( "2222-3333-7777", "ȫ�浿" );


		
		//Account.bankName="Hana Bank";
		System.out.println(Account.bankName);
		System.out.println(Account.sum(30,20));
		System.out.println("���� ���� ���ø����̼� �����...");

	}
}
