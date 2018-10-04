import java.util.Random;

public class Car extends Thread {
	String name;

	public Car(String name) {
//		super(name); // 스레드의 name기능 오버라이딩 해서 가져온것
		setName(name);
	}

	public void run() { // 스레드의 엔트리 포인트
		Random random = new Random();
		System.out.println(getName() + "자동차가 달립니다..");
		for (int i = 0; i <= 100; i++) {
			System.out.println(getName() + "자동차 " + i + "미터 전진");
			try {
				Thread.sleep(random.nextInt(500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // cpu 잠깐 멈추게만듦 
		}
		System.out.println(getName() + "finish");
	}
}
