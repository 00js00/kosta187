public class Gun /* 상속받고싶으면 extends, 규격에 따라 만들려면 implements */ implements Weapon {
	@Override
	public void attack() {
		System.out.println("총으로 공격합니다..");
	}
}
