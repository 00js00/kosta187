package character;

import java.io.IOException;
import java.io.StringReader;

public class MemoryStreamExample {
	public static void main(String[] args) throws IOException{
		String message = "198기 하나금융 TI";
		StringReader sr = new StringReader(message);
		System.out.println((char)sr.read());
	}
	
}
