
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;

public class YongChatPanel extends Panel {

	// owner
//	YongMainFrame mainFrame;
	Frame frame;

	// layout
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;

	// property
	public Button exitB, inviteB, sendB;
	public Choice choice;
	public TextArea messageTA;
	public List inUserList, waitUserList;
	public TextField sendTF;
	public Label inUserL, waitUserL;
	Panel panel;
	Image yongRight;

	public YongChatPanel() {
//		this.mainFrame = mainFrame;
		inviteB = new Button("초대하기");
		sendB = new Button("전송");
		choice = new Choice();
		choice.add("전체");
		messageTA = new TextArea(1, 1);
		inUserList = new List();
		waitUserList = new List();
		sendTF = new TextField(1);
		inUserL = new Label("참여자");
		waitUserL = new Label("대기자");
		exitB = new Button("나가기");
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
	    yongRight = Toolkit.getDefaultToolkit().getImage("./bin/resources/yong_right.png");
	    setContents();
	    setCenter();
	}


	public void setContents() {

		setLayout(gridBagLayout);

		add(messageTA, 0, 0, 2, 5, 2, 1);
		add(exitB, 2, 0, 1, 1, 0, 0);
		
		add(waitUserL, 2, 1, 1, 1, 0, 0);
		add(inviteB, 3, 1, 1, 1, 0, 0);

		add(waitUserList, 2, 2, 2, 1, 0, 1);

		add(inUserL, 2, 3, 2, 1, 0, 0);

		add(inUserList, 2, 4, 2, 1, 0, 1);

		add(choice, 0, 5, 1, 1, 0, 0);
		add(sendTF, 1, 5, 2, 1, 0, 0);
		add(sendB, 3, 5, 1, 1, 0, 0);

	}

	/**
	 * component 추가하는 메소드
	 * 
	 * @param component
	 *            Component종류
	 * @param gridx
	 *            x축위치
	 * @param gridy
	 *            y축위치
	 * @param gridwidth
	 *            차지하는 폭
	 * @param gridheight
	 *            차지하는 높이
	 * @param weightx
	 *            x축 가중치
	 * @param weighty
	 *            y축 가중치
	 */
	private void add(Component component, int gridx, int gridy, int gridwidth, int gridheight, double weightx,
			double weighty) {
		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		gridBagConstraints.gridwidth = gridwidth;
		gridBagConstraints.gridheight = gridheight;
		gridBagConstraints.weightx = weightx;
		gridBagConstraints.weighty = weighty;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);// 여백조절

		gridBagLayout.setConstraints(component, gridBagConstraints);
		add(component);
	}
	
	@Override
    public void paint(Graphics g) {
       g.drawImage(yongRight,450 , 0,20,20, this);
    }



	public void setCenter() {
		Toolkit.getDefaultToolkit().beep();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		int x = (dim.width - getSize().width) / 2;
		int y = (dim.height - getSize().height) / 2;
		setLocation(x, y);

	}
	public static void main(String[] args) {
		Frame frame = new Frame();
		YongChatPanel panel = new YongChatPanel();
//		panel.setBackground(Color.LIGHT_GRAY);
		frame.add(panel);
		frame.setSize(500, 400);
		frame.setVisible(true);

	}
}