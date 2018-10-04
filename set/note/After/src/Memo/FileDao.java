package Memo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDao {


	public FileDao(){
		// TODO Auto-generated constructor stub
	}

	public String read(String path) throws IOException{
		FileReader in = new FileReader(path);
		BufferedReader br = new BufferedReader(in);
		String txt = null;
		String temp = null;
		while((txt = br.readLine())!= null) {
//			.memoTA.append(txt+"\n");
//			System.out.println(txt);
			temp += txt;
		}
		br.close();
		in.close();
		return temp;
	}
	
	public void save(String path, String message) throws IOException {
//		String memo = memoFrame.memoTA.getText();
		FileWriter out = new FileWriter(path);
		BufferedWriter bw = new BufferedWriter(out);
		bw.write(message);
		bw.close();
		out.close();
		
	}
}
