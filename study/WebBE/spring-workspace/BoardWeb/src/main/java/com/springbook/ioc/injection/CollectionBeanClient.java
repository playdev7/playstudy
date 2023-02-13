package com.springbook.ioc.injection;

import java.util.Properties;

// Spring ���� ���� import
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

// CollecntionBean ��ü import
import com.springbook.ioc.injection.CollectionBean;

public class CollectionBeanClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory =
					new GenericXmlApplicationContext("applicationContext.xml");
		
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
		Properties addressList = bean.getAddressList();
		
		
		// ���� for��(�ڷ��� ������ : ���� �÷���)
		for(String key : addressList.stringPropertyNames()){
			System.out.println(String.format("Key: %s, Value: %s", key, addressList.get(key)));
		}
		
		/* Map �� ����� ���� ������ ���� Key ���� value ���� ��� ��ų �� �ִ�.
			for (String key : addressList.keySet()) {
				String value = (String) addressList.get(key);
				System.out.println(key + " : " + value);
			}
		*/
		
		factory.close();
	}
}