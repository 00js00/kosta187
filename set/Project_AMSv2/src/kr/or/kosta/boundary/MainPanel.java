package kr.or.kosta.boundary;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * gridBagLayout을 이용한 화면 생성
 * 
 * @author 서지원
 *
 */
public class MainPanel extends Panel {
	/*
	 * 생성
	 */
	Button searchB, deleteB, findB, newRegistB, allSearchB;
	Label accountCategoryL, accountNumL, accountOwnerL, passwdL, despoistL, loanL, accountListL, unitWonL;
	Choice choiceC;
	TextField accountNumTF, accountOwnerTF, passwdTF, depoistTF, loanTF;
	TextArea accountListTA;
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstrains;

	/*
	 * 선언
	 */
	public MainPanel() {
		searchB = new Button("조회");
		deleteB = new Button("삭제");
		findB = new Button("검색");
		newRegistB = new Button("신규등록");
		allSearchB = new Button("전체조회");

		accountCategoryL = new Label("계좌종류");
		accountNumL = new Label("계좌번호");
		accountOwnerL = new Label("예금주명");
		passwdL = new Label("비밀번호");
		despoistL = new Label("입금금액");
		loanL = new Label("대출금액");
		accountListL = new Label("계좌목록");
		unitWonL = new Label("(단위 : 원)");

		choiceC = new Choice();
		choiceC.add("전체");
		choiceC.add("입출금계좌");
		choiceC.add("마이너스계좌");

		accountNumTF = new TextField(1);
		accountOwnerTF = new TextField(1);
		passwdTF = new TextField(1);
		depoistTF = new TextField(1);
		loanTF = new TextField(1);

		accountListTA = new TextArea(12, 1);

		gridBagLayout = new GridBagLayout();
		gridBagConstrains = new GridBagConstraints();
	}

	/*
	 * 초기화 메소드
	 */
	public void init() {
		this.setContents();
	}

	/*
	 * layout 생성
	 */
	public void setContents() {
		setLayout(gridBagLayout);

		add(accountCategoryL, 0, 0, 1, 1, 1, 1);
		add(choiceC, 1, 0, 1, 1, 1, 1);

		add(accountNumL, 0, 1, 1, 1, 1, 1);
		add(accountNumTF, 1, 1, 2, 1, 1, 1);
		add(searchB, 3, 1, 1, 1, 1, 1);
		add(deleteB, 4, 1, 1, 1, 1, 1);

		add(accountOwnerL, 0, 2, 1, 1, 1, 1);
		add(accountOwnerTF, 1, 2, 2, 1, 1, 1);
		add(findB, 3, 2, 1, 1, 1, 1);

		add(passwdL, 0, 3, 1, 1, 1, 1);
		add(passwdTF, 1, 3, 2, 1, 1, 1);
		add(despoistL, 3, 3, 1, 1, 1, 1);
		add(depoistTF, 4, 3, 2, 1, 1, 1);

		add(loanL, 0, 4, 1, 1, 1, 1);
		add(loanTF, 1, 4, 2, 1, 1, 1);
		add(newRegistB, 3, 4, 1, 1, 1, 1);
		add(allSearchB, 4, 4, 1, 1, 1, 1);
		add(new Label(" "), 5, 4, 1, 1, 1, 1);

		add(accountListL, 0, 5, 1, 1, 1, 1);
		add(new Label(" "), 1, 5, 4, 1, 1, 1);
		add(unitWonL, 5, 5, 1, 1, 1, 1);

		add(accountListTA, 0, 6, 6, 1, 1, 1);
	}

	/**
	 * component 설정
	 * 
	 * @param component  : component 이름
	 * @param gridx      : x축 위치
	 * @param gridy      : y축 위치
	 * @param gridwidth  : 폭
	 * @param gridheight : 높이
	 * @param weightx    : x 가중치
	 * @param weighty    : y 가중치
	 */
	private void add(Component component, int gridx, int gridy, int gridwidth, int gridheight, double weightx,
			double weighty) {

		gridBagConstrains.gridx = gridx;
		gridBagConstrains.gridy = gridy;
		gridBagConstrains.gridheight = gridheight;
		gridBagConstrains.gridwidth = gridwidth;
		gridBagConstrains.weightx = weightx;
		gridBagConstrains.weighty = weighty;
		gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstrains.insets = new Insets(5, 5, 5, 5);

		gridBagLayout.setConstraints(component, gridBagConstrains);
		add(component);
	}

}
