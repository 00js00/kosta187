import java.time.Year;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalenderExample {

	public static int getWorks(String year, String month, String date) {
		int firstyear = Integer.parseInt(year);
		int firstmonth = Integer.parseInt(month);
		int firstdate = Integer.parseInt(date);
		Calendar firsttoday = Calendar.getInstance();
//		firsttoday.set(Calendar.YEAR,firstyear);
//		firsttoday.set(Calendar.MONTH,firstyear);
//		firsttoday.set(Calendar.DATE,firstyear);
		firsttoday.set(firstyear,firstmonth-1,firstdate); // month 0부터 시작
		Calendar secondtoday = Calendar.getInstance();
		return (int)((secondtoday.getTimeInMillis() - firsttoday.getTimeInMillis())/(1000*60*60*24));
		
	}
	
	
	public static void main(String[] args) {
//		Calendar today = new Calendar();
//		Calendar today = new GregorianCalender();
//		today = new GregorianCalendar()	;

		Calendar today = Calendar.getInstance();
		// string pool처럼 이미 있으면 생성된 애를 제공받음
		// 추상 클래스

		today.set(Calendar.YEAR, 1987);
		// 특정날자 가지고 싶으면 set
		System.out.println(today);
		int year = today.get(Calendar.YEAR);// enum아님
		int month = today.get(Calendar.MONTH);// enum아님
		int date = today.get(Calendar.DATE);// enum아님
		int day = today.get(Calendar.DAY_OF_WEEK);// 일요일 =1 --> switch case로 정해줘야함
		System.out.println(year);
		System.out.println(month + 1);
		System.out.println(date);
		System.out.println(day);

		System.out.println(year + "-" + (month + 1) + "-" + date);
		switch (day) {
		case Calendar.SUNDAY:
			System.out.println("일요일");
			break;
		case Calendar.MONDAY:
			System.out.println("월요일");
			break;
		case Calendar.TUESDAY:
			System.out.println("화요일");
			break;
		case Calendar.WEDNESDAY:
			System.out.println("수요일");
			break;
		case Calendar.THURSDAY:
			System.out.println("목요일");
			break;
		case Calendar.FRIDAY:
			System.out.println("금요일");
			break;
		case Calendar.SATURDAY:
			System.out.println("토요일");
			break;
		}
//------------------------------------------------이전꺼 -------------------------------------------		
		System.out.println(String.format("%tY", Calendar.getInstance())); // 4자리년도
		System.out.println(String.format("%ty", Calendar.getInstance())); // 2자리년도
		System.out.println(String.format("%tm", Calendar.getInstance())); // 숫자월
		System.out.println(String.format("%tB", Calendar.getInstance())); // 문자열월
		System.out.println(String.format("%td", Calendar.getInstance())); // 일
		System.out.println(String.format("%tA", Calendar.getInstance())); // 요일

		System.out.println(String.format("%tH", Calendar.getInstance())); // 24시간
		System.out.println(String.format("%1$tp %tI", Calendar.getInstance())); // 오전/오후
																				// 12시간System.out.println(String.format("%tM",
																				// Calendar.getInstance())); //분
		System.out.println(String.format("%tS", Calendar.getInstance())); // 초

		System.out.println(String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS %1$tA", Calendar.getInstance()));

		// 날짜/시간 합성문자 사용
		System.out.println(String.format("%1$tF %1$tT", Calendar.getInstance())); // tF 년월일 tT 시간! 

		//근무일수 구하기
		int value = getWorks("1987","3","1");
		System.out.println(value);
	}
}
