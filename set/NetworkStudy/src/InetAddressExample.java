import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * DNS와의 통신을 통해 IP <-> Domain 정보 제공
 * @author 서지원
 *
 */
public class InetAddressExample {

	public static void main(String[] args) throws UnknownHostException {

		InetAddress ia = InetAddress.getLocalHost();	// 실제 호스트가 없을 수도 있으니까
		System.out.println(ia.getHostAddress()); //동적.. 
		
//		String domainName = "www.daum.net";
		String domainName = "www.naver.net";
		
		InetAddress ia2 = InetAddress.getByName(domainName); // 실제 id 지정
		System.out.println(ia2.getHostAddress());
		InetAddress[] ias = InetAddress.getAllByName(domainName);
		for (InetAddress ineAddress : ias) {
			System.out.println(ineAddress);
		}
	}

}
