/**
* �ڹ� ������ ���� �׽�Ʈ
*/

class DatatypeExample {
	public static void main(String[] args) {
	boolean flag = true ; //false

	//boolean flag2 = 10; //�����Ͽ���
	System.out.println(flag);
	
	char x ='\uD55C'; //'��'
	char y = '\uAE00'; //'��'
	
	System.out.println(x);
	System.out.println(y);

	//�����
	System.out.println("��\b���� \n����\'�Դϴ�.");
	System.out.println("\"�ڹٰ� \\���ƿ�\"");
	System.out.println("c:\\a\\b\\c");
	
	//byte, short, int, long
	long money = 5000000;
	System.out.println(money); // money �� 8 byte, 500000�� 4byte --> int���� 8byte�� ��ȯ ���ѹ���
								// �ڵ�����ȯ �Ͼ
	long money1 = 5000000L ; // long �̶�°� �˷��༭ ����ȯ ���Ͼ
	System.out.println("������");
	System.out.print("������");
	System.out.print("������");
	System.out.printf("%d",100);

	// float, double
//	float pi = 3.141592 ;  --> ����
	float pi = 3.141592F ; 

	}
}

