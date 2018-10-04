import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class GameFrame extends Frame implements Runnable {
	int x = 50, distance = 5, y ;
	Image unit;
	Toolkit toolkit;

	public GameFrame(String title) {
		super(title);
		toolkit= Toolkit.getDefaultToolkit();
		unit = toolkit.getImage("src/resource/test.png");
		y = 50;
	}

	public void eventRegist() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				gameStart();
			}
		});
	}

	public void gameStart() {
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void paint(Graphics g) {
//		g.fillOval(x, 50, 100, 100);
		
		g.drawImage(unit, x, 50, this);
		g.drawImage(unit, y, 150, this);

	}

	@Override
	public void run() {
		Random random = new Random();
		while(true) {
			x += distance;
			y += Math.random()*10;
			repaint();
			try {
				Thread.sleep(random.nextInt(200));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		}
}
