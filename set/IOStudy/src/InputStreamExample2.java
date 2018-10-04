import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JOptionPane;

public class InputStreamExample2 {
	static final String path = "C:\\Users\\KOSTA\\Desktop\\epp500_0651_64bitd.exe";
	
	public static void main(String[] args)  {
		InputStream in = null;
		File file = new File(path);
		if(!(file.exists())) {
			JOptionPane.showMessageDialog(null, "파일이 없시유..");
			return;
		} ///이거 하면서 total count 안해도됨
		try {
			in = new FileInputStream(path);
			System.out.println(in.available()); // 바이트 수 확인
			int b = 0;
			
			while((b=in.read())!=-1) {
				System.out.println(b);
			}
			
			
//			int b = in.read(); // 더이상 읽어들일 애가 없으면 -1 반환
//			System.out.println(b);

			
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
