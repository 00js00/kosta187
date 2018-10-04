import java.util.Formatter;

public class FommatterExample {

	public static void main(String[] args) {
		int number = 1234567;
		Formatter formatter = new Formatter(); //shift f2
		// Formatter format(String format,Object... args) --> 출력하고자하는 형식, 출력하고자하는 데이터, 여러개라서 비정형
		// format : "%[출력인자순서$][출력옵션(-, +, (,,..)][출력자리수][.소수점이하자리수]출력데이터유형" 
//		-->위치값 지정 1$, 2$,, 안쓰면 1번, - : 좌정렬, , : 세자리로 점 찍어줘 + 쁠러스 다는것 등등 : 도큐먼트 보기
//		출력자리수: 출력 칸 지정 , 소수점이하자리수 : 반올림해줌
//		'출력데이터 유형 ' 생략불가
		// args : 포맷팅 하고자 하는 가변인자
		String formatedString = null;
		formatedString = formatter.format("%d", number).toString(); //%d(숫자) : 정수 //formatter : formatter.format("%d", number) 로 출력
		System.out.println(formatedString);

		formatter = new Formatter();
		// 우측정렬 후 정수로 출력
		System.out.println(formatter.format("%1$d", number)); //1$ -> number을 디시멀로 참조
//		System.out.println(formatter.format("%2$d", number, 500)); //1$ -> 500을 디시멀로 참조

		formatter = new Formatter();
		// 20자리확보하고, 3자리단위 콤마 찍고, 부호달고, 좌측정렬 후 정수로 포맷
		System.out.println(formatter.format("%,+-20d", number));

		double height = 23454.34343434356;
		formatter = new Formatter();
		// 20자리확보하고, 3자리단위 콤마 찍고, 부호달고, 좌측정렬 후 소수점 이하 2자리 실수로 포맷
		System.out.println(formatter.format("%,+-20.2f", height));
		
		
		String name = "김기정";
		formatter = new Formatter();
		// 10자리확보하고 우측정렬 후 문자열 포맷
		System.out.println(formatter.format("%10s", name));

		formatter = new Formatter();
		System.out.println(formatter.format("%o", 150)); //8진수 포맷
		System.out.println(formatter.format("%x", 458)); //16진수 포맷

		// 도스콘솔 전용
		System.out.printf("%,+-10d\n", 198745);
		System.out.printf("%1$,-10d와 %2$,10d\n", 1000, 2000);

		// String 클래스의 클래스메소드 활용
		String fs = String.format("%,20.2f\n", 198745.678);
		System.out.println(fs); // autoboxing 일어나는중
		
	}

}
