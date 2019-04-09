package org.njy.book.Example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ArticleMain {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("example.xml");
		ArticleService articleService = ctx.getBean("articleService", org.njy.book.Example.ArticleService.class);
		MemberService memberService = ctx.getBean("memberService", org.njy.book.Example.MemberService.class);

		articleService.addArticle();
		memberService.registerMember();

		ctx.close();
	}

}