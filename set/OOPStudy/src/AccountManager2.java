import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * 배열을 이용한 은행계좌 관리
 * 
 * @author 서지원
 *
 */
public class AccountManager2 {

	private Vector accounts;

	public AccountManager2() {
//		accounts = new Account[100];
		this(50);
	}

	public AccountManager2(int num) {
		accounts = new Vector(num, 5);
	}

	public Vector getAccounts() {
		return accounts;
	}

	public void setAccounts(Vector accounts) {
		this.accounts = accounts;
	}

	/**
	 * @param account
	 */
	public void add(Account account) {
		accounts.addElement(account);
	}

	/**
	 * @return
	 */
	public List list() {
		List temp = new Vector(accounts.size());
		for (int i = 0; i < accounts.size(); i++) {
			
			temp.add(i, accounts.elementAt(i));
//			System.out.println(i);
		}
		return temp; // 배열 반환하지말고 실제 들어와있는 애만 반환
	}

	/*
	 * List list - new ArrayList(accounts.size()); Enumeration e =
	 * accounts.elements(); while(e.hasMoreElements()){
	 * 
	 * }
	 */

	/**
	 * @param accountNum
	 * @return
	 */
	public Account get(String accountNum) { // 검색 조회기능
		Enumeration e = accounts.elements();
		while (e.hasMoreElements()) {
			Object object = e.nextElement();
			if (((Account) object).getAccountNum().equals(accountNum)) {
				return (Account) object;
			}
		}
		System.out.println("검색된 계좌가 존재하지 않습니다.");
		return null;
	}

	/*
	 * while(e.hasMoreElements()){ Account account = (Account)e.nextElement();
	 * boolean eq = account.getAccountNum().equals(accountNum); if(eq){ return
	 * account; }
	 * 
	 */
	/**
	 * @param accountOwner
	 * @return
	 */
	public List search(String accountOwner) { // 있는거 다 반환
		List temp = new ArrayList();
		Enumeration e = accounts.elements();
		while (e.hasMoreElements()) {
			Object object = e.nextElement();
			if (((Account) object).getAccountOwner().equals(accountOwner)) {
				temp.add(object);
			}
		}
		return temp;
	}

	/**
	 * @param accountNum
	 * @return
	 */
	public boolean remove(String accountNum) { // 삭제하고 잘되었으면 true 삭제하고자 하는게 없으면 false
		Enumeration e = accounts.elements();
		while (e.hasMoreElements()) {
			Object object = e.nextElement();
			if (((Account) object).getAccountNum().equals(accountNum)) {
				return accounts.removeElement(object);
			}
		}
		return false;
	}

}
