package kr.or.kosta.boundary;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import kr.or.kosta.entitiy.Account;
import kr.or.kosta.entitiy.AccountDao;
import kr.or.kosta.entitiy.MinusAccount;

/**
 * AMS화면에 출력 기능
 * 
 * @author 서지원
 *
 */
public class MainFrame extends Frame {
	/*
	 * 변수 선언
	 */
	MainPanel panel;
	AccountDao manager;

	/*
	 * 생성자
	 */
	public AccountDao getAccountManager() {
		return manager;
	}

	public void setAccountManager(AccountDao accountManager) {
		this.manager = accountManager;
	}

	/*
	 * frame 이름 생성
	 */
	public MainFrame() throws IOException {
		this("KOSTA AMS - 메인화면");
	}

	public MainFrame(String title) throws IOException {
		super(title);
		panel = new MainPanel();
		manager = new AccountDao();
	}

	/*
	 * 가운데에 위치
	 */
	public void setCenter() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (dim.width - getSize().width) / 2;
		int y = (dim.height - getSize().height) / 2;
		setLocation(x, y);
	}

	/*
	 * Frame 초기화
	 */
	public void init() {
		this.eventRegist();
		this.setSize(550, 500);
		this.setVisible(true);
		panel.init();
		panel.passwdTF.setEchoChar('*');
		panel.accountListTA.setEnabled(false);
		this.add(panel);
		try {
			manager.create(new Account("5555-2222-3333", "최지원", 1111, 1000000));
			manager.create(new Account("6666-2222-3333", "최지원", 1111, 2000000));
			manager.create(new Account("2222-2222-3333", "김지원", 1111, 200000));
			manager.create(new Account("3333-2222-3333", "이지원", 1111, 300000));
			manager.create(new Account("4444-2222-3333", "박지원", 1111, 400000));
			manager.create(new MinusAccount("1111-2222-2222", "김지원", 111, 10000, 100000));
			manager.create(new MinusAccount("2222-2222-2222", "김지원", 111, 10000, 100000));

		} catch (Exception e) {
		}
	}

	/*
	 * 창 닫기 메소드
	 */
	private void finish() {
		setVisible(false);
		dispose();
		System.exit(0);
	}

	/*
	 * 계좌목록 시작 라인
	 */
	public void Line() {
		panel.accountListTA.setText("");
		panel.accountListTA
				.append("----------------------------------------------------------------------------------" + "\n");
		panel.accountListTA
				.append(String.format("%-13s%-25s%-15s%-15s%-15s\n", "계좌종류", "계좌번호", "예금주명", "현재잔액", "대출금액"));
		panel.accountListTA
				.append("==================================================================================" + "\n");
	}

	/**
	 * 계좌목록 끝 라인
	 */
	public void LineFinish() {
		panel.accountListTA
				.append("----------------------------------------------------------------------------------");
	}

	/**
	 * 모든 TextField 비우는 메소드
	 */
	public void Null() {
		panel.accountNumTF.setText("");
		panel.accountOwnerTF.setText("");
		panel.passwdTF.setText("");
		panel.depoistTF.setText("");
		panel.loanTF.setText("");
	}

	/*
	 * parseInt 사용시 에러처리
	 */
	public static int parseInt(String sTmp) {
		String tTmp = "0", cTmp = "";
		sTmp = sTmp.trim();
		for (int i = 0; i < sTmp.length(); i++) {
			cTmp = sTmp.substring(i, i + 1);
			if (cTmp.equals("0") || cTmp.equals("1") || cTmp.equals("2") || cTmp.equals("3") || cTmp.equals("4")
					|| cTmp.equals("5") || cTmp.equals("6") || cTmp.equals("7") || cTmp.equals("8") || cTmp.equals("9"))
				tTmp += cTmp;
			else if (cTmp.equals("-") && i == 0)
				tTmp = "-";
			else
				break;
		}
		return (Integer.parseInt(tTmp));
	}

	/*
	 * parseLong 사용시 에러처리
	 */
	public static long parseLong(String sTmp) {
		String tTmp = "0", cTmp = "";
		sTmp = sTmp.trim();
		for (int i = 0; i < sTmp.length(); i++) {
			cTmp = sTmp.substring(i, i + 1);
			if (cTmp.equals("0") || cTmp.equals("1") || cTmp.equals("2") || cTmp.equals("3") || cTmp.equals("4")
					|| cTmp.equals("5") || cTmp.equals("6") || cTmp.equals("7") || cTmp.equals("8") || cTmp.equals("9"))
				tTmp += cTmp;
			else if (cTmp.equals("-") && i == 0)
				tTmp = "-";
			else
				break;
		}
		return (Long.parseLong(tTmp));
	}

	/*
	 * 이벤트 등록
	 */
	public void eventRegist() {
		/*
		 * 입출금계좌인 경우 대출금액 비활성화
		 */
		panel.choiceC.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (panel.choiceC.getSelectedItem().equals("마이너스계좌")) {
					panel.loanTF.setEnabled(true);
				} else
					panel.loanTF.setEnabled(false);
			}
		});
		/*
		 * 계좌번호를 이용한 조회기능
		 */
		panel.searchB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Line();
				try {
					panel.accountListTA.append((manager.get(panel.accountNumTF.getText()).toString()) + "\n");
				} catch (Exception e1) {
				}
				LineFinish();
				Null();
			}
		});
		/*
		 * 계좌번호를 이용한 삭제기능 : 삭제 완료 후 메세지창 출력
		 */
		panel.deleteB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Line();
				try {
					manager.remove(panel.accountNumTF.getText());
					JOptionPane.showMessageDialog(null, panel.accountNumTF.getText() + " 계좌가 삭제되었습니다", "완료",
							JOptionPane.OK_CANCEL_OPTION);
					List<Account> list = manager.listAll();
					for (Object account : list) {
						panel.accountListTA.append(account.toString() + "\n");
					}
					Null();
					LineFinish();
				} catch (Exception e1) {
				}

			}
		});
		/*
		 * 예금주명을 이용한 검색기능 : 검색 후 TextArea에 출력
		 */
		panel.findB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Line();
				try {
					List<Account> search = manager.search(panel.accountOwnerTF.getText());
					for (int i = 0; i < search.size(); i++) {
						Object account = search.get(i);
						panel.accountListTA.append(account.toString() + "\n");
					}
				} catch (Exception e1) {
				}
				LineFinish();
				Null();
			}
		});
		/*
		 * 신규등록 : 계좌종류에따라, 빈칸 존재시 에러메세지 출력 등록 성공시 확인메세지와 전체 계좌 출력
		 */
		panel.newRegistB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Account addAccount;
				MinusAccount minusAccount;

				if (panel.choiceC.getSelectedItem().equals("전체")) {
					JOptionPane.showMessageDialog(null, "계좌종류를 선택해주세요.", "에러", JOptionPane.ERROR_MESSAGE);
				} else if (panel.choiceC.getSelectedItem().equals("입출금계좌")) {
					addAccount = new Account(panel.accountNumTF.getText(), panel.accountOwnerTF.getText(),
							(parseInt(panel.passwdTF.getText())), (parseInt(panel.depoistTF.getText())));
					try {
						Line();
						manager.create(addAccount);
						JOptionPane.showMessageDialog(null, "계좌가 성공적으로 등록되었습니다.", "확인",
								JOptionPane.INFORMATION_MESSAGE);
						List<Account> list = manager.listAll();
						for (Object account : list) {
							panel.accountListTA.append(account.toString() + "\n");
						}
						LineFinish();
						Null();
					} catch (Exception e1) {
					}
				} else if (panel.choiceC.getSelectedItem().equals("마이너스계좌")) {
					minusAccount = new MinusAccount(panel.accountNumTF.getText(), panel.accountOwnerTF.getText(),
							(parseInt(panel.passwdTF.getText())), (parseLong(panel.depoistTF.getText())),
							(parseLong(panel.loanTF.getText())));
					try {
						Line();
						manager.create(minusAccount);
						JOptionPane.showMessageDialog(null, "계좌가 성공적으로 등록되었습니다.", "확인",
								JOptionPane.INFORMATION_MESSAGE);
						List<Account> list = manager.listAll();
						for (Object account : list) {
							panel.accountListTA.append(account.toString() + "\n");
						}
						LineFinish();
						Null();
					} catch (Exception e1) {
					}
				}
			}
		});
		/*
		 * 전체 조회 : 전체 계좌 목록 반환
		 */
		panel.allSearchB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Line();
				ArrayList<Account> list;
				try {
					list = (ArrayList<Account>) manager.listAll();
					for (Account account : list) {
						panel.accountListTA.append(account.toString() + "\n");
					}
				} catch (IOException e1) {
				}
				LineFinish();
			}
		});
		/*
		 * 창 닫기
		 */
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				manager.close();
				finish();
			}
		});
	}
}
