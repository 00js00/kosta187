import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class MapExample2 {
	public static void main(String[] args) {
		Hashtable<String, Account> set = new Hashtable<>();
		
		Account account1 = new Account("1111", "김기정", 1111, 1000);
		Account account2 = new Account("2222", "박기정", 1111, 1000);
		
		set.put(account1.getAccountNum(), account1);
		set.put(account2.getAccountNum(), account2);
		
		System.out.println(set.get("1111"));
	
		Enumeration<String> e= set.keys();	// 동기화처리된 .. 
		while (e.hasMoreElements()) {
			String key =  e.nextElement();
			System.out.println(key);
		}
		
		Enumeration<Account> e2 = set.elements();
		
	}

}
