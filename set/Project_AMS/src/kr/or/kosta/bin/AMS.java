package kr.or.kosta.bin;

import kr.or.kosta.boundary.MainFrame;
import kr.or.kosta.entitiy.AccountManager;

/**
 * 은행 계좌 관리 어플리케이션 실행
 * 
 * @author 서지원
 *
 */
public class AMS {
	public static void main(String[] args) {
		AccountManager accountManager;
		accountManager = new AccountManager();

		MainFrame mainFrame;
		mainFrame = new MainFrame();
		mainFrame.setAccountManager(accountManager);
		mainFrame.init();
		mainFrame.setCenter();
	}
}
