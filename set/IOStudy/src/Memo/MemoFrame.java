package Memo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class MemoFrame extends Frame {
	FileDao dao;
//	extends Panel 로하는게 재사용하기가 좋음
	TextArea memoTA;
//	메뉴 : 컴포넌트 
	MenuBar menuBar;
	Menu menu;
	MenuItem newMI, openMI, saveMI, exitMI;

	public MemoFrame() {
		this("메모장");
	}

	public MemoFrame(String title) {
		super(title);

		memoTA = new TextArea(10, 30);

		menuBar = new MenuBar();
		menu = new Menu("File");
		newMI = new MenuItem("New");
		newMI.setShortcut(new MenuShortcut(KeyEvent.VK_N, true));
		openMI = new MenuItem("open");
		saveMI = new MenuItem("save");
		exitMI = new MenuItem("Exit");
		exitMI.setShortcut(new MenuShortcut(KeyEvent.VK_X, false));
		dao = new FileDao();

	}

	public void setContents() {

		Panel panel = new Panel();
		panel.setLayout(new BorderLayout());
		panel.add(memoTA, BorderLayout.CENTER);

		setLocation(100, 100);
		add(panel);
		setMenuBar(menuBar);
		menuBar.add(menu);
		menu.add(newMI);
		menu.addSeparator();
		menu.add(openMI);
		menu.addSeparator();
		menu.add(saveMI);
		menu.addSeparator();
		menu.add(exitMI);

	}

	public void init() {
		this.setSize(550, 500);
		this.setVisible(true);
		this.setContents();
		this.eventRegist();
		dao.setFrame(this);
	}

	public void setCenter() {
		Toolkit.getDefaultToolkit().beep();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		int x = (dim.width - getSize().width) / 2;
		int y = (dim.height - getSize().height) / 2;
		setLocation(x, y);

	}

	public void finish() {
		setVisible(false);
		dispose();
		System.exit(0);
	}

	public void eventRegist() {
		openMI.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					dao.fileOpen();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		saveMI.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					dao.fileSave();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		newMI.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				memoTA.setText(" ");
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
