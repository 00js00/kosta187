class SwitchExample {
	public static void main(String[] args) {
		
		int x = 3 ;
		
		switch(x){
			case 1 : System.out.println("1"); break;
			case 2 : System.out.println("2"); break;
			case 3 : System.out.println("3"); break;
			case 4 : System.out.println("4"); break;
			case 5 : System.out.println("5");
		} 

// �̰� 3,4,5  �ٳ���
		switch(x){
			case 1 : System.out.println("1"); 
			case 2 : System.out.println("2"); 
			case 3 : System.out.println("3"); 
			case 4 : System.out.println("4"); 
			case 5 : System.out.println("5");
		} 


		System.out.println();



		//��Ģ����
		x = 70 ;
		int  y = 25  ;
		String opp = "+";


		switch(opp){
			case "+" : System.out.println(x + y); break;
			case "-" : System.out.println(x - y); break;
			case "*" : System.out.println(x * y); break;
			case "/" : System.out.println(x / y); break;
			default : System.out.println("�������� �ʴ� �������Դϴ�");
		}

	}
}