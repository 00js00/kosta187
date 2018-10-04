import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

public class GridPanel extends Panel {
//버튼 9개 담을 수 있는 배열 생성
	Button[] buttons;
	public GridPanel() {
		buttons = new Button[100];
		

		setLayout(new GridLayout(10, 10)); //ㄹ자로 순차적으로 격자 순서대로 들어감
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new Button(i+1 + "Button");
			add(buttons[i]);
		}
	}
	public static void main(String[] args) {
		Frame frame = new Frame("GridLayout Example");
		
		GridPanel panel = new GridPanel()	;
		frame.add(panel);
		
		frame.setSize(500,500);
		frame.setVisible(true);
		
	}
}
