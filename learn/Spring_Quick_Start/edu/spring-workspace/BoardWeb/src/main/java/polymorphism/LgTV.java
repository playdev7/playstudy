package polymorphism;

// 의존성 주입 위한 어노테이션 import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
// 컴포넌트 스캔 관련 import
import org.springframework.stereotype.Component;

@Component("tv") //컴포넌트 스캐너가 아래 클래스에 명시된 객체 생성하도록 키워드 선언.
/* @Component의 인자는 컨테이너에서 bean id 속성으로 반작용한다.
 * 현재 명시 - 클라이언트에서 호출할 수 있도록 id를 "tv" 로 부여.
	속성을 부여하지 않았을 경우 컨테이너가 자동으로 이름을 설정해줌.
	LgTV 클래스라면 id="lgTV" 로 - 클래스명의 첫글자를 소문자로.
 */

public class LgTV implements TV{
	/* 인터페이스 연결 시 implements 키워드 사용.
		TV 인터페이스의 추상메소드에 맞춰 전부 오버라이딩 진행.
	*/
	
	@Autowired // @Autowired 의존성 주입 - 멤버변수 자료형과 일치하는 객체를 찾아서 자동으로 할당.
		// @Qualifier("apple")  @Qualifier - 의존성이 주입될 객체의 이름 지정 => id 또는 name.
	private Speaker speaker; // speaker 멤버변수 선언
	
	// LgTV 객체 기본 생성자 선언.
	public LgTV() {
		System.out.println("===> LgTV 객체 생성");
	};
	
	public void powerOn() {
		System.out.println("LgTV---전원 켠다.");
	}
	public void powerOff() {
		System.out.println("LgTV---전원 끈다.");
	}
	public void volumeUp() {
		speaker.volumeUp();
		System.out.println("LgTV---소리 올린다.");
	}
	public void volumeDown() {
		speaker.volumeDown();
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
