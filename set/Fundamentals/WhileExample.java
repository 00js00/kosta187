class WhileExample {
	public static void main(String[] args) {
		int i = 0 ;

		while ( i < 10 ){
		System.out.println("�ڽ�Ÿ187�� ȭ����!");
		i++;
		}

		// 1���� 100���� ���ϱ�
		i = 0 ;
		int sum = 0;
		while ( i <= 100){
		sum += i ;
		i++;
		}
		System.out.println(sum);

		//Ȧ�� ¦�� ���� ���ϱ�
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
		System.out.println("¦�� �� : " + evensum);
		System.out.println("Ȧ�� �� : " + oddssum);
		System.out.println("��ü �� : " + oddssum + evensum);



	}
}
