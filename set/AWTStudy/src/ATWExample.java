import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;

public class ATWExample {

	public static void main(String[] args) {
		Frame frame = new Frame("처음으로 만드는 프레임");
		frame.setSize(1000, 800);//무조건 픽셀단위
		frame.setVisible(true);
		
		Button button1 = new Button("AWT 버튼1");
		Button button2 = new Button("AWT 버튼2");
		
		frame.setLayout(new FlowLayout());
		frame.add(button1); // 좌표값 배치 X (공간을 줄이면 밑으로 빠짐 )
		frame.add(button2);
		
		Label label = new Label("AWT Label");
		frame.add(label);
		TextField textfield = new TextField("아이디",10);
		frame.add(textfield);
		TextArea textarea = new TextArea(5,30);
		frame.add(textarea);
		Checkbox checkbox = new Checkbox("남자", true);
		frame.add(checkbox);
		CheckboxGroup cg = new CheckboxGroup();
		Checkbox cb1 = new Checkbox("Male",true,cg);
		Checkbox cb2 = new Checkbox("Female",false,cg);
		frame.add(cb1);
		frame.add(cb2);
		
		Choice selectBox = new Choice();
		selectBox.add("박찬호");
		selectBox.add("박지성");
		selectBox.add("박찬숙");
		frame.add(selectBox);
		
//		frame.setResizable(false);
		
	}

}
