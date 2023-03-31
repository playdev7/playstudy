// SonySpeaker.java
// 의존성 테스트 위한 부모 객체 생성.

package polymorphism;

//컴포넌트 스캔 위한 import
import org.springframework.stereotype.Component;

	// @Component("sony")	어노테이션 끝에는 세미콜론이 없다.
public class SonySpeaker implements Speaker {
	public SonySpeaker() {
		System.out.println("===> SonySpeaker 객체 생성");
	}
	public void volumeUp() {
		System.out.println("SonySpeaker---소리 올린다.");
	}
	public void volumeDown() {
		System.out.println("SonySpeaker---소리 내린다.");
	}
}
