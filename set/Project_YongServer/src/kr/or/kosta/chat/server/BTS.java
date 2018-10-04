package kr.or.kosta.chat.server;

import java.io.IOException;

public class BTS {
	
	public static void main(String[] args) {
		YongChatServer chatServer = new YongChatServer();
		try {
			chatServer.startUp();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
