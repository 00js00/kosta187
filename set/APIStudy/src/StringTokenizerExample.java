import java.util.StringTokenizer;

public class StringTokenizerExample {

	public static void main(String[] args) {
//		String date = "2018-8-23";
		String date = "1111 2222 3333 4444";
		StringTokenizer str = new StringTokenizer(date," ");
		System.out.println(str.countTokens());
		
		while(str.hasMoreTokens()) {
			String token = str.nextToken();	
			System.out.println(token);
		}
		
	}

}