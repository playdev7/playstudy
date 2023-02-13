// TVUser.java.
// 말 그대로 Client Side 개발 중이라고 가정한다.

package polymorphism;

// 스프링 프레임워크 활용 위한 라이브러리 import
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

// Run Configuration Tip - Arguments 지정 하고 Run 하면 Default 인자로 적용된다.
// 각각 다른 인자를 통해 실행시키려면 이름 부여해서 Apply 하자. 

// Aoi_shiori 가 디자인 패턴 + 문자열 슬라이스 + API 활용의 절대적 예시.

public class TVUser {
	public static void main(String[] args) {
		// 1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext factory =
				new GenericXmlApplicationContext("applicationContext-poly.xml");
				// factory 인스턴스 생성 시 new GenericXmlApplicationContext("설정 파일 이름.xml") 로 지정.
		
		// 2. Spring 컨테이너로부터 필요한 객체를 요청(Lookup) 한다.
		TV tv = (TV)factory.getBean("tv");
			// 추가 인스턴스 리퀘스트.
			TV tv2 = (TV)factory.getBean("tv");
			TV tv3 = (TV)factory.getBean("tv");
			
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		// 3. Spring 컨테이너를 종료한다.
		factory.close();
	}
	
	/* BeanFactory 디자인 패턴을 활용한 예제
	// BeanFactory 객체 활용.
	BeanFactory factory = new BeanFactory();
	TV tv = (TV)factory.getBean(args[0]);
	// 실행 시 Arguments 를 줘야지 적합한 인스턴스가 생성된다. - Run Config.
	tv.powerOn();
	tv.volumeUp();
	tv.volumeDown();
	tv.powerOff();
	
	 */
	
	/*	TV 인터페이스를 활용한 예제 - TV.java
	 * 	TV tv = new SamsungTV();
			// 언제든 LgTV()의 인스턴스로서 묵시적 형변환 가능.
	 * */
		
	/*	다형성을 활용하지 않은 Poor 코드의 예제.
	 * 
	 * 같은 기능을 하는 두 개의 객체이지만, 메소드 이름이 다름.
	 * 메소드 시그니처가 다르므로 코드 수정이 번거로워짐.
	 * 
	 * SamsungTV tv = new SamsungTV();
			tv.powerOn();
			tv.volumeUp();
			tv.volumeDown();
			tv.powerOff();
		}
		
		
		LgTV tv = new LgTV();
		tv.turnOn();
		tv.soundUp();
		tv.soundOff();
		tv.turnOff();
	 * 
	 * 
	 * */	
}
