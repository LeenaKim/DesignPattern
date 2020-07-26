# Strategy Pattern (전략바꾸기)

https://gmlwjd9405.github.io/2018/07/06/strategy-pattern.html

- 인터페이스

  > 키보드나 디스플레이 따위처럼 사람과 컴퓨터를 연결하는 장치.

  - 기능에 대한 선언과 구현 분리
  - 기능을 구현하는 통로로 사용

- 델리게이트

  > 위임하다, 떠넘기다 
  >
  > 인터페이스는 기능의 선언과 기능의 구현을 분리할 수 있는 기능을 제공한다. 
  >
  > 특정 객체의 기능을 사용하기위해 다른 객체의 기능을 호출하는것을 '델리게이트한다'라고 표현한다. 

- 스트레티지 패턴 (전략패턴)

  > 여러 알고리즘을 하나의 추상적인 접근점을 만들어 접근점(인터페이스)에서 서로 교환 가능하도록 하는 패턴. 묵시적으로 누가 들어오던 상관 없이 외부에서 보급품으로 날아오는 객체. 객체들이 할 수 있는 행위 각각에 대해 전략 클래스를 생성하고, 유사한 행위들을 캡슐화하는 인터페이스를 정의하여, 객체의 행위를 동적으로 바꾸고 싶은 경우 **직접 행위를 수정하지 않고 전략을 바꿔주기만함**으로써 행위를 유연하게 확장하는 방법. 즉, 객체가 할 수 있는 행위들 각각을 전략으로 만들어놓고, 동적으로 행위의 수정이 필요한 경우 전략을 바꾸는것만으로 행위의 수정이 가능하도록 만든 패턴. 
  >
  > - 행위를 클래스로 캡슐화해 동적으로 행위를 자유롭게 바꿀 수 있게 해주는 패턴.
  > - 전략을 쉽게 바꿀 수 있도록 해주는 디자인 패턴. 
  > - 전략이란 
  >   - 어떤 목적을 달성하기 위해 일을 수행하는 방식, 비즈니스 규칙, 문제를 해결하는 알고리즘 등

- 집약(aggregation) 관계와 합성(composition)관계

  > - 집약 관계 : 한 객체가 다른 객체를 포함하는 것을 나타내는 것. 부분을 나타내는 객체를 다른 객체와 공유할 수 있다. 전체 객체가 사라져도 부분 객체들은 남아있다. 참조값을 인자로 받아 필드를 세팅하는 경우. 전체 객체의 라이프타임과 부분 객체의 라이프타임은 독립적이다. 
  >
  >   ```java
  >   public class Computer{
  >     private MainBoard mb;
  >     private CPU c;
  >     private Memory m;
  >     
  >     public Computer(MainBoard mb, CPU c, Memory m){
  >       this.mb = mb;
  >       this.c = c;
  >       this.m = m;
  >     }
  >   }
  >   ```
  >
  >   
  >
  > - 합성 관계 : 부분 객체가 전체 객체에 속할때 나타내는 것. 전체 객체가 사라지면 부분 객체도 사라진다.
  >
  >   ```java
  >   public class Computer {
  >     private MainBoard mb;
  >     private CPU c;
  >     private Memory m;
  >     
  >     public Computer() {
  >       this.mb = new MainBoard();
  >       this.c = new CPU();
  >       this.m = new Memory();
  >     }
  >   }
  >   ```

- SOLID 원칙중 OCP(Open-CLosed Principle)

  > 기존의 move()를 수정하지 않으면서 행위가 수정되어야한다.



![스크린샷 2020-06-01 오후 6.40.54](StrategyPattern.assets/스크린샷 2020-06-01 오후 6.40.54.png)

+ 역할이 수행하는 작업
  + *Strategy*
    **인터페이스나 추상 클래스**로 외부에서 동일한 방식으로 알고리즘을 호출하는 방법을 명시
  + *ConcreteStrategy*
    스트래티지 패턴에서 명시한 알고리즘을 실제로 구현한 클래스 (Strategy A B C)
  + *Context*
    스트래티지 패턴을 이용하는 역할을 수행한다. (Client)
    필요에 따라 동적으로 구체적인 전략을 바꿀 수 있도록 setter 메서드(‘집약 관계’)를 제공한다



# 실습



+ 요구사항
  + 신작 게임에서 캐릭터와 무기를 구현해보세요.
  + 무기는 두가지 종류가 있습니다. 칼과 검.
+ 유지보수사항
  + 무기중에 도끼를 추가해주세요. 



## Context (Client) 

```java
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

```

## Strategy (SuperClass - Weapon)

```java
package StrategyPattern;

public interface Weapon {

	//무기에 접근할 수 있는 접근점
	public void attack();
}

```

## Concrete Strategy (Subclass - Knife)

```java
package StrategyPattern;

public class Knife implements Weapon {

	@Override
	public void attack() {
		System.out.println("칼 공격 ");
	}

}

```

## Concrete Strategy (Subclass - Sword)

```java
package StrategyPattern;

public class Sword implements Weapon {

	@Override
	public void attack() {
		System.out.println("검 공격 ");
	}

}

```

## Concrete Strategy (Subclass - Ax)

```java
package StrategyPattern;

public class Ax implements Weapon {

	@Override
	public void attack() {
		System.out.println("도끼 공격 ");
	}

}

```

## Main

```java
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

```

