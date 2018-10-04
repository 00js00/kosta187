import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Exithandler extends WindowAdapter{
	
	ChatFrame frame;
	
	public Exithandler(ChatFrame frame) {
		this.frame = frame;
	}
	
	
	@Override
	public void windowClosing(WindowEvent e) {
		frame.finish();
	}


}
