import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class BuffedInputStreamExample {
	static final String path = "C:\\Users\\KOSTA\\Desktop\\epp500_0651_64bit.exe";

	public static void main(String[] args) throws IOException {
//		노드 스트림
		InputStream fin = null;
		fin = new FileInputStream(path);
//			 필터스트림
		BufferedInputStream in = null; // 단독적으로 생성불가
		in = new BufferedInputStream(fin); //512바이트 배열
		
		// 0 첫번째 바이트에 마킹
 		// 1 두번째 바이트에 마킹
		System.out.println(in.read());
		
		System.out.println(in.read());
		in.mark(100); // 위치 잡아줌  : 마킹 - 읽어들인 것의 다음 것 
		System.out.println(in.read());
		
		System.out.println(in.read());
		System.out.println(in.read());
		System.out.println(in.read());
		in.skip(20); // n개 뛰어넘음
		in.reset();  // 마킹한 위치로 돌아감
		System.out.println(in.read());
		System.out.println(in.read());
		
		
		

	}

}
