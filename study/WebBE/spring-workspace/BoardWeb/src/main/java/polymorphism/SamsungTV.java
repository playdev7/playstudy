package polymorphism;

public class SamsungTV implements TV {
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("===> SamsungTV 객체 생성");
	}
	
	// setter 인젝션 사용을 위한 메소드 생성.
	// Spring 이 <bean> 객체 생성 시점에 자동으로 호출해줌.
	// 메소드 이름은 set으로 시작하고 변수명의 첫글자를 대문자로 지정한다.
		// 파라미터가 speaker 이면 => setSpeaker()
	// 이후 Spring 설정의 name 값을 뒤의 단어만 소문자로 작성한다.
		// <property name="speaker">
		public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker() 호출");
		this.speaker = speaker;
	}
	
	public void setPrice(int price) {
		System.out.println("===> setPrice() 호출");
		this.price = price;
	}
	
	/* 생성자 인젝션 관련 구문
		// Generate Constructor using Fields 를 선택한 다음
		// 초기화 할 멤버변수, 삽입 포인트 선택 후 Generate 하면 생성자가 추가됨.
		// Hot Key: ALT SHIFT T
		public SamsungTV(Speaker speaker) {
			System.out.println("===> SamsungTV(2) 객체 생성");
			this.speaker = speaker;
		}
		
		public SamsungTV(Speaker speaker, int price) {
			System.out.println("===> SamsungTV(3) 객체 생성");
			this.speaker = speaker;
			this.price = price;
		}
	*/
	
	// Spring 설정에 따라 TV(n) 객체 오버로딩 될 것임.
	// 현재기준 - SamsungTV(3) 에서 불러와진 메소드.
	public void powerOn() {
		System.out.println("SamsungTV---전원 켠다. (가격: " + price + " )");
	}
	public void powerOff() {
		System.out.println("SamsungTV---전원 끈다.");
	}
	public void volumeUp() {
		
		speaker.volumeUp();
	}
	public void volumeDown() {
		
		speaker.volumeDown();
	}
	
	// 멤버변수 초기화 위한 initMethod 메소드 선언.
		public void initMethod() {
			System.out.println("객체 초기화 작업 처리..");
			System.out.println("	init-method 는 객체 생성 직후에 호출된다.\n");
		}
		
		public void destroyMethod() {
			System.out.println("객체 삭제 전에 처리할 로직 처리...");
			System.out.println();
			System.out.println("스프링은 컨테이너 종료 전에 자신이 관리하는 모든 객체를 삭제시킨다.");
			System.out.println("이 문장은 모든 객체 삭제 전에 마지막으로 실행되는 메소드의 요소이다.");
		}
}
