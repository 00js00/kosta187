import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * TCP/IP 기반의 Socket 프로그래밍 원리
 * 
 * @author 서지원
 * 
 */
public class SocketExample {
//	public static final String domain = "www.naver.com";
//	public static final String domain = "127.0.0.1";
	public static final String domain = "localhost";
//	public static final String domain = "192.168.0.133"; // 용현
//	public static final String domain = "192.168.0.121"; // 희진
//	public static final String domain = "192.168.0.123"; // 승은언니
//	public static final String domain = "192.168.0.112"; // 주현
//	public static final String domain = "192.168.0.117"; // 재민언니

	public static final int port = 7777;

	public static void main(String[] args) {
		Socket socket = null;
		InputStream in = null;
		OutputStream out = null;
		try {
//			Socket socket = new Socket(InetAddress.getByName(domain), port);
			socket = new Socket(domain, port);

			System.out.println("서버와 연결됨...");

			in = socket.getInputStream();
			out = socket.getOutputStream();
			/*
			 * String message = "헤헤 "; byte[] buffer = new byte[4 * 1024]; buffer =
			 * message.getBytes();
			 * 
			 * out.write(buffer);// 실제로 써지긴 하는거임d System.out.println("서버에 데이터 전송"); int data
			 * = in.read(); System.out.println("서버로부터 에코된 데이터 : " + data);4
			 */

			PrintWriter pw = new PrintWriter(out/* , true */);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			Scanner scanner = new Scanner(System.in);
			while (true) {
				String inputMessage = scanner.nextLine();
				pw.println(inputMessage);
				pw.flush();
				String serverMessage = br.readLine();
				System.out.println("서버로부터 에코된 데이터 : " + serverMessage);
				if (inputMessage.equalsIgnoreCase("quit")) {
					break;
				}
			}

		} catch (IOException e) {
			System.out.println("서버와 연결할 수 없습니다..");
		} finally {
			try {
//				out.close();
//				in.close();
				socket.close(); // 소켓만 닫아줘도 out. in 둘다 닫아짐
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
