/**
 * 다중구현을 이용한 클래스 정의
 * 
 * @author 서지원
 *
 */
public class SamsongTV implements Browsable, RemoteControl {

	private int currentChannel;
	private int currentVolumn; // 속성이 있으면 자동으로 생성자있음

	public SamsongTV() {
//		super(); currentChannel이랑 currentVolumn 둘다 int 라 default 0이라서 super 없어도됌
		// TODO Auto-generated constructor stub
	}

	public SamsongTV(int currentChannel, int currentVolumn) {
//		super();
		this.currentChannel = currentChannel;
		this.currentVolumn = currentVolumn;
	}

	public int getCurrentChannel() {
		return currentChannel;
	}

	public void setCurrentChannel(int currentChannel) {
		this.currentChannel = currentChannel;
	}

	public int getCurrentVolumn() {
		return currentVolumn;
	}

	public void setCurrentVolumn(int currentVolumn) {
		this.currentVolumn = currentVolumn;
	}

	@Override
	public void turnOn() {
		System.out.println("전원을 킵니다...");
	}

	@Override
	public void turnOff() {
		System.out.println("전원을 끕니다...");

	}

	@Override
	public void volumnUp() {
		if (!(currentVolumn >= MAX_VOLUMN)) {
			currentVolumn++;
		}

	}

	@Override
	public void volumnDouwn() {
		currentVolumn--;
	}

	@Override
	public void setVolumn(int volumn) {
		currentVolumn = volumn;
	}

	@Override
	public void setChannel(int channel) {
		currentChannel = channel;
	}

	@Override
	public void surfing(String url) {
		System.out.println(url + "을 화면에 렌더링합니다...");

	}

	public static void main(String[] args) {
		RemoteControl tv = new SamsongTV();
		tv.turnOn();
		tv.setChannel(15);
		System.out.println(((SamsongTV)tv).getCurrentChannel()); //새로만든 변수는 바로 접근할 수 없음
		tv.volumnUp();
		tv.volumnUp();
		tv.volumnUp();
		tv.volumnUp();
		tv.volumnUp();
		tv.volumnUp();
		tv.volumnUp();
		tv.volumnUp();
		tv.volumnUp();
		tv.volumnUp();
		tv.volumnUp();
		tv.volumnUp();
		System.out.println(RemoteControl.MAX_CHANNEL);
		tv.turnOff();
		System.out.println(((SamsongTV)tv).getCurrentVolumn());
	}
}
