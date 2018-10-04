import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class YongWaitingPanel extends Panel {
 	Frame frame;
	Button roomSearchB, enterB, makeB;
	Label searchL, roomSearchL, waitingL, participateL, roomNumL, leaderL, roomTitleL, MaxNumL;
	TextField roomSearchTF;
	List roomList, waitingList, participateList;
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	Image yongRight;

	public YongWaitingPanel() {
		yongRight = Toolkit.getDefaultToolkit().getImage("C:\\Users\\KOSTA\\Desktop\\YongReverse.png");
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();

		roomSearchB = new Button("검색");
		enterB = new Button("입장");
		makeB = new Button("방만들기");

		searchL = new Label("방제목");
		waitingL = new Label("대기인원");
		waitingL.setAlignment(Label.RIGHT);
		participateL = new Label("참여인원"); 
		participateL.setAlignment(Label.RIGHT);

		roomNumL= new Label("방번호");
		leaderL = new Label("방장");
		roomTitleL= new Label("방제목");
		MaxNumL = new Label("최대인원");

		roomSearchTF = new TextField(3);
		roomList = new List();
		waitingList = new List();
		participateList = new List();
		setContents();
		setCenter();
	}

	public void setContents() {

		Panel southP = new Panel();
		southP.add(enterB);
		southP.add(makeB);

		setLayout(gridBagLayout);
		
		add(searchL, 		 0, 0, 1, 1, 0, 0);
		add(roomSearchTF, 	 1, 0, 3, 1, 2, 0);

		add(roomSearchB, 	 4, 0, 1, 1, 0, 0);
		
		add(roomNumL, 		 0, 1, 1, 1, 1, 0);
		add(leaderL, 		 1, 1, 1, 1, 1, 0);
		add(roomTitleL, 	 2, 1, 1, 1, 1, 0);
		add(MaxNumL, 		 3, 1, 1, 1, 1, 0);
		
		add(waitingL, 		 4, 1, 2, 1, 0, 0);
		add(waitingList,     4, 2, 2, 1, 1, 1);
		
		add(roomList, 		 0, 2, 4, 3, 2, 2);

		add(participateL,    4, 3, 2, 1, 0, 0);
		add(participateList, 4, 4, 2, 1, 1, 1);

		add(southP, 0, 5, 8, 1, 0, 0);

		
		
	}
	@Override
	public void paint(Graphics g) {
		g.drawImage(yongRight,450 , 0,20,20, this);
	}

	private void add(Component component, int gridx, int gridy, int gridwidth, int gridheight, double weightx,
			double weighty) {

		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		gridBagConstraints.gridheight = gridheight;
		gridBagConstraints.gridwidth = gridwidth;
		gridBagConstraints.weightx = weightx;
		gridBagConstraints.weighty = weighty;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
//		gridBagConstraints.insets = new Insets(2, 2, 2, 2);

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
		YongWaitingPanel panel = new YongWaitingPanel();
//		panel.setBackground(Color.yellow);
		frame.add(panel);
		frame.setSize(500, 400);
		frame.setVisible(true);
		

	}
	public void eventRegist() {
		makeB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
}
