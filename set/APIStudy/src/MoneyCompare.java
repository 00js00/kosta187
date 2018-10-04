import java.util.Collections;
import java.util.Comparator;

public class MoneyCompare implements Comparator<Account> {
//기준을 제공
// 비교하고자하는 값 2개 .. Account o1, o2 에서받아와서 비교한 후 큰 수는 양수,

	@Override
	public int compare(Account o1, Account o2) {
//		스트링, 스트링 간 큰 것 찾는 것 .compareTo()
		return (int)(o1.getrestMoney()-o2.getRestMoney()); // 양수 : 오름차순
		

	}

}
