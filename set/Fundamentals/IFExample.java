import java.util.Scanner;


class IFExample {
	public static void main(String[] args) {
		int score = 98 ;
		if(score < 100 ){ //�ǵ����̸� �߰�ȣ ����
		System.out.println(score);
		} else{
		System.out.println("Ż���Դϴ�");
		}

		if (score >= 60 ){
		System.out.println("Pass");
		} else {
		System.out.println("Fail");
		}

		if ((score % 2) == 0) {  // if�� ��ø
		System.out.println("¦��");
			if (score >= 50 ){
			System.out.println("���� : " + score);
			}
		} else {
		System.out.println("Ȧ��");
			} 


		//����̾簡
		System.out.print("���� : ");
		Scanner scanner = new Scanner(System.in);
		score = scanner.nextInt();

		if (score >= 90){
			System.out.println("��");		
		} else if (score >= 80){
			System.out.println("��");
		} else if (score >= 70){
			System.out.println("��");
		} else if (score >= 60){
			System.out.println("��");
		} else {
			System.out.println("��");
		}





	}
}
