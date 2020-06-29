package StrategyPattern;

public class GameMain {

	public static void main(String[] args) {
		
		GameCharacter character = new GameCharacter();
		
		character.attack();
		
		character.setWeapon(new Knife());
		character.attack();
		
		character.setWeapon(new Sword());
		character.attack();
		
		// 유지보수 추가 
		character.setWeapon(new Ax());
		character.attack();
			// -> 유지보수에서 무언갈 추가한다고해서 게임캐릭터나 웨폰을 건드리지 않고 수정할 수 있다. 
	}
}
