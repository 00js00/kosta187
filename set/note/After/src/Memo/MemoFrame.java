package Memo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class MemoFrame extends Frame {
//	Memo memo;
//	MemoFrame memoFrame;
	TextArea memoTA;
	MenuBar menuBar;
	Menu menu;
	MenuItem newMI, openMI, saveMI, exitMI;
	FileDao fileDao;

	public MemoFrame() {
		this("메모장");
	}

	public MemoFrame(String title) {
		super(title);
		memoTA = new TextArea(10, 30);
		menuBar = new MenuBar();
		menu = new Menu("File");
		newMI = new MenuItem("New");
		openMI = new MenuItem("Open");
		saveMI = new MenuItem("Save");
		exitMI = new MenuItem("Exit");
		fileDao = new FileDao();

	}
	
	public void SetContents() {
		Panel panel = new Panel();
		panel.setLayout(new BorderLayout());
		panel.add(memoTA, BorderLayout.CENTER);
		add(panel);
		setLocation(100,100);

		setMenuBar(menuBar);
		menuBar.add(menu);
		menu.add(newMI);
		menu.add(openMI);
		menu.add(saveMI);
		menu.add(exitMI);
	}
	public void setCenter() {
		Toolkit.getDefaultToolkit().beep();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize()	;
		
		int x = (dim.width - getSize().width)/2;
		int y = (dim.height - getSize().height)/2;
		setLocation(x,y);
	}
	public void finish() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
	public void init() {

		this.setSize(550, 550);
		this.setCenter();
		this.SetContents();
		this.setVisible(true);
		this.eventRegist();
	}
	
	public FileDialog showDialog(String str, int type) {
		FileDialog dialog = new FileDialog(this, str, FileDialog.LOAD);
		return dialog;
	}
	public void eventRegist() {
		openMI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
//				MemoFrame memoFrame = new MemoFrame();
				FileDialog fileOpen;
				
//				fileOpen = new FileDialog(memoFrame, "FileOpen", FileDialog.LOAD);
				fileOpen = showDialog("FileOpen",0);
//				fileOpen = new FileDialog()
				fileOpen.setVisible(true);
				String path = fileOpen.getDirectory()+ fileOpen.getFile();
				
				try {
					memoTA.setText(fileDao.read(path));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
			}
		});
		saveMI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				MemoFrame memoFrame = new MemoFrame();
				FileDialog fileSave;
				
				fileSave = showDialog("FileSave", 1);
				fileSave.setVisible(true);
				String message = memoTA.getText();
				
				
				String path = fileSave.getDirectory()+ fileSave.getFile();
				try {
					fileDao.save(path,message);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
									
			}
		});
		newMI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		exitMI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				finish();
			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
	}

}
