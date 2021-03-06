# [ SOLID 원칙 ]

[toc]







# 3.1 단일 책임 원칙

- SRP(Single Responsibility Principle) : 단 하나의 책임만을 가져야 하는 원칙. 



## 3.1.1 책임의 의미

- 객체지향 설계에서의 책임의 기본 단위는 객체를 지칭. 즉, 객체는 단 하나의 책임만 가져야 한다는 것. 

- 책임 = 해야 하는 것, 할 수 있는 것, 해야 하는 것을 잘 할 수 있는 것

- ex) Student 클래스가 수강 과목 추가, 조회, DB에 객체 정보 저장, 객체 정보 읽기, 성적표와 출석부 출력 등의 일을 모두 수행하게되면 한 클래스 내에서 너무 많은 책임을 수행해야 함. Student 클래스의 책임중 가장 잘 할 수 있는건 수강 과목을 추가하고 조회하는 일. 

  즉, SRP를 따르는 설계란 Student 클래스에서는 수강 과목을 추가하고 조회하는 책임만 수행하도록 하는 것



## 3.1.2 변경

![image-20200719222639749](./images/image-20200719222639749.png)

- 좋은 설계 : 시스템에 새로운 요구사항이나 변경이 있을 때 가능한 한 영향 받는 부분을 줄이는 것

  고로, 어떤 클래스가 잘 설계되었는지를 판단하려면 언제 변경되어야하는지를 물어보는 것이 좋다.

- Student 클래스는 언제 변경되야하는가? 변경 이유 :

  ```java
  - 데이터 베이스의 스키마가 변경된다면 Student 클래스도 변경되어야 하는가?
  - 학생이 지도 교수를 찾는 기능이 추가되어야 한다면 Student 클래스는 영향을 받는가?
  - 학생 정보를 성적표와 출석부 이외의 형식으로 출력해야 한다면 어떻게 해야 하는가?
  ```

- 책임을 많이 질수록 클래스 내부에서 서로 다른 역할을 수행하는 코드끼리 강하게 결합될 가능성이 높아진다. 



## 3.1.3 책임 분리

![image-20200719222649812](./images/image-20200719222649812.png)

- Student 클래스가 여러 책임을 수행할경우 Student 클래스의 도움을 필요로 하는 코드도 많을 수밖에 없다. 때문에 Student 클래스에 변경사항이 생기면 Student 클래스를 사용하는 코드와 전혀 관계가 없더라도 직접 또는 간접적으로 사용하는 모든 코드를 다시 테스트해야 한다.
- 회귀(regression) 테스트 : 어떤 변화가 있을 때 해당 변화가 기존 시스템의 기능에 영향을 주는지 평가하는 테스트
- 책임 분리 : 한 클래스에 너무 많은 책임을 부여하지 말고 단 하나의 책임만 수행하도록 해 변경 사유가 될 수 있는 것을 하나로 만드는 것.

- 앞서 Student 클래스가 변경되는 이유 세 가지가 학생 고유 정보, 데이터베이스 스키마, 출력 형식 변화 3가지였으므로 학생클래스가 학생 고유의 역할을 하도록 변경하고 학생 DAO 클래스에서 학생 클래스의 인스턴스를 DB에 저장하거나 읽어들이는 역할을 담당하게 하고, 출석부와 성적표에 출력을 담당하는 성적표 클래스와 출석부 클래스로 분리하는 편이 좋다. 이 경우 변화가 생겼을 시 영향 최소화가 가능하다.

  ex) 데이터베이스의 스키마가 변경되면 DAO 클래스나 이를 사용하는 클래스만 영향을 받는다.

![image-20200719223016685](./images/image-20200719223016685.png)



## 3.1.4 산탄총 수술

- 하나의 책임이 여러개의 클래스들로 분산되어 있는 경우에도 단일 책임 원칙에 입각해 설계를 변경해야 하는 경우도 있다. 
- **산탄총 수술** : 하나의 총알에 여러개의 산탄이 들어있어 산탄이 사방으로 퍼지며 날아감. 수의사가 산탄총을 맞은 동물을 치료하는 상황처럼 어떤 변경이 있을 때 하나가 아닌 여러 클래스를 변경해야 한다는 점에 착안해 만들어짐. 
  - 하나의 책임이 여러 클래스로 분산되어있는 경우 클래스 하나 하나를 모두 변경하지 않으면 프로그램이 정상적으로 작동하지 않는다. 특히 로깅, 보안, 트랜잭션과 같은 **횡단 관심**(cross-cutting concern)이 한 책임이 여러 클래스로 분산되있는 예다.
  - ![image-20200719223629328](./images/image-20200719223629328.png)
- 산탄총 수술 해결 방법 : 부가 기능을 별개의 클래스로 분리해 책임을 담당하게 하는 것. 즉, 여러 곳에 흩어진 공통 책임을 한 곳에 모으면서 응집도를 높인다. 



## 3.1.5 관심지향 프로그래밍과 횡단 관심 문제

- 관심지향 프로그래밍 (Aspect-Oriented Programming, AOP) 기법 : 횡단 관심을 수행하는 코드를 애스펙트(aspect)라는 특별한 객체로 모듈화하고 위빙(weaving)이라는 작업을 통해 모듈화한 코드를 핵심 기능에 끼워넣는 것. 횡단 관심에 변경이 생긴다면 해당 애스펙트만 수정하면 됨.



# 3.2 개방-폐쇄 원칙(OCP)

## 개방-폐쇄 원칙이란?

- 개방-폐쇄 원칙 : 기존의 코드를 변경하지 않으면서 기능을 추가할 수 있도록 설계가 되어야 한다
- ![image-20200719225815214](./images/image-20200719225815214.png)
- ex) 도서관 대여 명부라는 새로운 매체에 학생의 대여 기록을 출력하는 기능을 추가하고싶다면? 간단하게는 도서관 대여 명부 클래스를 만들어 SomeClient 클래스가 이 기능을 이용하도록 할 수 있지만, SomeClient 클래스를 변경해야하므로 OCP 법칙을 위반함. 
- ![image-20200719225826514](./images/image-20200719225826514.png)
- => 이렇게 printable이라는 인터페이스를 추가하면 변하는 것은 학생의 대여 기록을 출력하는 도서관 대여 명부일뿐



## 모의 객체



- OCP의 원칙은 모의 객체를 만들때도 적용된다.
  - 모의객체란? : 테스트용 가짜 객체. 네트워크를 통해 웹서비스를 사용하는 기능을 단위테스트해야 할 경우 디비와 웹서버 구축에 시간이 많이 듦으로 실제 외부의 서비스를 흉내내는 가짜 객체를 만들어 테스트 효율성을 높일 필요가 있다.
  - 또한, 테스트 대상 기능이 특정 상태에 의존해서 동작할 수 있다는 점도 고려해야한다. 예를들어 비행기 관제 기능 중 동시에 착륙하려고 하는 비행기 수가 1000대인경우를 테스트한다면? 이때도 실제로 1000대를 강제착륙시킬순 없으므로 모의 객체를 이용하면 특정 상태를 가상으로 만들 수 있다. 



- Check Point p.114

  ```java
  다음 FuelTankMonitoring 클래스는 로켓의 연로 탱크를 검사해 특정 조건에 맞지 않으면 관리자에게 경고 신호를 보내는 기능이 있다. 연로 탱크를 검사하는 방식과 경고를 보내는 방식이 변경될 가능성이 큰 경우에 대비해 다음 코드를 수정하라.
  ```

  ```java
  public class FuelTankMonitoring {
    ...
    public void checkAndWarn() {
      ...
      if (checkFuelTank(...)) {
        giveWarningSignal(...);
      }
    }
    
    private boolean checkFuelTank(...) {...}
    private void giveWarningSignal(...) {...}
  }
  ```

  - 무엇이 변하는지를 먼저 파악한다. checkFuelTank, giveWarningSignal 메서드에서 구체적 행위 방식이 변한다. 따라서 새로운 행위 방식을 기존의 코드에 영향을 주지 않고 추가하려면 이 두 메서드를 개별 클래스에서 정의하도록 해야한다. 이를 위해 두 메서드의 접근 제한자를 변경하고 상속 관계를 이용해 자식 클래스에 새로운 방식의 메서드를 정의한다. 

  ```java
  public class FuelTankMonitoring {
    ...
    public void checkAndWarn() {
      ...
      if (checkFuelTank(...)) {
        giveWarningSignal(...);
      }
    }
    
    protected boolean checkFuelTank(...) {...}
    protected void giveWarningSignal(...) {...}
  }
  
  public class FuelTankMonitoringWith extends FuelTankMonitoring { //X 방식 
  	...
    protected boolean checkFuelTank(...) {...} // X 방식 
    protected void giveWarningSignal(...) {...} // X 방식 
  }
  ```

  

- Check point p.115

  ```java
  다음 코드는 오후 10시가 되면 MP3를 작동시켜 음악을 연주한다. 그러나 이 코드가 제대로 작동하는지 테스트하려면 저역 10시까지 기다려야 한다. OCP를 적용해 이 문제를 해결하는 코드를 작성하라.
  ```

  ```java
  import java.util.Calendar;
  
  public class TimeReminder {
    private MP3 m;
    
    public void reminder() {
      Calendar cal = Calendar.getInstance();
      m = new MP3();
      int hour = cal.get(Calendar.HOUR_OF_DAY);
      
      if (hour >= 22){
        m.playSong();
      }
    }
  }
  ```

  

![image-20200719233158308](./images/image-20200719233158308.png)

​	=> TimeProvider 인터페이스를 상속받는 FakeTimeProvider 클래스를 통해 TimeReminder 클래스를 전혀 수정하지 않고 주변의 환경을 바꿀 수 있다.

```java
import java.util.Calendar;

public interface TimeProvider { // 인터페이스 도입
	public void setHours(int hours);
  public int getTime();
}
// --------------------------------------------------------------------------------//
public class FakeTimeProvider implements TimeProvider { // TimeProvider 테스트 도입
	private Calendar cal;
  
  public FakeTimeProvider() {
    cal = Calendar.getInstance();
  }
  
  public FakeTimeProvider(int hours) {
    cal = Calendar.getInstance();
    setHours(hours);
  }
  
  public void setHours(int hours){
    cal.set(Calendar.HOUR_OF_DAY, hours); //주어진 시간으로 시간 설정 
  }
  
  public int getTime() {
    return cal.get(Calendar.HOUR_OF_DAY); //현재 시간 반환
  }
}

// --------------------------------------------------------------------------------//
public class TimeReminder {
  TimeProvider tProv;
  MP3 m = new MP3();
  public void setTimeProvider(TimeProvider tProv) {
    this.tProv = tProv; // 테스트 스텁이나 실제 시간을 제공하는 인스턴스를 주입
  }
  
  public void reminder() {
    int hours = tProv.getTime();
    if (hours >= 22){
      m.playSong();
    }
  }
}
```



# 3.3 리스코프 치환 원칙

## 리스코프 치환 법칙(LSP)란?

- 리스코프 치환 법칙(LSP) : 일반화 관계에 대한 이야기. 자식 클래스는 최소한 자신의 부모 클래스에서 가능한 행위는 수행할 수 있어야 한다. 

- 일반화 관계 : is a kind of 관계. 부모클래스의 인스턴스 대신 자식 클래스의 인스턴스를 별다른 변경 없이 그대로 사용할 수 있을때 성립. 

  ex) 원숭이(자식클래스) - 포유류(부모클래스) => LSP 만족

  ex) 오리너구리(자식클래스) - 포유류(부모클래스) => LSP 불만족 (오리너구리는 알을 낳아 번식하기 때문)



## 리스코프 치환 법칙을 만족하기 위해선?

- 자식 클래스가 부모 클래스의 인스턴스의 행위를 일관성 있게 실행하려면 어떻게 해야하는가? 

```java
public class Bag {
  private int price;
  
  public void setPrice(int price){
    this.price = price;
  }
  
  public int getPrice(){
    return price;
  }
}
```

```java
// 가격은 설정된 가격 그대로 조회된다. 
// 모든 BAG 객체 b와 모든 정수 값 p에 대해
[b.setPrice(p)].getPrice() == p;
```

=> 이 경우 Bag 클래스의 행위를 손상하지 않고 일관성 있게 실행하는 클래스를 만들려면 **슈퍼 클래스에서 상속받은 메서드들이 서브 클래스에 오버라이드, 즉 재정의되지 않도록** 하면 된다.

```java
public class DiscountedBag extends Bag {
  private double discountedRate = 0;
  
  // 할인율 설정
  public void setDiscounted(double discountedRate){
    this.discountedRate = discountedRate;
  }
  
  // 할인된 가격 계산
  public void applyDiscount(int price){
    super.setPrice(price - (int)(discountedRate * price));
  }
}
```

=> 할인율 설정과 할인 가격 계산 기능이 추가되었지만, 기존의 슈퍼클래스 Bag에 있던 가격 설정 및 조회 기능은 변경 없이 그대로 상속받음. 

=> Bag 클래스의 setPrice, getPrice 메서드가 DiscountedBag 클래스에서 재정의되지않았으므로 이 두 클래스의 상속관계가 LSP를 위반하지 않음.



# 3.4 의존 역전 원칙

## 의존 역전 원칙이란?

- 의존 역전 원칙 (Dependency Inversion Principle, DIP) : 객체 사이에 서로 도움을 주고받을때 생기는 '의존 관계'를 맺을 때 가이드라인. 의존 관계를 맺을 때 변화하기 쉬운 것 또는 자주 변화하는 것보다는 변화하기 어려운 것, 거의 변화가 없는 것에 의존하라는 원칙



## 변하기 쉬운 것과 변하기 어려운 것

- 변하기 어려운 것 : 정책, 전략과 같은 어떤 큰 흐름이나 개념 같은 추상적인 것

  **추상 클래스**와 **인터페이스** 활용

  DIP를 만족하려면 어떤 클래스가 도움을 받을 때 구체적인 클래스보다는 인터페이스아 추상 클래스와 의존 관계를 맺도록 설계해야함.

  DIP를 만족하는 설계는 변화에 유연한 시스템

   

- 변하기 쉬운 것 : 구체적인 방식, 사물 등



## 의존성 주입

- DIP를 만족하면 의존성 주입이라는 기술로 변화를 쉽게 수용할 수 있는 코드 작성 가능.
- 의존성 주입 : 클래스 외부에서 의존되는 것을 대상 객체의 인스턴스 변수에 주입하는 기술

![image-20200726152621526](./images/image-20200726152621526.png)



```java
public class Kid  {
  private Toy toy;
  
  public void setToy(Toy toy){
    this.toy = toy;
  }
  
  public void play() {
    System.out.println(toy.toString());
  }
}
```

Kid 클래스에서 setToy 메소드로 아이가 가지고 노는 장난감을 바꿀 수 있음.

```java
public class Robot extends Toy {
  public String toString() {
    return "Robot";
  }
}
```

```java
public class Main{
  public static void main(String[] arsg){
    Toy t = new Robot();
    Kid k = new Kid();
    k.setToy(t);
    k.play();
  }
}
```



# 3.5 인터페이스 분리 원칙

## 인터페이스 분리 원칙(Interface Segregation Principle, ISP)

- 인터페이스를 클라이언트에 특화되도록 분리시키라는 설계 원칙. 클라이언트 자신이 이용하지 않는 기능에는 영향을 받지 않아야 한다.

![image-20200726152955182](./images/image-20200726152955182.png)

=> 프린터 기능만 이용하는 클라이언트가 팩스 기능의 변경으로 인해 발생하는 문제의 영향을 받지 않도록 해아함. 즉, 인터페이스를 클라이언트에 특화되도록 분리시켜라.(ISP)

- ISP 원칙 적용 결과

  

- ![image-20200726154521016](./images/image-20200726154521016.png)

=> 인터페이스가 일종의 방화벽 역할을 수행해 클라이언트는 자신이 사용하지 않는 메서드에 생긴 변화로 인한 영향을 받지 않게됨. 