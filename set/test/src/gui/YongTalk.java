package gui;

import network.YongChatClient;

public class YongTalk {
	public static void main(String[] args) {
		
		YongMainFrame mainFrame = new YongMainFrame("YongTalk");
		YongChatClient chatClient = new YongChatClient(mainFrame);
	
		mainFrame.setYongChatClient(chatClient);
		mainFrame.init();
	}
}
