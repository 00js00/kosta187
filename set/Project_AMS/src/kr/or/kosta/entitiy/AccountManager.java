package kr.or.kosta.entitiy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * Hashtable을 이용한 은행계좌 관리
 * 
 * @author 서지원
 *
 */
public class AccountManager {
	// hashtable을 썼기 때문에 count 안해도 됨
	private Hashtable<String, Account> accounts;

	// 생성자
	public AccountManager() {
		this(50);
	}

	public AccountManager(int capacity) {
		accounts = new Hashtable<String, Account>(capacity);
	}

	public Hashtable<String, Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Hashtable<String, Account> accounts) {
		this.accounts = accounts;
	}

	/**
	 * 입출금계좌 생성
	 * 
	 * @param account 신규계좌 생성시 최소 입금금액 10000원
	 */
	public void add(Account account) throws AccountException {
		if (account.getAccountNum().length() < 1) {
			throw new AccountException("계좌번호를 입력해주세요.", -2);
		} else if (account.getAccountOwner().length() < 1) {
			throw new AccountException("예금주명을 입력해주세요.", -3);
		} else if (!(account.getPasswd() > 0)) {
			throw new AccountException("비밀번호를 입력해주세요.", -4);
		} else if (!(account.getRestMoney() >= 10000)) {
			throw new AccountException("최소 입금금액은 10,000원 입니다.", -5);
		} else if (accounts.containsKey(account.getAccountNum())) {
			throw new AccountException("이미 등록된 계좌입니다.", -6);
		}
		accounts.put(account.getAccountNum(), account);
	}

	/**
	 * 마이너스계좌 생성
	 * 
	 * @param account 신규계좌 생성시 대출금액과 입금금액 0원 이상이어야함
	 */
	public void add(MinusAccount account) throws AccountException {
		if (account.getAccountNum().length() < 1) {
			throw new AccountException("계좌번호를 입력해주세요.", -2);
		} else if (account.getAccountOwner().length() < 1) {
			throw new AccountException("예금주명을 입력해주세요.", -3);
		} else if (!(account.getPasswd() > 0)) {
			throw new AccountException("비밀번호를 입력해주세요.", -4);
		} else if (!(account.superRestMoney() > 0)) {
			throw new AccountException("입금할 금액을 입력해주세요.", -7);
		} else if (!(account.getBorrowMoney() > 0)) {
			throw new AccountException("대출할 금액을 입력해주세요.", -8);
		} else if (accounts.containsKey(account.getAccountNum())) {
			throw new AccountException("이미 등록된 계좌입니다.", -6);
		}
		accounts.put(account.getAccountNum(), account);
	}

	/**
	 * @return 전체 조회 : 모든 계좌 조회
	 */
	public List<Account> list() {
		List<Account> temp = new ArrayList<Account>();
		temp.addAll(accounts.values());
		Collections.sort(temp, new NumberCompare());
		return temp;
	}

	/**
	 * 조회 : 계좌번호 입력시 계좌 조회
	 * 
	 * @param accountNum : 조회하고자 하는 계좌번호
	 * @return
	 */
	public Account get(String accountNum) throws AccountException {
		if (accountNum.length() < 1) {
			throw new AccountException("계좌번호를 입력해주세요.", -2);
		} else if (!(accounts.containsKey(accountNum)) && accountNum.length() > 0) {
			throw new AccountException("해당 계좌가 존재하지 않습니다.", -9);
		}
		Enumeration<String> e = accounts.keys();
		while (e.hasMoreElements()) {
			String string = (String) e.nextElement();
			if (string.equals(accountNum)) {
				return accounts.get(string);
			}
		}
		return null;
	}

	/**
	 * 검색 : 예금주명 입력시 계좌 검색
	 * 
	 * @param accountOwner : 검색하고자 하는 예금주명
	 * @return
	 */
	public List<Account> search(String accountOwner) throws AccountException {
		if (!(accountOwner.length() > 0)) {
			throw new AccountException("예금주명을 입력해주세요", -3);
		}
		List<Account> temp = new ArrayList<Account>();
		Enumeration<Account> e = accounts.elements();
		while (e.hasMoreElements()) {
			Account object = (Account) e.nextElement();
			if (object.getAccountOwner().equals(accountOwner)) {
				temp.add(object);
			}
		}
		if (temp.size() == 0) {
			throw new AccountException("해당 계좌가 존재하지 않습니다", -9);
		}
		return temp;
	}

	/**
	 * 삭제 : 계좌번호 입력시 해당 계좌 삭제
	 * 
	 * @param accountNum : 삭제하고자 하는 계좌번호
	 * @return
	 */
	public boolean remove(String accountNum) throws AccountException {
		if (accountNum.length() < 1) {
			throw new AccountException("계좌번호를 입력해주세요", -2);
		} else if (!accounts.containsKey(accountNum)) {
			throw new AccountException("해당 계좌가 존재하지 않습니다", -9);
		}
		Enumeration<Account> e = accounts.elements();
		while (e.hasMoreElements()) {
			Account object = (Account) e.nextElement();
			if (object.getAccountNum().equals(accountNum)) {
				accounts.remove(object.getAccountNum());
				return true;
			}
		}
		return false;
	}

}
