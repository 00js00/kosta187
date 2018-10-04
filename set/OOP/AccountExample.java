/**
* 프로그램 실행을 위한 애플리케이션 클래스 정의
*/

class AccountExample {
	public static void main(String[] args) {
		System.out.println("은행 계좌 애플리케이션 시작됨...");
			//객체 다루는 내용 나옴
			//클래스로부터 객체(인스턴스) 생성
			
			//Account account; //참조 (레퍼런스) 변수 // 변수선언(class) + 속하는 변수 이름(임의 지정)
		//	account = new Account();
			
			// 인스턴스의 속성과 기능사용
			//직접 접근하는 방법 없음 
			//통해서 접금해야함 : account
			//account.accountNum = "1111-2222-333333";
		//	account.accountOwner = "서지원";
		//	account.restMoney = 100000;
		//	account.passwd = 1234;
			//System.out.println(account.accountNum);

			Account account;
			account = new Account( "1111-2222-333333", "서지원",1234, 100000); //new 생성자
			




			// 가상 시나리오 전개
			int passwd = 1234;
			boolean result = account.checkPasswd(passwd);
			if (result){
				long money= account.deposit(100000); //money 지역변수
				System.out.println("입금 후 잔액 : " + money);	
				money = account.withdraw(10000);
				System.out.println("출금 후 잔액 : " + money);	
				
			}else {
				System.out.println("비밀번호를 확인하세요.");
			}

		//새로 만들어보자
		Account account2 = new Account();
		//account2.accountOwner = "";  // 지역변수는 data type 한번만 해주고 나머지는 컴파일에러
									/// 하지만.. class는 새로 들어갈 때 마다 초기화됨
		//string 은 class 타입임 - null로 초기화됨 / 다른애들은 0으로 초기화됨
		account2.setAccountNum("1111-2222-3333-3333"); // set 해볼때
		System.out.println(account2.getAccountNum()); // getter 메소드 적용
	//	System.out.println(account2.accountOwner);
	//	System.out.println(account2.restMoney);
	//	System.out.println(account2.passwd);





		Account account3 = new Account( "2222-3333-7777", "홍길동" );


		
		//Account.bankName="Hana Bank";
		System.out.println(Account.bankName);
		System.out.println(Account.sum(30,20));
		System.out.println("은행 계좌 애플리케이션 종료됨...");

	}
}
