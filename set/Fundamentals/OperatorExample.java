class OperatorExample {
	public static void main(String[] args) {
		int x = 50 , y = 20 ; 

		//��� ������

		System.out.println("��� : " + x + y);
		System.out.println("�� : " + (x + y));
		System.out.println("������ : " + (x % y));


		//���� ���� ������
		//x = x + y ;
		System.out.println(x+=y);

		// ����ȯ ������
		double weight = 78.34343 ;
		System.out.println((int)weight); // ������ �ٲٱ�

		//����������
		x = 100 ; 
		System.out.println(x++); //��� �� x����
		x = 100 ; 
		System.out.println(++x); // ��� �� x����

		// ��Ʈ������
		x = 10;
		System.out.println(x * 2 * 2 * 2) ; 
		x = 10;
		System.out.println(x << 3) ; //���� ����

		//���� ���� ������
		int a =2 , b = 3 , c = 1 , max ; // max �־�����ϳ� ! 
		max = (a>b) ? a: b; //false �� b
		max = (max > c ) ? max : c ; //true �� max
		System.out.println(" �ִ밪�� " + max + "�̴�");

	}
}
