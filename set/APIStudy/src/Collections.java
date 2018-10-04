import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Collections {

	public static void main(String[] args) {
//		Arrays : 배열에 관한 유틸리티
		List<Account> list = new ArrayList<>();
		list.add(new Account("1111", "홍길동", 1111, 2000));
		list.add(new Account("1114", "이길동", 1111, 2500));
		list.add(new Account("1113", "박길동", 1111, 2001));

//		Collections.sort(list,new NumberCompare());
		java.util.Collections.sort(list, new NumberCompare());
		for (Account account : list) {
			System.out.println(account);
		}

	}

}
