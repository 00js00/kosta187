
public class ThreadExample2 {
	static class MyThread extends Thread{
		public MyThread(String name) {
			super(name);
			
		}
		@Override
			public void run() {
			System.out.println(getName() + " 스레드 시작");
			for(int i = 0 ;i <Integer.MAX_VALUE; i++) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(getName() + " 스레드 종료");
		}
	}
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		System.out.println("프로그램 시작");
		MyThread t1 = new MyThread("방그리");
		MyThread t2 = new MyThread("이지원");
		
		t1.start();
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.start();
		t2.setPriority(Thread.MIN_PRIORITY);
		
		
		
		System.out.println("프로그램 종료");
	}
}
