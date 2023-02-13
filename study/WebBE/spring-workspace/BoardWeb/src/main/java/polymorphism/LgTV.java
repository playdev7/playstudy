package polymorphism;

// ������ ���� ���� ������̼� import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
// ������Ʈ ��ĵ ���� import
import org.springframework.stereotype.Component;

@Component("tv") //������Ʈ ��ĳ�ʰ� �Ʒ� Ŭ������ ��õ� ��ü �����ϵ��� Ű���� ����.
/* @Component�� ���ڴ� �����̳ʿ��� bean id �Ӽ����� ���ۿ��Ѵ�.
 * ���� ��� - Ŭ���̾�Ʈ���� ȣ���� �� �ֵ��� id�� "tv" �� �ο�.
	�Ӽ��� �ο����� �ʾ��� ��� �����̳ʰ� �ڵ����� �̸��� ��������.
	LgTV Ŭ������� id="lgTV" �� - Ŭ�������� ù���ڸ� �ҹ��ڷ�.
 */

public class LgTV implements TV{
	/* �������̽� ���� �� implements Ű���� ���.
		TV �������̽��� �߻�޼ҵ忡 ���� ���� �������̵� ����.
	*/
	
	@Autowired // @Autowired ������ ���� - ������� �ڷ����� ��ġ�ϴ� ��ü�� ã�Ƽ� �ڵ����� �Ҵ�.
		// @Qualifier("apple")  @Qualifier - �������� ���Ե� ��ü�� �̸� ���� => id �Ǵ� name.
	private Speaker speaker; // speaker ������� ����
	
	// LgTV ��ü �⺻ ������ ����.
	public LgTV() {
		System.out.println("===> LgTV ��ü ����");
	};
	
	public void powerOn() {
		System.out.println("LgTV---���� �Ҵ�.");
	}
	public void powerOff() {
		System.out.println("LgTV---���� ����.");
	}
	public void volumeUp() {
		speaker.volumeUp();
		System.out.println("LgTV---�Ҹ� �ø���.");
	}
	public void volumeDown() {
		speaker.volumeDown();
		System.out.println("LgTV--�Ҹ� ������.");
	}
	
	
	/* �Ʒ� �ڵ�� SamsungTV Ŭ������ �޼ҵ� �ñ״�ó�� �޶� ������ ���ŷο�.
	 * ���� ����� ��������, �޼ҵ� �ñ״�ó�� �޶���.
	 * ������(polymorphism)�� Ȱ���ϱ� ���� �������̽� �� ����.
	 * TV �������̽����� �޼ҵ� �ñ״�ó�� �����Ǿ����Ƿ� �޼ҵ� ������(override) �ʿ�.
	public void turnOn() {
		System.out.println("LgTV---���� �Ҵ�.");
	}
	public void turnOff() {
		System.out.println("LgTV---���� ����.");
	}
	public void soundUp() {
		System.out.println("LgTV---�Ҹ� �ø���.");
	}
	public void soundOff() {
		System.out.println("LgTV--�Ҹ� ������.");
	}
	*/
}
