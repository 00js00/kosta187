class WhileExample {
	public static void main(String[] args) {
		int i = 0 ;

		while ( i < 10 ){
		System.out.println("코스타187기 화이팅!");
		i++;
		}

		// 1부터 100까지 더하기
		i = 0 ;
		int sum = 0;
		while ( i <= 100){
		sum += i ;
		i++;
		}
		System.out.println(sum);

		//홀수 짝수 따로 더하기
		i = 0 ;
		int evensum = 0, oddssum = 0 ;
		while ( i <= 100){
		if ( i % 2 == 0){
			evensum += i;
		} else {
			oddssum += i;
		}
		i++;
		}
		System.out.println("짝수 합 : " + evensum);
		System.out.println("홀수 합 : " + oddssum);
		System.out.println("전체 합 : " + oddssum + evensum);



	}
}
