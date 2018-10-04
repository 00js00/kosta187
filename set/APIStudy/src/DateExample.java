import java.util.Date;

public class DateExample {

	public static void main(String[] args) {
		Date today = new Date();
		System.out.println(today.getYear()); // Y2K 오류
		System.out.println(today.toString()); //외국포맷
		System.out.println(today.toLocaleString()); //우리나라 포맷으로
		System.out.println(today.getTime()); //그리니치 표준시 - 밀리세컨드로 반환
		
		
	}

}
