import java.io.IOException;

public class StandardInOutExample {

	public static void main(String[] args) throws IOException {
		System.out.println(System.in);
		System.out.println(System.out);
//		System.out.print("당신의 이름 : ");
		byte[] buffer = new byte[100];
		
//		int count = System.in.read(buffer);
		//문자 디코딩 처리;
//		count 에 enter 값이 들어가서 .. 그냥 count하면 엔터까지 포함되어서 출력
//		String name = new String(buffer,0,count-2);
//		System.out.println("당신의 입력 이름은 " +name + "입니다");
		
		System.out.print("당신의 나이 : ");
		int count = System.in.read(buffer);
		String age = new String(buffer,0,count-2);
		System.out.println(Integer.parseInt(age));
	}

}
