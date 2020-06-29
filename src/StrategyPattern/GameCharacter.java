package StrategyPattern;

public class GameCharacter {

	// 추상적인 접근점 
	private Weapon weapon;
	
	// 교환 가능
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	
	public void attack() {
		if(weapon == null) {
			System.out.println("맨손 공격 ");
		} else {
			//델리게이트
			weapon.attack();
			// 내가 어떤것을 들고있느냐에 따라 칼인지 검인지 바뀐다. 			
		}
	}
}
