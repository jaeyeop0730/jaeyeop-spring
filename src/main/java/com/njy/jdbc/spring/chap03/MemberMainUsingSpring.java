package com.njy.jdbc.spring.chap03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * MemberRegisterService�� �׽�Ʈ�Ѵ�.<br>
 * Spring ApplicationContext�� ���� �����Ѵ�.
 * 
 * @author Jacob
 */
public class MemberMainUsingSpring {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"chap03.xml");
		MemberRegisterService regService = ctx.getBean("memberRegisterService",
				MemberRegisterService.class);

		// registerRequest �ʱ�ȭ
		RegisterRequest req = new RegisterRequest();
		req.setEmail("jacob@irafe.com");
		req.setPassword("xxxx");
		req.setName("Jacob");

		// ȸ�� ���
		regService.regist(req);
		
	}
}