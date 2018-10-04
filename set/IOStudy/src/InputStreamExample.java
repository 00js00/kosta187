import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamExample {
	static final String path = "C:\\Users\\KOSTA\\Desktop\\epp500_0651_64bit.exe";
	
	public static void main(String[] args)  {
		InputStream in = null;
		try {
			in = new FileInputStream(path);
			System.out.println(in.available()); // 바이트 수 확인
			
			// byte[](버퍼) 단위로 입력
			byte[] buffer = new byte[4*1024]; // 4~6 키로 바이트가 일반적
//			int count = in.read(buffer); //? 리턴타입이 count 냐 실제 데이터냐 를 잘 알아야함 
//			System.out.println(count);
//			System.out.println(buffer); // buffer가 배열이여서 클래스 이름 나옴
//			for (byte b : buffer) {
//				System.out.println(b);
//			}
			int count =0;
			int totalCount =0;
			while((count=in.read(buffer))!=-1) {
				System.out.println(count);
				totalCount += count;
			}
			System.out.println(in.available()); 
			System.out.println("파일 다 읽었음"); //-> 저장시, 0부터 저장
			
			
			
//			int b = in.read(); // 더이상 읽어들일 애가 없으면 -1 반환
//			System.out.println(b);
			
//			int b = 0;
//			while ((b= in.read())!= -1) {
//				System.out.println(b);
//			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(in != null) {
					in.close();// 예외가 발생하던 안발생하던 종료는 해줘야함  : try 전에 null 지정
				}} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		
	}

}
