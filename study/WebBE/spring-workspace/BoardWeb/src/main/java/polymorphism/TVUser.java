// TVUser.java.
// �� �״�� Client Side ���� ���̶�� �����Ѵ�.

package polymorphism;

// ������ �����ӿ�ũ Ȱ�� ���� ���̺귯�� import
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

// Run Configuration Tip - Arguments ���� �ϰ� Run �ϸ� Default ���ڷ� ����ȴ�.
// ���� �ٸ� ���ڸ� ���� �����Ű���� �̸� �ο��ؼ� Apply ����. 

// Aoi_shiori �� ������ ���� + ���ڿ� �����̽� + API Ȱ���� ������ ����.

public class TVUser {
	public static void main(String[] args) {
		// 1. Spring �����̳ʸ� �����Ѵ�.
		AbstractApplicationContext factory =
				new GenericXmlApplicationContext("applicationContext-poly.xml");
				// factory �ν��Ͻ� ���� �� new GenericXmlApplicationContext("���� ���� �̸�.xml") �� ����.
		
		// 2. Spring �����̳ʷκ��� �ʿ��� ��ü�� ��û(Lookup) �Ѵ�.
		TV tv = (TV)factory.getBean("tv");
			// �߰� �ν��Ͻ� ������Ʈ.
			TV tv2 = (TV)factory.getBean("tv");
			TV tv3 = (TV)factory.getBean("tv");
			
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		// 3. Spring �����̳ʸ� �����Ѵ�.
		factory.close();
	}
	
	/* BeanFactory ������ ������ Ȱ���� ����
	// BeanFactory ��ü Ȱ��.
	BeanFactory factory = new BeanFactory();
	TV tv = (TV)factory.getBean(args[0]);
	// ���� �� Arguments �� ����� ������ �ν��Ͻ��� �����ȴ�. - Run Config.
	tv.powerOn();
	tv.volumeUp();
	tv.volumeDown();
	tv.powerOff();
	
	 */
	
	/*	TV �������̽��� Ȱ���� ���� - TV.java
	 * 	TV tv = new SamsungTV();
			// ������ LgTV()�� �ν��Ͻ��μ� ������ ����ȯ ����.
	 * */
		
	/*	�������� Ȱ������ ���� Poor �ڵ��� ����.
	 * 
	 * ���� ����� �ϴ� �� ���� ��ü������, �޼ҵ� �̸��� �ٸ�.
	 * �޼ҵ� �ñ״�ó�� �ٸ��Ƿ� �ڵ� ������ ���ŷο���.
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
