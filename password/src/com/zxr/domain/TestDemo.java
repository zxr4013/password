package com.zxr.domain;

/**
 * @author zxr:zhaoxinran_dlmuit@163.com
 * @version ����ʱ�䣺2017��12��21�� ����9:17:38 
 * ��˵�� ���Թ�����
 */
public class TestDemo {
	public static void main(String[] args) {
		UserService userService = new UserService();
		System.out.println("�����û�:");
		userService.regist(new User(1,"jiang","zhao@com","root"));
	}
}