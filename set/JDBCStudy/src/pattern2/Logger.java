package pattern2;

import java.util.Calendar;

/**
 * 싱글톤 패턴 적용 클래스
 * 
 * @author 서지원
 *
 */
public class Logger {
	private static Logger logger = new Logger();
	private String test;
	
	private Logger() {
	}

	public static Logger getInstance() {
		return logger;
	}

	public void log(String message) {
		Calendar today = Calendar.getInstance();
		String time = String.format("%1$tF %1$tT", today);
		System.out.println("[" + time + "]" + message);
	}

	public String getTest() {
		return test;
	}
	
	public void setTest(String test) {
		this.test = test;
	}

}
