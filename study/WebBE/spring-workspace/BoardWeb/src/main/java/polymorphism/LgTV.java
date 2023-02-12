package polymorphism;

public class LgTV implements TV{
	// 인터페이스 연결 시 implements 키워드 사용.
	// TV 인터페이스의 추상메소드에 맞춰 전부 오버라이딩 진행.
	public void powerOn() {
		System.out.println("LgTV---전원 켠다.");
	}
	public void powerOff() {
		System.out.println("LgTV---전원 끈다.");
	}
	public void volumeUp() {
		System.out.println("LgTV---소리 올린다.");
	}
	public void volumeDown() {
		System.out.println("LgTV--소리 내린다.");
	}
	
	
	/* 아래 코드는 SamsungTV 클래스와 메소드 시그니처가 달라서 수정이 번거로움.
	 * 동일 기능을 가졌지만, 메소드 시그니처가 달랐음.
	 * 다형성(polymorphism)을 활용하기 위해 인터페이스 와 결합.
	 * TV 인터페이스에서 메소드 시그니처가 강제되었으므로 메소드 재정의(override) 필요.
	public void turnOn() {
		System.out.println("LgTV---전원 켠다.");
	}
	public void turnOff() {
		System.out.println("LgTV---전원 끈다.");
	}
	public void soundUp() {
		System.out.println("LgTV---소리 올린다.");
	}
	public void soundOff() {
		System.out.println("LgTV--소리 내린다.");
	}
	*/
}
