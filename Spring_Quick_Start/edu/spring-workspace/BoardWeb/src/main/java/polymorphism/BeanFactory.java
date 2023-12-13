package polymorphism;

// 디자인 패턴 적용 예시
// beanName 에 따라 인스턴스를 반환하는 캡슐화 된 Factory 패턴 생성.

// ServerSide 코딩이라고 가정한다.
public class BeanFactory {
	public Object getBean(String beanName) {
		// 이후 클라이언트 쪽 인수에 따라 beanName 파라미터 작동.
		if(beanName.equals("samsung")) {
			return new SamsungTV();
		} else if(beanName.equals("lg")) {
			return new LgTV();
		}
		return null;
	}
}