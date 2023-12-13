package polymorphism;

public class SamsungTV implements TV {
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("===> SamsungTV ��ü ����");
	}
	
	// setter ������ ����� ���� �޼ҵ� ����.
	// Spring �� <bean> ��ü ���� ������ �ڵ����� ȣ������.
	// �޼ҵ� �̸��� set���� �����ϰ� �������� ù���ڸ� �빮�ڷ� �����Ѵ�.
		// �Ķ���Ͱ� speaker �̸� => setSpeaker()
	// ���� Spring ������ name ���� ���� �ܾ �ҹ��ڷ� �ۼ��Ѵ�.
		// <property name="speaker">
		public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker() ȣ��");
		this.speaker = speaker;
	}
	
	public void setPrice(int price) {
		System.out.println("===> setPrice() ȣ��");
		this.price = price;
	}
	
	/* ������ ������ ���� ����
		// Generate Constructor using Fields �� ������ ����
		// �ʱ�ȭ �� �������, ���� ����Ʈ ���� �� Generate �ϸ� �����ڰ� �߰���.
		// Hot Key: ALT SHIFT T
		public SamsungTV(Speaker speaker) {
			System.out.println("===> SamsungTV(2) ��ü ����");
			this.speaker = speaker;
		}
		
		public SamsungTV(Speaker speaker, int price) {
			System.out.println("===> SamsungTV(3) ��ü ����");
			this.speaker = speaker;
			this.price = price;
		}
	*/
	
	// Spring ������ ���� TV(n) ��ü �����ε� �� ����.
	// ������� - SamsungTV(3) ���� �ҷ����� �޼ҵ�.
	public void powerOn() {
		System.out.println("SamsungTV---���� �Ҵ�. (����: " + price + " )");
	}
	public void powerOff() {
		System.out.println("SamsungTV---���� ����.");
	}
	public void volumeUp() {
		
		speaker.volumeUp();
	}
	public void volumeDown() {
		
		speaker.volumeDown();
	}
	
	// ������� �ʱ�ȭ ���� initMethod �޼ҵ� ����.
		public void initMethod() {
			System.out.println("��ü �ʱ�ȭ �۾� ó��..");
			System.out.println("	init-method �� ��ü ���� ���Ŀ� ȣ��ȴ�.\n");
		}
		
		public void destroyMethod() {
			System.out.println("��ü ���� ���� ó���� ���� ó��...");
			System.out.println();
			System.out.println("�������� �����̳� ���� ���� �ڽ��� �����ϴ� ��� ��ü�� ������Ų��.");
			System.out.println("�� ������ ��� ��ü ���� ���� ���������� ����Ǵ� �޼ҵ��� ����̴�.");
		}
}
