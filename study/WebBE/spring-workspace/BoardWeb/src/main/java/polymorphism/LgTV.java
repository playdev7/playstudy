package polymorphism;

public class LgTV implements TV{
	// �������̽� ���� �� implements Ű���� ���.
	// TV �������̽��� �߻�޼ҵ忡 ���� ���� �������̵� ����.
	public void powerOn() {
		System.out.println("LgTV---���� �Ҵ�.");
	}
	public void powerOff() {
		System.out.println("LgTV---���� ����.");
	}
	public void volumeUp() {
		System.out.println("LgTV---�Ҹ� �ø���.");
	}
	public void volumeDown() {
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
