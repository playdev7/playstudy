package OkJava;

//org.opentutorials.iot ��Ű���� ������ Ŭ���� �ҷ�����.
import org.opentutorials.iot.Elevator;	// Elevator Ŭ����
import org.opentutorials.iot.Security;	// Security Ŭ����
import org.opentutorials.iot.Lighting;	// Lighting Ŭ����


public class OkJavaGoInHome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// �ߺ��Ǵ� ���ڿ��� ���ڿ� ������ ����
		String id = "JAVA APT 507";
		
		// Elevator Call
			// org.opentutorials.iot.Elevator myElevator = new org.opentutorials.iot.Elevator("JAVA APT 507");
					// import ���� myElevator �ν��Ͻ� �����ϴ� ����.
		
		// �ڵ尡 ������Ƿ� Elevator Ŭ���� import �� �ν��Ͻ� ����
		Elevator myElevator = new Elevator("id");
				// myElevator �ν��Ͻ� ���� - Elevator ��ü�� "JAVA APT 507" ���ڸ� ������ �ν��Ͻ�.
						// Elevator ��ü���� ID �Ķ���Ͱ� ���� �Ǿ� ����.
		
		myElevator.callForUp(1);	// ���������͸� 1������ ��������.
				// myElevator. �Է� �� ���� �޼ҵ� Ȯ�� ����.
		
		
		// Security off
		Security mySecurity = new Security("id");
				// mySecuriy �ν��Ͻ� ����.
		mySecurity.off();	// ��ť��Ƽ ����� �����ǵ���.
		
		
		// Light on
		Lighting hallLamp = new Lighting(id + " / Hall Lamp");	// ���ڿ� ���� Ȱ��!
				// hallLamp �ν��Ͻ� ����.	/ Hall Lamp == ������.
		hallLamp.on();	// ������ �� �ѱ�.
		// �ڵ� ������ ����� ���λ�� �����ϴ� ��� ������Ʈ�� ��õ�� ��.
		
		Lighting floorLamp = new Lighting(id + " / Floor Lamp"); // ���ڿ� ���� Ȱ��!
				// floorLamp �ν��Ͻ� ���� / Floor Lamp == ���� ����.
		floorLamp.on();	// ������ �� �ѱ�.
		
		System.out.println("");
		System.out.println("������ �ܼ��� �ؽ�Ʈ�� ����� ����� ��������, "
				+ "\nȰ���ϴ� ���� �ҽ��� ���� IOT ��⿡ ����Ǵ� �ҽ����? ��û����.");
	}
}