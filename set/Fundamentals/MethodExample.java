class MethodExample {

static void printMessage(String name, String message){
	System.out.println("["+name+"] : " + message);
}

static int sum(int x, int y, int z){
return x + y + z ; 
}
	
	public static void main(String[] args) {
		//���⼭ ��¥ ����� �ϴ� �ֵ��� void �� sum ��


		String name = "�����";
		String message = "���� ������ �ؿ�";
		printMessage(name,message);


		int result = sum( 50 , 29 , 19);
		System.out.println(result);
		System.out.println(sum( 50 , 29 , 19));

		//ȣ���ϰ� ����ް� ����� print�ؾ���
	}
}
