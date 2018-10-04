import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketExample {
	public static final int port = 7777;

	public static void main(String[] args) {
		boolean running = true;
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println(port + "포트에서 서버 실행.. ");

			while (running) {
				Socket socket = serverSocket.accept(); // 리턴타입이 소켓 - 수신됨 : 안되면 계속 대기탐
				InetAddress ia = socket.getInetAddress();
				System.out.println(ia + " 클라이언트가 연결해옴..");
				
				Client client = new Client(socket);
				client.start();
//				
//				InputStream in = socket.getInputStream();
//				OutputStream out = socket.getOutputStream();
//				/*
//				 * // BufferedReader br = new BufferedReader(new
//				 * InputStreamReader(socket.getInputStream())); //
//				 * System.out.println(br.readLine()); int data = in.read();
//				 * System.out.println("클라이언트 수신 데이터: " + data); out.write(data); // InputStream
//				 * in = socket.getInputStream(); // byte[] buffer = new byte[100]; //
//				 * in.read(buffer); // String str = new String(buffer, 0, 100); //
//				 * System.out.println(str);
//				 */
//				PrintWriter pw = new PrintWriter(out/* ,true */);
//				BufferedReader br = new BufferedReader(new InputStreamReader(in));
//				boolean stop = false;
//				while (!stop) {
//					String clientMessage = br.readLine();
//					
//					pw.println(clientMessage);
//					pw.flush();
//					System.out.println("클라이언트 수신 데이터 : " + clientMessage);
//					if (clientMessage.equalsIgnoreCase("quit")) {
//						break;
//					}
//				}
////				out.close();
////				in.close();
//				pw.close();
//				br.close();
//
//				socket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // ip는 필요X

	}
}
