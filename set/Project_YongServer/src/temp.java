import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class temp extends JFrame {
	JPanel panel;
	Image image2;

	public temp() {
//		Toolkit tk = Toolkit.getDefaultToolkit();
		image2 = Toolkit.getDefaultToolkit().getImage("C:\\Users\\KOSTA\\Desktop\\YongTalk.png");
		panel = new JPanel() {
			@Override
			public void paint(Graphics g) {
				g.drawImage(image2, 0, 0, this);
			}
		};

		add("Center", panel);

		add("North", new JLabel("패널에 이미지 넣기"));

		setBounds(200, 200, 300, 300);

		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {

		new temp();

	}

}