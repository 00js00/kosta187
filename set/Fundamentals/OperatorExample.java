class OperatorExample {
	public static void main(String[] args) {
		int x = 50 , y = 20 ; 

		//산술 연산자

		System.out.println("결과 : " + x + y);
		System.out.println("합 : " + (x + y));
		System.out.println("나머지 : " + (x % y));


		//복합 대입 연산자
		//x = x + y ;
		System.out.println(x+=y);

		// 형번환 연산자
		double weight = 78.34343 ;
		System.out.println((int)weight); // 정수로 바꾸기

		//증감연산자
		x = 100 ; 
		System.out.println(x++); //출력 후 x증가
		x = 100 ; 
		System.out.println(++x); // 출력 전 x증가

		// 비트연산자
		x = 10;
		System.out.println(x * 2 * 2 * 2) ; 
		x = 10;
		System.out.println(x << 3) ; //빠름 빠름

		//조건 삼항 연산자
		int a =2 , b = 3 , c = 1 , max ; // max 넣어줘야하네 ! 
		max = (a>b) ? a: b; //false 면 b
		max = (max > c ) ? max : c ; //true 면 max
		System.out.println(" 최대값은 " + max + "이다");

	}
}
