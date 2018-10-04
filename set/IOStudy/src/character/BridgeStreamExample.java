package character;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BridgeStreamExample {

	public static void main(String[] args) throws IOException {
		System.out.print("당신의 이름 : ");
		byte[] buffer = new byte[100];
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String name = br.readLine()	;
		System.out.println(name);
	}

}
