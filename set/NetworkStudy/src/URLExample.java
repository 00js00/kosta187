import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

public class URLExample {

	public static void main(String[] args) {
//		String urlString = "http://www.daum.net:80/index.html"; // 프로그램이름(80 : http)
		String urlString = "https://sports.news.naver.com/index.nhn"; // 프로그램이름(80 : http)

		try {
			URL url = new URL(urlString);
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());

//			InputStreamReader in = new InputStreamReader(url.openStream()); // 문자스트림으로 받는것  + 브릿지 스트림
//			BufferedReader read = new BufferedReader(in);
			
			BufferedReader read = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8")); // 언어타입 선언 가능

			String txt = null;
			while ((txt = read.readLine()) != null) {
				System.out.println(txt);
			}

//			System.out.println(in);
//			System.out.println(in.read());
//
//			byte[] buffer = new byte[1024]; // 1패킷으로 받는 것이 좋음
//			int count = 0;
//			while ((count = in.read(buffer)) != -1) {
//				System.out.println(buffer);
//				String text = new String(buffer,0,count);
//				System.out.println(text); // 단점) 쓰는건 안됨
//			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); // 주소가 틀릴수있음
			JOptionPane.showMessageDialog(null, "서버를 찾을 수 없습니다");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
