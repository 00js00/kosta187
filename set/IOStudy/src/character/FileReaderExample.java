package character;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// 텍스트 파일 전용 
public class FileReaderExample {

	public static void main(String[] args) throws IOException {
		String path = "src\\BuffedInputStreamExample.java";
		FileReader in = new FileReader(path); // 유효성검사해주는게 좋음
		System.out.println(/*(char)*/in.read());// 출력 : 105 ---- i 를 읽은 아스키 코드
		
		char[] buffer = new char[1024];
		int count = 0;
		while((count = in.read(buffer))!= -1) {
			for (char c : buffer) {
				System.out.print(c); // ln 하면 안됨 - 하나 읽고 한 줄 띄니까
			}
		}
		///////////////////////// 여기는 한글 깨짐 : 2byte 를 1byte 로 나눠서 읽어서 
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer2 = new byte[1024];
		count = 0;
		while((count = fis.read(buffer2))!= -1) {
			for (byte c : buffer2) {
				System.out.print(c); // 
			}
		}
		
	}

}
