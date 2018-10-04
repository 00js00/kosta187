package character;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

// 텍스트 파일 전용 
public class BufferedReaderExample {

	public static void main(String[] args) throws IOException {
		String path = "src\\BuffedInputStreamExample.java";
		FileReader in = new FileReader(path); // 유효성검사해주는게 좋음
//		System.out.println(/* (char) */in.read());// 출력 : 105 ---- i 를 읽은 아스키 코드

//		char[] buffer = new char[1024];
//		int count = 0;
//		while ((count = in.read(buffer)) != -1) {
//			for (char c : buffer) {
//				System.out.print(c); // ln 하면 안됨 - 하나 읽고 한 줄 띄니까
//			}
//		}
		
		BufferedReader br = new BufferedReader(in);
//		String txt = br.readLine();
//		System.out.println(txt);
		
		String txt = null;
		while((txt = br.readLine())!= null) { //이미 한 줄을 넣어서 ! 
			System.out.println(txt);
		}
		// 디코딩 - ms949 씀
		
//		new LineNumberReader(in).getLineNumber()
	}

}
