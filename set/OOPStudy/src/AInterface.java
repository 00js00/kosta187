public interface AInterface { // 여러개 있을 경우 public 붙어있는 애 하나만 할 수 있음 // class도 마찬가지
	public void a();

}

interface BInterface { // Interface file에 또 만들 수 있음 (권장X)
	public void b();
}

interface CInterface extends AInterface, BInterface { // Interface 상속 가능 + 다중상속 가능
	public void c();
}

