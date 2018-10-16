 import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.List;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
import javax.swing.JPopupMenu.Separator;
import javax.tools.Tool;

import java.awt.Frame;
import java.awt.Graphics;

public class ChatFrame extends Frame {
//	extends Panel 로하는게 재사용하기가 좋음
	Label serverL;
	TextField serverTF, inputTF;
	Button connectB, sendB; // 의미있는 이름부터
	TextArea messageTA;
	List userList;
	
//	메뉴 : 컴포넌트 
	MenuBar menuBar;
	Menu menu;
	MenuItem newMI, exitMI;
	

	public ChatFrame() {
		this("이름없음");
	}

	public ChatFrame(String title) {
		super(title);
		serverL = new Label("서버");
		serverTF = new TextField(10);
		inputTF = new TextField(10);
		connectB = new Button("연결") {
			//하고싶은 메소드 추가 가능 + 오버라이딩도 가능
			@Override
			public void paint(Graphics g) {
				g.drawLine(10,10,50,10);
			}
		};
		sendB = new Button("전송");
		messageTA = new TextArea(10, 30);
		userList = new List();
		userList.add("말미잘");
		userList.add("꼴뚜기");
		userList.add("머저리");
		
		menuBar = new MenuBar()	;
		menu = new Menu("File");
		newMI = new MenuItem("New");
		newMI.setShortcut(new MenuShortcut(KeyEvent.VK_N,true));// 단축키 지정  : true - shift 누르고! 
		exitMI = new MenuItem("Exit");
		exitMI.setShortcut(new MenuShortcut(KeyEvent.VK_X,false));

		

	}

	// 화면 배치 - 위에 생성자에서 구성할 수도 있지만 외부에서 정의하는거 여기에서 정의하는게 좋을듯
	public void setContents() {

		// 색상설정
//		connectB.setEnabled(false);//활성화, 비활성화 시킬 때 - false : 비활성화
//		connectB.setBackground(new Color(100, 50, 122));
//		connectB.setBackground(Color.BLUE); //자주쓰이는 색갈은 미리 지정되어있음 
//		connectB.setForeground(Color.WHITE);
		// 글씨체 바꾸기
//		connectB.setFont(new Font("궁서", Font.BOLD, 20)); 

		Panel northP = new Panel();
		northP.setLayout(new BorderLayout());
		northP.add(serverL, BorderLayout.WEST);
		northP.add(serverTF, BorderLayout.CENTER);
		northP.add(connectB, BorderLayout.EAST);

		Panel southP = new Panel();
		southP.setLayout(new BorderLayout());
		southP.add(inputTF, BorderLayout.CENTER);
		southP.add(sendB, BorderLayout.EAST);

		add(northP, BorderLayout.NORTH);
		add(messageTA, BorderLayout.CENTER);
		add(userList, BorderLayout.EAST);
		add(southP, BorderLayout.SOUTH);

		setLocation(100, 100);
//		가운데에 위치시키고 싶으면 ? - 해상도를 알아와야함(동적) , 창의 크기를 알아야함 : (전체 - 창의크기)/2
//		setColorAll(Color.BLUE); //위에 설정한 다음에 색을 입히는것.. 마지막에 와야함
		
		
//		현재 프레임에 : menu bar 붙이기
		setMenuBar(menuBar);
		menuBar.add(menu);
		menu.add(newMI);
		menu.addSeparator();
		menu.add(exitMI);
		
		
	}

	public void setCenter() {
//		Runtime.getRuntime().exec(command); /*new 안됨 . static 형식도 아님 : abstract 형식 */
		Toolkit.getDefaultToolkit().beep(); // -- 틀리면 삐-- 소리나는 기능
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		int x = (dim.width - getSize().width) / 2;
		int y = (dim.height - getSize().height) / 2;
		setLocation(x, y);

	}

	private void setColorAll(Color bg) { // color bg로 전체 색상을 다 똑같이 만들겠따
		Component[] componet = getComponents();
		for (Component component : componet) {// 패널을 들고옴 : 적용하고 싶은건 패널의 자식들도 : 루프 또 돌아야함
			if (component instanceof Panel) {
				Component[] cs = ((Panel) component).getComponents();
				for (Component c : cs) {
					c.setBackground(bg);
				}
			}
			component.setBackground(bg);

		}
	}

//많이 씀
	public void appendMessage() {
		String message = inputTF.getText();
//			messageTA.setText("")); 통으로 덮어씌우는것
		messageTA.append(message + "\n");
		inputTF.setText(""); // 안에 내용 빈칸으로 덮어씌우기
	}

	public void finish() {
		setVisible(false);
		dispose();
		System.exit(0);
	}

	public void eventRegist() {
//		/* 이름있는 지역 내부 클래스 */
//		class Exiter extends WindowAdapter {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				finish();
//			}
//		}
		/* 이름없는 지역 내부 클래스 -- 가장 많이 사용하는 방법 */
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				finish();
			}
		}/* Exiter/*Exiter() */);

		inputTF.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				String message= inputTF.getText();
////				messageTA.setText("")); 통으로 덮어씌우는것
//				messageTA.append(message + "\n");
//				inputTF.setText(""); // 안에 내용 빈칸으로 덮어씌우기
				appendMessage();
			}
		});
		serverTF.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
//				System.out.println(e.getKeyCode()); // 분류만하는것
				System.out.println(e.getKeyChar());
				System.out.println(KeyEvent.VK_ENTER); // if문으로 .. VK_ENTER가 true인지~ 해서 할 수 있음
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		inputTF.addTextListener(new TextListener() { // 하나 입력할때마다 새로생김

			@Override
			public void textValueChanged(TextEvent e) {
				System.out.println(inputTF.getText());
			}
		});

		userList.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// 아이템 선택할 때의 이벤트
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String name = userList.getSelectedItem();
//					JOptionPane.showMessageDialog(null, name + "님 선택이요", "알림", JOptionPane.INFORMATION_MESSAGE);
					JOptionPane.showMessageDialog(null, name + "님 선택이요", "알림", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		exitMI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				finish();
			}
		});

	}

//	/**
//	 * 멤버내부클래스를 이용한 이벤트처리 */
//	class Exiter extends WindowAdapter{
//		@Override
//		public void windowClosing(WindowEvent e) {
//			finish();
//		}
//	}

	public static void main(String[] args) {
		ChatFrame frame = new ChatFrame("KOTALK");
		frame.setContents();
		frame.setSize(400, 500);
		frame.setCenter();
		frame.eventRegist();
		frame.setVisible(true);

	}

}
