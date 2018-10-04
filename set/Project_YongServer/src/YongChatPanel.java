import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;

public class YongChatPanel extends Panel {
	// Owner
Frame frame;
	// layout
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;

	// properties
	public Label nickNameL;
	public TextField nickNameTF;
	public Button joinB;
	Panel panel;
	Image yongLeft, yongChat, yongRight;

	public YongChatPanel() {
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		nickNameL = new Label("대화명을 입력하세요");
		nickNameL.setAlignment(Label.CENTER);

		nickNameTF = new TextField(15);
		joinB = new Button("입장하기");
		yongLeft = Toolkit.getDefaultToolkit().getImage("C:\\Users\\KOSTA\\Desktop\\Yong.png");
		yongChat = Toolkit.getDefaultToolkit().getImage("C:\\Users\\KOSTA\\Desktop\\YongTalk.png");
		yongRight = Toolkit.getDefaultToolkit().getImage("C:\\Users\\KOSTA\\Desktop\\YongReverse.png");
		setContents();
		setCenter();

	}

	public void setContents() {
		setLayout(gridBagLayout);
		add(new Label(""), 0, 1, 1, 1, 0, 0);
		add(new Label(" "), 0, 2, 1, 1, 0, 0);
		add(nickNameL,   0, 3, 2, 1, 0, 0);

		add(nickNameTF,  0, 4, 1, 1, 0, 0);
		add(joinB,  1, 4, 1, 1, 0, 0);

	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(yongLeft,10 , 150,110,110, this);
		g.drawImage(yongChat,50 , 0,380,170, this);
		g.drawImage(yongRight,370 , 150,110,110, this);
	}

	/**
	 * component 추가하는 메소드
	 * 
	 * @param component  Component종류
	 * @param gridx      x축위치
	 * @param gridy      y축위치
	 * @param gridwidth  차지하는 폭
	 * @param gridheight 차지하는 높이
	 * @param weightx    x축 가중치
	 * @param weighty    y축 가중치
	 */
	private void add(Component component, int gridx, int gridy, int gridwidth, int gridheight, double weightx,
			double weighty) {
		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		gridBagConstraints.gridwidth = gridwidth;
		gridBagConstraints.gridheight = gridheight;
		gridBagConstraints.weightx = weightx;
		gridBagConstraints.weighty = weighty;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);// 여백조절

		gridBagLayout.setConstraints(component, gridBagConstraints);
		add(component);
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
		panel.setBackground(Color.LIGHT_GRAY);
		frame.add(panel);
		frame.setSize(500, 400);
		frame.setVisible(true);

	}
}