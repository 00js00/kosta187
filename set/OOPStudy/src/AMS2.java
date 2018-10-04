import java.util.List;

/**
 * 은행 계좌 관리 애플리케이션
 * 
 * @author 서지원
 *
 */
public class AMS2 {

	public static void main(String[] args) {
//		AccountManager manager = new AccountManager();
		AccountManager2 manager = new AccountManager2();

		Account account = new Account("1111-2222-3333", "김기정", 1111, 100000);
		manager.add(account);
		manager.add(new Account("2222-2222-3333", "박지성", 1111, 200000));
		manager.add(new Account("3333-2222-3333", "손흥민", 1111, 200000));
		manager.add(new Account("4444-2222-3333", "손흥민", 1111, 200000));
//		System.out.println("");
//		// Up Casting
//		manager.add(new MinusAccount("9999-1111-2222", "김대출", 1111, 1000, 10000000));
//		manager.add(new MinusAccount("9999-2222-2222", "홍길동", 1111, 1000, 10000000));
//
//		manager.add(new Account("5555-2222-3333", "손흥민", 1111, 200000));
//
//		System.out.println(manager.get("2222-2222-3333"));
//		
//		for (Object account3 : manager.search("손흥민")) {
//			System.out.println(account3.toString());
//		}
//		List list = manager.list();
//		for (Object account2 : list) {
//			if (account2 instanceof MinusAccount) {
//				System.out.println("마이너스 계좌 : "+ account2.toString());
//			} else {
//				System.out.println("입출금 계좌 : "+ account2.toString());
//			}
//		}
//		System.out.println("");
//		System.out.println(manager.remove("1111-2222-3333"));
		List list = manager.list();
		for (Object account2 : list) {
			System.out.println(account2.toString());
		}

	}

}
