package polymorphism;

public class SamsungTV implements TV {
	public SamsungTV() {
		System.out.println("===> SamsungTV 객체 생성");
	}
	
	// 멤버변수 초기화 위한 initMethod 메소드 선언.
	public void initMethod() {
		System.out.println("객체 초기화 작업 처리");
		System.out.println("init-method 는 객체 생성 직후에 호출된다.");
	}
	
	public void destroyMethod() {
		System.out.println("객체 삭제 전에 처리할 로직 처리...");
		System.out.println("스프링은 컨테이너 종료 전에 자신이 관리하는 모든 객체를 삭제시킨다.");
		System.out.println("이 문장은 모든 객체 삭제 전에 마지막으로 실행되는 메소드의 요소이다.");
	}
	
	
	public void powerOn() {
		System.out.println("SamsungTV---전원 켠다.");
	}
	public void powerOff() {
		System.out.println("SamsungTV---전원 끈다.");
	}
	public void volumeUp() {
		System.out.println("SamsungTV--소리 올린다.");
	}
	public void volumeDown() {
		System.out.println("SamsungTV--소리 내린다.");
	}

}
