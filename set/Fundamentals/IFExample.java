import java.util.Scanner;


class IFExample {
	public static void main(String[] args) {
		int score = 98 ;
		if(score < 100 ){ //되도록이면 중괄호 쓰기
		System.out.println(score);
		} else{
		System.out.println("탈락입니다");
		}

		if (score >= 60 ){
		System.out.println("Pass");
		} else {
		System.out.println("Fail");
		}

		if ((score % 2) == 0) {  // if문 중첩
		System.out.println("짝수");
			if (score >= 50 ){
			System.out.println("점수 : " + score);
			}
		} else {
		System.out.println("홀수");
			} 


		//수우미양가
		System.out.print("점수 : ");
		Scanner scanner = new Scanner(System.in);
		score = scanner.nextInt();

		if (score >= 90){
			System.out.println("수");		
		} else if (score >= 80){
			System.out.println("우");
		} else if (score >= 70){
			System.out.println("미");
		} else if (score >= 60){
			System.out.println("양");
		} else {
			System.out.println("가");
		}





	}
}
