package polymorphism;

// ������ ���� ���� ����
// beanName �� ���� �ν��Ͻ��� ��ȯ�ϴ� ĸ��ȭ �� Factory ���� ����.

// ServerSide �ڵ��̶�� �����Ѵ�.
public class BeanFactory {
	public Object getBean(String beanName) {
		// ���� Ŭ���̾�Ʈ �� �μ��� ���� beanName �Ķ���� �۵�.
		if(beanName.equals("samsung")) {
			return new SamsungTV();
		} else if(beanName.equals("lg")) {
			return new LgTV();
		}
		return null;
	}
}