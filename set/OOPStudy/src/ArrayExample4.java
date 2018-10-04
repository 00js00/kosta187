import java.util.Scanner;

/**
 * 레퍼런스타입 배열 선언, 생성, 초기화 -- 데이터 타입만 바뀐 것 뿐
 * 
 * @author 서지원
 *
 */
public class ArrayExample4 {

	public static void main(String[] args) {
//		Account account = new Account("1111-2222-3333", "김기정", 1111, 100000);
		Account[] accounts = new Account[100];
		int index = 0;

		// 은행계좌개설
		accounts[index] = new Account("1111-2222-3333", "김기정", 1111, 100000);
		index++;

		accounts[index] = new Account("2222-2222-3333", "박지성", 1111, 200000);
		index++;

		accounts[index] = new Account("3333-2222-3333", "송흥민", 1111, 200000);
		index++;

		// 전체 계좌 목록 출력
		for (int i = 0; i < index; i++) {
			System.out.println(accounts[i].toString());
		}
		//계좌번호로 계좌 조회
		String num = null;
		Scanner scanner = new Scanner(System.in); //import 자동으로 안 됐으면 = ctrl shift o
		System.out.print("검색 계좌번호 : ");
		num = scanner.nextLine();

//		Account account = null;
		for (int i = 0; i < index; i++) {
			if (accounts[i].getAccountNum().equals(num)) {
				System.out.println(accounts[i].toString());
				break; //빨리할라구
			}
			if (i == index-1) {
				System.out.println("검색된 계좌가 존재하지 않습니다.");
			}
		}

//		Account acc = account[i];
//		String numm = acc.getAccountNum();
//		boolean eq = numm.equals(num);
//		
		
//
		//for (int i = 0; i < index; i++) {
		//	if (accounts[i].getAccountNum().equals(num)) {
		//		account=accounts[i];
		//		break;
		//	}
		//}
		//if(account != null) {
		//	System.out.println(accounts[i].toString());
		//}else {
		//	System.out.println("검색된 계좌가 존재하지 않습니다.");
		//}
		
		
	}

}
