class ForExample {
	public static void main(String[] args) {

// 같은 것 100개 출력
		//int i ; 
		// for (int

		for( int i = 0; i < 100 ; i++ ){
			System.out.println("코스타 187기 화이팅!");
		}

// 1부터 100까지 더하기
	int sum = 0 ;
		for( int i = 0; i <= 100 ; i++ ){
			sum += i ;
				
		}
			System.out.println(sum);

// 5*5 별 쌓기
		for (int j = 0 ; j < 5 ; j++ ){
			for ( int k = 0 ; k < 5; k++ ){
				System.out.print("*");
			}
					System.out.println();
		}





	}
}
