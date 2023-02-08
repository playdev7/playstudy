package OkJava;

import javax.swing.JOptionPane;

import org.opentutorials.iot.DimmingLights;
//org.opentutorials.iot 패키지의 각각의 클래스 불러오기.
import org.opentutorials.iot.Elevator;	// Elevator 클래스
import org.opentutorials.iot.Security;	// Security 클래스
import org.opentutorials.iot.Lighting;	// Lighting 클래스


public class OkJavaGoInHomeInput {

	public static void main(String[] args) {
		// 표준 구문 -> 함수명(자료형 파라미터) {메소드}
	// Java 표준 입력 방식 == Arguments.
	// 사용자 입력==인자 / String[] args == 문자열 배열 타입의 파라미터 / String[] 배열에 args 내용이 저장되는 방식. 
		// TODO Auto-generated method stub
		
		// 중복되는 문자열을 문자열 변수로 선언
		
		// arguments 통한 입력 받기
		String id = args[0];	// String[] 배열의 0번 인덱스
		String bright = args[1];	// String[] 배열의 1번 인덱스
		
			// JoptionPane 을 통한 GUI 입력 받기
			// String id = JOptionPane.showInputDialog("Enter a ID");
			// String bright = JOptionPane.showInputDialog("Enter a Bright Level");
					// 빨간 밑줄 마우스오버 후 Quick Fix 사용 시 import 및 swing 관련 모듈 기술 해줌.
				
		// Elevator Call
						// org.opentutorials.iot.Elevator myElevator = new org.opentutorials.iot.Elevator("JAVA APT 507");
								// iot 패키지 import 없이 myElevator 인스턴스 생성하는 구문.
		
		// 코드가 길어지므로 Elevator 클래스 import 후 인스턴스 생성
		Elevator myElevator = new Elevator(id);
				// myElevator 인스턴스 생성 - Elevator 객체에 "JAVA APT 507" 인자를 전달한 인스턴스.
						// Elevator 객체에는 ID 파라미터가 정의 되어 있음.
		
		myElevator.callForUp(1);	// 엘레베이터를 1층으로 보내도록.
				// myElevator. 입력 시 하위 메소드 확인 가능.
		
		
		// Security off
		Security mySecurity = new Security(id);
				// mySecuriy 인스턴스 생성.
		mySecurity.off();	// 시큐리티 기능이 해제되도록.
		
		
		// Light on
		Lighting hallLamp = new Lighting(id + " / Hall Lamp");	// 문자열 덧셈 활용!
				// hallLamp 인스턴스 생성.	/ Hall Lamp == 현관등.
		hallLamp.on();	// 현관등 불 켜기.
		// 코드 스니펫 기능은 접두사로 시작하는 모든 컴포넌트를 추천해 줌.
		
		Lighting floorLamp = new Lighting(id + " / Floor Lamp"); // 문자열 덧셈 활용!
				// floorLamp 인스턴스 생성 / Floor Lamp == 복도 전등.
		floorLamp.on();	// 복도등 불 켜기.
		
		DimmingLights moodLamp = new DimmingLights(id + " moodLamp");
		moodLamp.setBright(Double.parseDouble(bright));
					// Double.parseDouble 메소드를 통해 Double 형 변수로 형변환 가능.
		moodLamp.on();
		
		System.out.println("");
		System.out.println("Argument 띄어쓰기 포함 시 큰따옴표 \"\" 로 묶어준다. ");
	}
}
