import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Calendar;

public class PrittStreamExample {
	static final String path = "example4.dat";
	public static void main(String[] args) throws IOException {
		boolean flag = false;
		char c = '김';
		int age = 30;
		double weight = 66.7;
		String message= "입출력 프로그램입니다..";
		// 쓴 값 은 잘 보이면 안됨
		
		Calendar now = Calendar.getInstance();
		
		
//		PrintStream out = new PrintStream(new FileOutputStream(path)); 
		PrintStream out = new PrintStream(path);  // 탁별히 얘만 .. 가능.. 
		out.println(flag);
		out.println(c);
		out.println(age);
		out.println(weight);
		out.println(message);
		out.printf("%1$tF %1$tT",now); //: 포메터
		System.out.println("썼음..");
		out.close();
		
		
	}

}
