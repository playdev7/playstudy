
public class StringApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hello"); // String 문자열 "Hello"
		System.out.println("H");	// String 문자열 "H"
		System.out.println('H'); 	// Character 자료형 H
		// System.out.println('Hello') // Character 형은 문자 하나를 담는 자료형이므로 출력 불가.
		// 작은 따옴표는 Java에서 Character 형을 담는 그릇으로 사용하므로 유의.
		
		System.out.println("Hello "
				+ "World"); // + 기호를 통해서 문자열 간 더하기를 수행.
		// 하지만, 개행이 되지 않음.
		
		// 개행을 위해서는 \n 기호 사용.
		System.out.println("Hello \nworld");
		/*	다음과 같이 출력 됨.
		 	Hello
		 	World */
		
		// 문자열 출력 시 큰따옴표를 넣고 싶다면 \" 기호 사용.
		System.out.println("Hello \"World\""); // Hello "World" 를 출력
		// 큰따옴표는 문자열을 담는 그릇이기 때문에 컴파일 시 오류 발생.
		// 따라서 특수문자로서 큰따옴표 출력이 필요하다면 \" 기호로 사용.
		// 이 때 사용하는 백슬래시는 Escape 문자 라고도 부름.
		// 말 그대로 해방. 약속된 문자를 의미부여 없이 일시적으로 해방한다는 뜻을 가짐.
		
		
		// 그러고보니까 지금까지 return 을 안썼네. Java 에서는 안쓰는걸까?
	}

}
