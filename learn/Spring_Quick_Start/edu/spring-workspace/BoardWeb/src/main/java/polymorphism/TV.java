package polymorphism;


// OOP 언어는 다형성을 지원하므로 interface 객체 선언.
// interface 로서, 공통으로 가져야 할 기능을 추상 메소드로 추상적으로 정의.
public interface TV {
	public void powerOn();
	public void powerOff();
	public void volumeUp();
	public void volumeDown();
}
