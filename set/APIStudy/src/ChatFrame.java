import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;

import javax.tools.Tool;

import java.awt.Frame;

public class ChatFrame extends Frame { 
//	extends Panel 로하는게 재사용하기가 좋음
	Label serverL;
	TextField serverTF, inputTF;
	Button connectB, sendB; // 의미있는 이름부터
	TextArea messageTA;
	List userLists;

	public ChatFrame() {
		this("이름없음");
	}

	public ChatFrame(String title)  {
		super(title);
		serverL = new Label("서버");
		serverTF = new TextField(10	);
		inputTF = new TextField(10);
		connectB = new Button("연결");
		sendB = new Button("전송");
		messageTA = new TextArea(10,30);
		userLists = new List();
	}
	
	//화면 배치 - 위에 생성자에서 구성할 수도 있지만 외부에서 정의하는거 여기에서 정의하는게 좋을듯
	public void setContents() {
		
		//색상설정
//		connectB.setEnabled(false);//활성화, 비활성화 시킬 때 - false : 비활성화
//		connectB.setBackground(new Color(100, 50, 122));
//		connectB.setBackground(Color.BLUE); //자주쓰이는 색갈은 미리 지정되어있음 
//		connectB.setForeground(Color.WHITE);
		//글씨체 바꾸기
//		connectB.setFont(new Font("궁서", Font.BOLD, 20)); 
		
		
		Panel northP = new Panel();
		northP.setLayout(new BorderLayout());
		northP.add(serverL, BorderLayout.WEST);
		northP.add(serverTF, BorderLayout.CENTER);
		northP.add(connectB, BorderLayout.EAST);
		
		Panel southP = new Panel()	;
		southP.setLayout(new BorderLayout());
		southP.add(inputTF, BorderLayout.CENTER);
		southP.add(sendB, BorderLayout.EAST);
		
		add(northP,BorderLayout.NORTH);
		add(messageTA,BorderLayout.CENTER);
		add(userLists,BorderLayout.EAST);
		add(southP,BorderLayout.SOUTH);

		
//		setLocation(100, 100);
//		가운데에 위치시키고 싶으면 ? - 해상도를 알아와야함(동적) , 창의 크기를 알아야함 : (전체 - 창의크기)/2
//		setColorAll(Color.BLUE); //위에 설정한 다음에 색을 입히는것.. 마지막에 와야함
	}
	public void setCenter() {
//		Runtime.getRuntime().exec(command); /*new 안됨 . static 형식도 아님 : abstract 형식 */
		Toolkit.getDefaultToolkit().beep(); //-- 틀리면 삐-- 소리나는 기능
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); 

		
		int x = (dim.width - getSize().width)/2;
		int y = (dim.height - getSize().height)/2;
		setLocation(x, y);
		
	}
	private void setColorAll(Color bg) { //color bg로 전체 색상을 다 똑같이 만들겠따
		Component[] componet = getComponents();
		for (Component component : componet) {// 패널을 들고옴 : 적용하고 싶은건 패널의 자식들도 : 루프 또 돌아야함
			if(component instanceof Panel) {
				Component[] cs= ((Panel) component).getComponents();
				for (Component c : cs) {
					c.setBackground(bg);
				}
			}
			component.setBackground(bg);
			
		}
		
	}
	
	public static void main(String[] args) {
		ChatFrame frame = new ChatFrame("KOTALK");
		frame.setContents();
		frame.setSize(400,500);
		frame.setVisible(true);
		frame.setCenter();
		
	}
	
	
}
