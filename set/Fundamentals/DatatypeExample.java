/**
* 자바 데이터 유형 테스트
*/

class DatatypeExample {
	public static void main(String[] args) {
	boolean flag = true ; //false

	//boolean flag2 = 10; //컴파일에러
	System.out.println(flag);
	
	char x ='\uD55C'; //'한'
	char y = '\uAE00'; //'글'
	
	System.out.println(x);
	System.out.println(y);

	//제어문자
	System.out.println("김\b기정 \n강사\'입니다.");
	System.out.println("\"자바가 \\좋아요\"");
	System.out.println("c:\\a\\b\\c");
	
	//byte, short, int, long
	long money = 5000000;
	System.out.println(money); // money 는 8 byte, 500000은 4byte --> int형을 8byte로 변환 시켜버림
								// 자동형변환 일어남
	long money1 = 5000000L ; // long 이라는거 알려줘서 형변환 안일어남
	System.out.println("서지원");
	System.out.print("서지원");
	System.out.print("서지원");
	System.out.printf("%d",100);

	// float, double
//	float pi = 3.141592 ;  --> 에러
	float pi = 3.141592F ; 

	}
}

