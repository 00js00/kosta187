import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame; // frame을 재사용
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class UserFrame extends Frame implements MouseListener, WindowListener{
//	String title;
	Button eButton, wButton,sButton,nButton,cButton;

	public UserFrame() {
		this("이름없음");
	}

	public UserFrame(String title)  {
		super(title);
		this.eButton = new Button("East");
		this.wButton = new Button("West");
		this.sButton = new Button("South");
		this.nButton = new Button("North");
		this.cButton = new Button("Center");
	}
	
	//화면 배치 - 위에 생성자에서 구성할 수도 있지만 외부에서 정의하는거 여기에서 정의하는게 좋을듯
	public void setContents() {
		setLayout(new FlowLayout());// 레이아웃교체 - 인터페이스 
		add(eButton, BorderLayout.EAST);
		add(wButton, BorderLayout.WEST);
		add(sButton, BorderLayout.SOUTH);
		add(nButton, BorderLayout.NORTH);
		add(cButton, BorderLayout.CENTER);
		// 이벤트 소스에 이벤트 리스너 연결
//		eButton.addMouseListener(this);
	}
	
	public void eventRegist() {
		eButton.addMouseListener(this);
		wButton.addMouseListener(this);
		sButton.addMouseListener(this);
		nButton.addMouseListener(this);
		cButton.addMouseListener(this);
		addWindowListener(this);
	}
	
	public static void main(String[] args) {
		UserFrame frame = new UserFrame("타이틀입니다.");
		frame.setContents();
		frame.setSize(800,600);
		frame.setVisible(true);
		frame.eventRegist();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("마우스 클릭되었습니다..");
//		eButton
		Object eventSourse = e.getSource();
		Button button = (Button)eventSourse;
		int r = (int)(Math.random()*256);
		int g = (int)(Math.random()*256);
		int b = (int)(Math.random()*256);
		button.setBackground(new Color(r, g, b));
		if(eventSourse == eButton) {
			System.out.println("east 클릭이요");
//			button.setBackground(Color.BLUE);
		} else if(eventSourse == wButton) {
			System.out.println("west 클릭이요");

		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed() called... ");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased() called... ");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEnterd() called... ");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited() called... ");
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("창이 열렸습니다.. ");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		setVisible(false);
		dispose();// os에 그래픽리소스 반납
		// TODO Auto-generated method stub
		System.exit(0);
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
