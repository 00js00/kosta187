import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {
	// 제일 먼저 시작
	static {
		String path = "config.properties";

		Properties prop = new Properties();// 빈 맵이 생성됨
		try {
			prop.load(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prop.put("last", "lastValue");

		System.out.println(prop.getProperty("name1"));
		prop.elements();
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		/*//주로 static 초기화 블록에서 진행
		String path = "config.properties";

		Properties prop = new Properties();// 빈 맵이 생성됨
		prop.load(new FileInputStream(path));
		prop.put("last", "lastValue");

		System.out.println(prop.getProperty("name1"));
		prop.elements();*/
		System.out.println("프로그램 시작됨..");
	}
}