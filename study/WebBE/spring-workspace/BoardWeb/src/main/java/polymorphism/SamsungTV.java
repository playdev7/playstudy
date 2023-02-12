package polymorphism;

public class SamsungTV implements TV {
	public SamsungTV() {
		System.out.println("===> SamsungTV ��ü ����");
	}
	
	// ������� �ʱ�ȭ ���� initMethod �޼ҵ� ����.
	public void initMethod() {
		System.out.println("��ü �ʱ�ȭ �۾� ó��");
		System.out.println("init-method �� ��ü ���� ���Ŀ� ȣ��ȴ�.");
	}
	
	public void destroyMethod() {
		System.out.println("��ü ���� ���� ó���� ���� ó��...");
		System.out.println("�������� �����̳� ���� ���� �ڽ��� �����ϴ� ��� ��ü�� ������Ų��.");
		System.out.println("�� ������ ��� ��ü ���� ���� ���������� ����Ǵ� �޼ҵ��� ����̴�.");
	}
	
	
	public void powerOn() {
		System.out.println("SamsungTV---���� �Ҵ�.");
	}
	public void powerOff() {
		System.out.println("SamsungTV---���� ����.");
	}
	public void volumeUp() {
		System.out.println("SamsungTV--�Ҹ� �ø���.");
	}
	public void volumeDown() {
		System.out.println("SamsungTV--�Ҹ� ������.");
	}

}
