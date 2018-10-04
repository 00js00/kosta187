package ObjectStream;

import java.awt.Frame;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.Vector;

import demo.accounts.Account;

public class ObjectStreamExample {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		String path = "example7.ser";// : ojbect 저장하기 위한확장자 : ser - serialized
				
		int age = 28;
		double weight = 45.6;
		String message = "오브젝트 스트림 실습,,,";
		Calendar today = Calendar.getInstance();
		Frame frame = new Frame("타이틀");
		frame.setSize(500,200);
		
		Account account = new Account("1111-1111-1111","김지원",1111,1000);
		Vector<Account> vector = new Vector<>();
		for (int i = 0; i < 50000; i++) {
			vector.addElement(new Account(i+"-2222-3333","1",1,1));
		}
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
		
		out.writeObject(age);
		out.writeObject(weight);
		out.writeObject(message);
		out.writeObject(today);
		out.writeObject(frame);
		out.writeObject(account);
		out.writeObject(vector);
		
//		if(!(account insatanceof Serializable)) {
//			throw new NotSerializableException();
//		} //account 가서 implements serializable 써야함 
		
		out.flush();
		out.close();
		
		System.out.println("다썼음..");
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
		
		age = 0;
		weight = 0;
		message = null;
		today = null;
		frame = null;
		
		age = (Integer)in.readObject(); // 다운캐스팅 해줘야함 
		weight = (Double)in.readObject();
		message = (String)in.readObject();
		today = (Calendar)in.readObject();
		frame = (Frame)in.readObject();
		account = (Account)in.readObject(); // not Serializable Exception : Account 객체에 Serializable 안써서 오류남
		vector = (Vector<Account>)in.readObject();
		
		System.out.println(age);
		System.out.println(weight);
		System.out.println(message);
		System.out.println(today);
		
		frame.setVisible(true);
		System.out.println(account);
		System.out.println(vector.size());
		in.close();
	}
}
