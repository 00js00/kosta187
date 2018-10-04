package kr.or.kosta.chat.common;

public interface Protocol {
//	public static final int SC_CONNECT = 1000;
//	public static final int CS_CONNECT = 1000;
	public static final int CONNECT = 1000;
	public static final int CONNECT_RESULT = 1001;
	
	public static final int MULTI_CHAT = 2000;
	public static final int DISCONNECT = 3000;
	public static final int GUEST = 4000;
	public static final String DELEMETER = ",";
	

}
