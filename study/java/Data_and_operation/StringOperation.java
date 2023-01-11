
public class StringOperation {
	public static void main(String[] args) {
		System.out.println("Hello World".length()); // length() 함수로 문자열의 길이를 출력.
		
		// 만약 이메일을 보내는 프로그램인데, 이름을 계속 바꿔줘야 하는 상황이라면.
		System.out.println("Hi, egoing ... THX.".replace("egoing", "leezche")); // replace() 함수로 문자열 변환.
		// replace("문자열A", "문자열B") -> 문자열 A의 내용을 문자열 B 로 대체.
		// 문자열의 크기는 달라도 된다 -> 문자열A를 모두 비우고 시작점부터 문자열 B 만큼 채워줌.
		
		// 조금 더 효율적으로 [[[name]]] 이라는 템플릿처럼 쓰자!
		System.out.println("Hi, [[[name]]] ... THX.".replace("[[[name]]]", "leezche")); // 이렇게!
	}
}