import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame  extends JFrame {
	JPanel panel;
	Image image2;
	YongChatPanel Panel;
	
	public static void main(String[] args) {
		Frame frame = new Frame();
		YongChatPanel panel = new YongChatPanel();
		frame.add("Center",panel);
		frame.setSize(500, 400);
		frame.setVisible(true);
	}
}
