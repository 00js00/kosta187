import java.awt.Button;
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

public class GridBagLayoutPanel2 extends Panel implements ActionListener{
	
	TalkFrame frame;
	
	Button findB, sendB, cancelB;
	Label recipientL, attachmentL, titleL;
	TextField recipipentTF, attachmentTF, titleTF;
	TextArea messageTA;
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstrains;

	public GridBagLayoutPanel2(TalkFrame frame) {
		this.frame = frame;
		recipientL = new Label("받는사람");
		attachmentL = new Label("첨부파일");
		titleL = new Label("제목");
		titleL.setAlignment(Label.RIGHT);
		attachmentL.setAlignment(Label.RIGHT);
		recipientL.setAlignment(Label.RIGHT);

		recipipentTF = new TextField(13);
		attachmentTF = new TextField(13);
		titleTF = new TextField(10);

		messageTA = new TextArea(10, 40);

		findB = new Button("찾기");
		sendB = new Button("보내기");
		cancelB = new Button("취소");
		gridBagLayout = new GridBagLayout();
		gridBagConstrains = new GridBagConstraints();
		setContents();
	}

	public void setContents() {
		setLayout(gridBagLayout);

//		gridBagConstrains.gridx = 0;
//		gridBagConstrains.gridy = 0;
////		격자가 붙을 때마다 격자가 자동생성됨 : 붙이면서 격자를 자동생성 
//		gridBagConstrains.gridheight = 1;
//		gridBagConstrains.gridwidth = 1;
//		gridBagConstrains.weightx = 0; //가중치
//		gridBagConstrains.weighty = 0; //가중치
//		gridBagLayout.setConstraints(button1, gridBagConstrains);
//		add(button1);
//		
//		setLayout(gridBagLayout);
//		gridBagConstrains.gridx = 1;
//		gridBagConstrains.gridy = 0;
////		격자가 붙을 때마다 격자가 자동생성됨 : 붙이면서 격자를 자동생성 
//		gridBagConstrains.gridheight = 1;
//		gridBagConstrains.gridwidth = 1;
//		gridBagConstrains.weightx = 1; //가중치 1/(1+0) --> 오른쪽에 붙어있음
//		gridBagConstrains.weighty = 1; //가중치
//		gridBagConstrains.fill = GridBagConstraints.HORIZONTAL; // 격자가 커지면 안에있는애가 커지는지, 여백이 커지는지 지정
//		gridBagConstrains.insets = new Insets(5, 5, 5, 5);
//		gridBagLayout.setConstraints(button2, gridBagConstrains);
//		add(button2);
//전체 7
		add(recipientL, 0, 0, 1, 1, 0, 0);
		add(recipipentTF, 1, 0, 2, 1, 0, 0);
//		add(new Label(" "),3,0,1,1,0,0);
//		add(new Label(" "),4,0,1,1,0,0);
//		add(new Label(" "),5,0,1,1,0,0);
//		add(new Label(" "),6,0,1,1,0,0);

//		
		add(attachmentL, 0, 1, 1, 1, 1, 1);
		add(attachmentTF, 1, 1, 2, 1, 1, 1);
		add(findB, 3, 1, 1, 1, 1, 1);
		add(new Label(" "), 4, 1, 1, 1, 1, 1);
		add(new Label(" "), 5, 1, 1, 1, 1, 1);
		add(new Label(" "), 6, 1, 1, 1, 1, 1);

////		
		add(titleL, 0, 2, 1, 1, 1, 1);
		add(titleTF, 1, 2, 6, 1, 1, 1);
////		
		add(messageTA, 0, 3, 7, 1, 1, 1);
//		
//		add(new Label(" "),0,4,1,1,0,0);
//		add(new Label(" "),1,4,1,1,0,0);		
//		add(sendB,2,4,1,1,0,0);
//		add(cancelB,3,4,1,1,0,0);
//		add(new Label(" "),4,4,1,1,0,0);
//		add(new Label(" "),5,4,1,1,0,0);
//		add(new Label(" "),6,4,1,1,0,0);

		Panel panel1 = new Panel();
		panel1.add(sendB);
		panel1.add(cancelB);
		add(panel1, 0, 4, 7, 1, 1, 1);

//		
	}

	private void add(Component component, int gridx, int gridy, int gridwidth, int gridheight, double weightx,
			double weighty) {

		gridBagConstrains.gridx = gridx;// 몇개의 격자를 차지할것인가
		gridBagConstrains.gridy = gridy;// 몇개의 격자를 차지할것인가 // 붙이면서 격자를 늘려가는것
		gridBagConstrains.gridheight = gridheight;
		gridBagConstrains.gridwidth = gridwidth;
		gridBagConstrains.weightx = weightx;
		gridBagConstrains.weighty = weighty;
		gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstrains.insets = new Insets(5, 5, 5, 5);

		gridBagLayout.setConstraints(component, gridBagConstrains);
		add(component);

	}

	public static void main(String[] args) {
//		Frame frame = new Frame("GridLayout Example");
//
//		GridBagLayoutPanel2 panel = new GridBagLayoutPanel2();
//
//		panel.setContents();
//		frame.add(panel);
//		
//		frame.setSize(800, 400);
//		frame.pack();// 버튼 안에 딱 넣어줌
//		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.changeCard("GRID");
	}

}
