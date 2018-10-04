import java.io.IOException;

public class Foo {
	public void someMethod() {
		String message = null;
		System.out.println(message.length());
		int[] array = { 1, 2, 3 };
		System.out.println(array[3]); // Array index out of bounds exception

	}

	public static void main(String[] args) {
		System.out.println("JVM에 의해 프로그램 시작됨..");

		Foo foo = new Foo();
//		foo.someMethod(); // null point exception
//		foo.someMethod2();
//		try {  //예외처리대상X
			foo.someMethod3();
//		} catch (Exception e) {
//			System.out.println("메인에서 모든 예외처리 완료");
//		}
		try {
			int value = System.in.read();
			System.out.println(value);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("JVM에 의해 프로그램 종료됨..");
	}

	public void someMethod2() {
		try {
			String message = null;
			System.out.println(message.length());
//			System.out.println(10 / 0); // arithmetic exception
			int[] array = { 1, 2, 3 };
			System.out.println(array[3]); // Array index out of bounds exception
		} catch (NullPointerException e) {
//			System.out.println("인스턴스 생성 안 됐시유...");
			System.out.println(e.getMessage());
			e.printStackTrace(); // 콜스텍 내용 추적해봐라 - 비동기처리 되어있어서 순서가 어긋나서 나올수도있음
			return;
		} catch (ArithmeticException f) {
			System.out.println("인스턴스 생성 안 됐시유...");
			System.out.println(f.getMessage());
			f.printStackTrace(); // 콜스텍 내용 추적해봐라 - 비동기처리 되어있어서 순서가 어긋나서 나올수도있음
//			System.exit(0);: JVM강제종료
		} catch (ArrayIndexOutOfBoundsException g) {
			System.out.println("인스턴스 생성 안 됐시유...");
			System.out.println(g.getMessage());
			g.printStackTrace(); // 콜스텍 내용 추적해봐라 - 비동기처리 되어있어서 순서가 어긋나서 나올수도있음
		} catch (Exception e) {
			System.out.println("인스턴스 생성 안 됐시유...");
			System.out.println(e.getMessage());
			e.printStackTrace(); // 콜스텍 내용 추적해봐라 - 비동기처리 되어있어서 순서가 어긋나서 나올수도있음
		} finally {
			System.out.println("예외 발생 여부와 상관없이 항상 실행");
		}
	}

	public void someMethod3() throws NullPointerException, ArithmeticException, ArrayIndexOutOfBoundsException {
		String message = null;
		System.out.println(message.length());
		int[] array = { 1, 2, 3 };
		System.out.println(array[3]); // Array index out of bounds exception

	}

}
