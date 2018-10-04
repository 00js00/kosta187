/**
 * 배열을 이용한 은행계좌 관리
 * 
 * @author 서지원
 *
 */
public class AccountManager {
	private Account[] accounts;
	private int count = 0;

	public AccountManager() {
		accounts = new Account[100];
//		this(50);
	}

	public AccountManager(int num) {
		accounts = new Account[num];
	}

	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @param account
	 */
	public void add(Account account) {
		accounts[count] = account;
		count++;
	}

	/**
	 * @return
	 */
	public Account[] list() {
		Account temp[] = new Account[count];
		for (int i = 0; i < count; i++) {
			temp[i] = accounts[i];
		}
		return temp; // 배열 반환하지말고 실제 들어와있는 애만 반환
	}

	/**
	 * @param accountNum
	 * @return
	 */
	public Account get(String accountNum) { // 검색 조회기능
		for (int i = 0; i < count; i++) {
			if (accounts[i].getAccountNum().equals(accountNum)) {
				return accounts[i];
			}

		}
		System.out.println("검색된 계좌가 존재하지 않습니다.");
		return null;
	}

	/**
	 * @param accountOwner
	 * @return
	 */
	public Account[] search(String accountOwner) { // 있는거 다 반환
		int[] index = new int[count];
		for (int i = 0; i < index.length; i++) {
			if (accounts[i].getAccountOwner().equals(accountOwner)) {
				index[i] = (i + 1);
			}
		}
		int temp = 0;
		for (int j = 0; j < index.length; j++) {
			System.out.println(index[j]);
			if (index[j] > 0) {

				temp++;
			}
		}
		System.out.println(temp);
		Account[] temp2 = new Account[temp];
		int index2 = 0;
		for (int k = 0; k < index.length; k++) {
			if (index[k] > 0) {
				temp2[index2] = accounts[k];
				index2++;
			}

		}

		return temp2;
	}

	/**
	 * @param accountNum
	 * @return
	 */
	public boolean remove(String accountNum) { // 삭제하고 잘되었으면 true 삭제하고자 하는게 없으면 false
		for (int i = 0; i < count; i++) {
			if (accounts[i].getAccountNum().equals(accountNum)) {
				for (int j = i; j < accounts.length - 1; j++) {
					accounts[j] = accounts[j + 1];
				}
				count--;
				return true;
			}
		}
		return false;
	}

}
