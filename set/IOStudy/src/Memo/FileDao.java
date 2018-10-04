package Memo;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDao {
	MemoFrame frame;

	public FileDao() {
		// TODO Auto-generated constructor stub
	}

	public void fileOpen() throws IOException {
		FileDialog fileOpen;
		fileOpen = new FileDialog(frame, "open file", FileDialog.LOAD);
		fileOpen.setVisible(true);

		String path = fileOpen.getDirectory() + fileOpen.getFile();
		FileReader in = new FileReader(path);
		BufferedReader br = new BufferedReader(in);
		String txt = null;
		while ((txt = br.readLine()) != null) {
			frame.memoTA.append(txt + "\n");
		}
		br.close();
		in.close();
	}

	public void fileSave() throws IOException {
		FileDialog fileSave;
		fileSave = new FileDialog(frame, "save file", FileDialog.SAVE); // 어느 위에 올라올 것인지!
		fileSave.setVisible(true);
		String path = fileSave.getDirectory() + fileSave.getFile();

		String memo = frame.memoTA.getText();
		FileWriter out = new FileWriter(path);
		BufferedWriter bw = new BufferedWriter(out); // 인코딩 기능까지 첨부되어 있는 것
		bw.write(memo);
		bw.close();

	}

	public void setFrame(MemoFrame frame) {
		this.frame = frame;
	}

}
