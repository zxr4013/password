package com.zxr.domain;

/**
 * @author zxr:zhaoxinran_dlmuit@163.com
 * @version 创建时间：2017年12月21日 下午9:17:38 
 * 类说明 测试功能类
 */
public class TestDemo {
	public static void main(String[] args) {
		UserService userService = new UserService();
		System.out.println("添加用户:");
		userService.regist(new User(1,"jiang","zhao@com","root"));
	}
}
