
public class Mission {

	public static void main(String[] args) {
		Account account1 = new Account("1111-2222-3333","김기정",1111,100000);
		Account account2 = new Account("1111-2222-3333","김기정",1111,100000);
		System.out.println(account1==account2);
		System.out.println(account1.equals(account2));
		
		String str1 = "Java";
		String str2 = "Java";
		System.out.println(str1.equals(str2));
		
		
	}

}
