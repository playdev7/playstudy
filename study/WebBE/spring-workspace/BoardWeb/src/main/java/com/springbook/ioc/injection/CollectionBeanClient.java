package com.springbook.ioc.injection;

import java.util.Properties;

// Spring 지원 도구 import
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

// CollecntionBean 객체 import
import com.springbook.ioc.injection.CollectionBean;

public class CollectionBeanClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory =
					new GenericXmlApplicationContext("applicationContext.xml");
		
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
		Properties addressList = bean.getAddressList();
		
		
		// 향상된 for문(자료형 변수명 : 참조 컬렉션)
		for(String key : addressList.stringPropertyNames()){
			System.out.println(String.format("Key: %s, Value: %s", key, addressList.get(key)));
		}
		
		/* Map 을 출력할 때는 다음과 같이 Key 따로 value 따로 출력 시킬 수 있다.
			for (String key : addressList.keySet()) {
				String value = (String) addressList.get(key);
				System.out.println(key + " : " + value);
			}
		*/
		
		factory.close();
	}
}