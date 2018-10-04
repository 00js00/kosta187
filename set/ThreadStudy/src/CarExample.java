
public class CarExample {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("메인스레드에 의해 프로그램 시작됨..");
		
		Car car = new Car("방그리");
		Car car2 = new Car("김지원");
		Car car3 = new Car("이지원");
	
		car.start(); // :독립적으로 되는 시작 명령
		car2.start(); 
		car3.start(); 

		//		car.run();
		car.join();
		car2.join();
		car3.join();

		System.out.println("메인스레드에 의해 프로그램 종료됨,....");
	}
}
