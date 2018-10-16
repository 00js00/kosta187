package pattern;

import java.awt.Toolkit;
import java.io.IOException;

public class SingletoneExample {

	public static void main(String[] args) throws IOException {
//		Logger logger = new Logger();
		Logger logger = Logger.getInstance();
		Logger logger2 = Logger.getInstance();
		logger.setTest("ddd");
		
		System.out.println(logger2.getTest());
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Runtime runtime = Runtime.getRuntime();
		runtime.exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
	}

}
