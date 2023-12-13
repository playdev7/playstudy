package OkJava;

import javax.swing.JOptionPane;

import org.opentutorials.iot.DimmingLights;
//org.opentutorials.iot ��Ű���� ������ Ŭ���� �ҷ�����.
import org.opentutorials.iot.Elevator;	// Elevator Ŭ����
import org.opentutorials.iot.Security;	// Security Ŭ����
import org.opentutorials.iot.Lighting;	// Lighting Ŭ����


public class OkJavaGoInHomeInput {

	public static void main(String[] args) {
		// ǥ�� ���� -> �Լ���(�ڷ��� �Ķ����) {�޼ҵ�}
	// Java ǥ�� �Է� ��� == Arguments.
	// ����� �Է�==���� / String[] args == ���ڿ� �迭 Ÿ���� �Ķ���� / String[] �迭�� args ������ ����Ǵ� ���. 
		// TODO Auto-generated method stub
		
		// �ߺ��Ǵ� ���ڿ��� ���ڿ� ������ ����
		
		// arguments ���� �Է� �ޱ�
		String id = args[0];	// String[] �迭�� 0�� �ε���
		String bright = args[1];	// String[] �迭�� 1�� �ε���
		
			// JoptionPane �� ���� GUI �Է� �ޱ�
			// String id = JOptionPane.showInputDialog("Enter a ID");
			// String bright = JOptionPane.showInputDialog("Enter a Bright Level");
					// ���� ���� ���콺���� �� Quick Fix ��� �� import �� swing ���� ��� ��� ����.
				
		// Elevator Call
						// org.opentutorials.iot.Elevator myElevator = new org.opentutorials.iot.Elevator("JAVA APT 507");
								// iot ��Ű�� import ���� myElevator �ν��Ͻ� �����ϴ� ����.
		
		// �ڵ尡 ������Ƿ� Elevator Ŭ���� import �� �ν��Ͻ� ����
		Elevator myElevator = new Elevator(id);
				// myElevator �ν��Ͻ� ���� - Elevator ��ü�� "JAVA APT 507" ���ڸ� ������ �ν��Ͻ�.
						// Elevator ��ü���� ID �Ķ���Ͱ� ���� �Ǿ� ����.
		
		myElevator.callForUp(1);	// ���������͸� 1������ ��������.
				// myElevator. �Է� �� ���� �޼ҵ� Ȯ�� ����.
		
		
		// Security off
		Security mySecurity = new Security(id);
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
		
		DimmingLights moodLamp = new DimmingLights(id + " moodLamp");
		moodLamp.setBright(Double.parseDouble(bright));
					// Double.parseDouble �޼ҵ带 ���� Double �� ������ ����ȯ ����.
		moodLamp.on();
		
		System.out.println("");
		System.out.println("Argument ���� ���� �� ū����ǥ \"\" �� �����ش�. ");
	}
}