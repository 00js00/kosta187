import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Window;

public class ContainerExample {

	public static void main(String[] args) {
		Frame owner = new Frame();
		owner.setSize(400, 200);
		owner.setVisible(true);
		
		Dialog dialog = new Dialog(owner,"타이틀",false);
		dialog.setSize(200, 200);
		dialog.setVisible(true);
//		
//		Window window = new Window(owner); // -완전 그냥 흰 창
//		window.setSize(400,200);
//		window.setVisible(true);
//		
//		FileDialog fd = new FileDialog(owner, "파일열기", FileDialog.LOAD);
//		FileDialog fd2 = new FileDialog(owner, "파일저장", FileDialog.SAVE);
//		fd.setVisible(true);
//		fd2.setVisible(true);
		//파일창이 딱 정해져있어서 setSize안해됨
	}

}
