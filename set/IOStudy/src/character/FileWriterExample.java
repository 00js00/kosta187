package character;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {

	public static void main(String[] args) throws IOException {
		String path = "example5.txt";
		String message = "아 배고파";
		FileWriter out = new FileWriter(path);
//		참고사항
//		char[] chars= new char[100];
//		message.getChars(0, message.length(), chars, 0);
//		out.write(chars);
//		out.close();
		//그냥 바로 쓰는것 
		BufferedWriter bw = new BufferedWriter(out); //인코딩 기능까지 첨부되어 있는 것
		bw.write(message);
		bw.close();
		
	}

}
