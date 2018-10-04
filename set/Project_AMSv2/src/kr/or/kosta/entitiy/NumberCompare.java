package kr.or.kosta.entitiy;

import java.util.Comparator;

/**
 * 계좌번호 순 배열해주는 class
 * 
 * @author 서지원
 *
 */
public class NumberCompare implements Comparator<Account> {
	@Override
	public int compare(Account o1, Account o2) {
		return o1.getAccountNum().compareTo(o2.getAccountNum());
	}
}
