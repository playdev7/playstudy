package com.springbook.ioc.injection;

/* 컬렉션 정리
 * 중복 값을 허용하지 않는 집합 객체를 사용할 때는 java.util.Set 컬렉션을 사용한다.
// DB처럼 집합 객체를 사용할때는 java.util.Map 컬렉션을 사용한다. - key와 value로 나뉘어지도록
// java.util.Properties 컬렉션을 통해 key==value 형식으로 정의된 데이터를 등록하고 사용한다.
		// 스프링 설정 파일에서 <props> 요소를 사용한다.
 * */

/* 컬렉션 자료형
	// List - 연관된 자료들이 모여있는 컬렉션 객체 (중복 허용)
	// Set - 중복값을 허용하지 않는 집합 객체
	// Map - 특정 key 로 데이터를 등록하고 사용하는 집합 객체.
		// DB 테이블처럼 매핑되며 key는 기본키처럼 사용 됨.
 * */

import java.util.Properties;



public class CollectionBean {
	private Properties addressList;
	
	public void setAddressList(Properties addressList) {
		this.addressList = addressList;
	}
	
	public Properties getAddressList() {
		return addressList;
	}
}
