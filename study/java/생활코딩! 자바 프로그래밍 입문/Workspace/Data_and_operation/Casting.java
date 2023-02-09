
public class Casting {
	public static void main(String[] args) {
		double a = 1.1;
		double b = 1;	// 실수 1.0 으로 캐스팅(변환) 됨
		// 형변환과 캐스팅은 엄연히 그 의미가 다르다.
	
		
		// int c = 1.1; -> Type Mismatch: 캐스팅 불가. double 형 자료는 int에 담을 수 없음.
		
		// Eclipse Tip - 문법 오류 발생 시 좌측 전구 hover 하면 오류 확인 가능
		// Quick fix 기능 통해 오류 해결 방법 선택 가능.
		
		int c = (int) 1.1; // int 값 으로 강제 캐스팅.
		System.out.println(b);
		System.out.println("c is: " + c);
		
		// 독립적인 개발을 위해서 검색을 최대한 활용하자.
		// 1을 String 으로 캐스팅하는 방법 - Integer.toString 메소드 활용.
		String f = Integer.toString(1);
		
		// 리터럴 표기법이랑 대체 무슨 차이일까?
		String g = "1";
		
		// int 변수를 String으로 바꿀 때 매우 유용하지.
		c = 2;
		String StrC = Integer.toString(c);
		System.out.println("int c value changed 2");
		
		System.out.println(f);
		System.out.println(g);
		System.out.println("StrC is: " + StrC);
		
		// getClass() 메소드 활용하여 변수의 자료형 확인 가능.
		System.out.println("getClass() 메소드 사용 시 변수의 자료형 확인 가능");
		System.out.println(f.getClass());
		
		
		// 어떤 언어이던, 익숙해져야 능숙하다.
		// 그리고 익숙함은 언제든 낯설어 질 수 있다.
		// 낯설어졌다고 도망가지 말고, 최선을 다해서 친해져야한다.
		// 가장 좋은 방법은 자주 만날 것. 완벽함 보다는 천천히 좋은 친구가 되는 것.
		// 그 좋은 친구와 세상을 유익하게 하는 방향으로 나아갈 것.
		// 방대한 Java의 세상으로, 더 넓은 세상으로, 겸손하게.
		// 순간마다 스스로가 판단하는 가장 옳은 길을 향해 꾸준하게 나아가자.
	}
}