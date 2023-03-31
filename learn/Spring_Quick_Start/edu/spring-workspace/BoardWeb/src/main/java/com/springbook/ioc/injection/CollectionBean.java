package com.springbook.ioc.injection;

/* �÷��� ����
 * �ߺ� ���� ������� �ʴ� ���� ��ü�� ����� ���� java.util.Set �÷����� ����Ѵ�.
// DBó�� ���� ��ü�� ����Ҷ��� java.util.Map �÷����� ����Ѵ�. - key�� value�� ������������
// java.util.Properties �÷����� ���� key==value �������� ���ǵ� �����͸� ����ϰ� ����Ѵ�.
		// ������ ���� ���Ͽ��� <props> ��Ҹ� ����Ѵ�.
 * */

/* �÷��� �ڷ���
	// List - ������ �ڷ���� ���ִ� �÷��� ��ü (�ߺ� ���)
	// Set - �ߺ����� ������� �ʴ� ���� ��ü
	// Map - Ư�� key �� �����͸� ����ϰ� ����ϴ� ���� ��ü.
		// DB ���̺�ó�� ���εǸ� key�� �⺻Űó�� ��� ��.
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
