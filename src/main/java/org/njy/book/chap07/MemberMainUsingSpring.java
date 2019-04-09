package org.njy.book.chap07;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * p.204 [由ъ뒪�듃 8.13]瑜� Main怨� Service濡� 遺꾨━�븳 Main 遺�遺�<br>
 * Spring�쑝濡� bean�쓣 愿�由ы븿
 * 
 * @author Jacob
 */
public class MemberMainUsingSpring {

	/**
	 * main() 硫붿꽌�뱶
	 */
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(
				"chap07.xml");
		MemberService memberService = ctx.getBean(MemberService.class);
		memberService.insertMember();
		memberService.selectAll();
		ctx.close();
	}
}