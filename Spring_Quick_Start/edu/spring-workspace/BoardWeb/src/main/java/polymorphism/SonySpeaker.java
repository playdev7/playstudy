// SonySpeaker.java
// ������ �׽�Ʈ ���� �θ� ��ü ����.

package polymorphism;

//������Ʈ ��ĵ ���� import
import org.springframework.stereotype.Component;

	// @Component("sony")	������̼� ������ �����ݷ��� ����.
public class SonySpeaker implements Speaker {
	public SonySpeaker() {
		System.out.println("===> SonySpeaker ��ü ����");
	}
	public void volumeUp() {
		System.out.println("SonySpeaker---�Ҹ� �ø���.");
	}
	public void volumeDown() {
		System.out.println("SonySpeaker---�Ҹ� ������.");
	}
}
