
public class Unit {

	private Weapon weapon;// weapon 과 unit이 연결되어 있으니까 꼭 적어주기

	private String name;

//setter.getter 설정해야함
	public Unit() {

	}

	public Unit(String name) {
		this.name = name;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void attack() {
		weapon.attack();

	}

	public static void main(String[] args) {
//		해보기
//		Weapon weapon = null;
//		weapon = new Gun();
//		weapon.attack();
//		
//		weapon = new Sword();
//		weapon.attack(); 
		
		
		
		Unit unit = new Unit("SCV");

		Weapon weapon = null;
		weapon = new Gun();

		unit.setWeapon(weapon);
		unit.attack();
		
		weapon = new Sword();
		unit.setWeapon(weapon);
		unit.attack();
	}
}
