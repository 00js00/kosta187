package kr.or.kosta.bin;

import java.io.IOException;

import kr.or.kosta.boundary.MainFrame;
import kr.or.kosta.entitiy.AccountDao;

/**
 * 은행 계좌 관리 어플리케이션 실행
 * 
 * @author 서지원
 *
 */
public class AMS {
	public static void main(String[] args) throws IOException {
		AccountDao accountManager;
		accountManager = new AccountDao();

		MainFrame mainFrame;
		mainFrame = new MainFrame();
		mainFrame.setAccountManager(accountManager);
		mainFrame.init();
		mainFrame.setCenter();
	}
}
