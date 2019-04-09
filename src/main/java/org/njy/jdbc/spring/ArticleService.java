package org.njy.jdbc.spring;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * articleDao瑜� �궗�슜�빐�꽌 湲� 紐⑸줉, 議고쉶, 異붽�, �닔�젙, �궘�젣瑜� �븳�떎.
 * 
 * @author Jacob
 *
 */
@Service
public class ArticleService {

	@Autowired
	ArticleDao articleDao;

	/**
	 * 湲� 紐⑸줉
	 */
	public void listArticles() {
		List<Article> articles = articleDao.listArticles();
		System.out.println(articles);
	}

	/**
	 * 湲� 議고쉶
	 */
	public void getArticle() {
		Article article = articleDao.getArticle("3");
		System.out.println(article);
	}

	/**
	 * 湲� �벑濡�
	 */
	public void addArticle() {
		Article article = new Article();
		article.setTitle("'踰꾨떇�뜫'�뿉 �궪�빀�쉶 �옄湲� �뱾�뼱媛붾굹---");
		article.setContent("寃쎌같 5媛쒓뎅 �씤�꽣�뤃 �삊議� �슂泥�");
		article.setUserId("1");
		article.setName("�굹�옱�뿽");
		if (articleDao.addArticle(article) > 0)
			System.out.println("회원정보를 입력하였습니다.");
		else
			System.out.println("湲��쓣 異붽��븯吏� 紐삵뻽�뒿�땲�떎.");
	}

	/**
	 * 湲� �닔�젙
	 */
	public void updateArticle() {
		Article article = new Article();
		article.setArticleId("7");
		article.setTitle("This is modified title.");
		article.setContent("This is modified content");
		if (articleDao.updateArticle(article) > 0)
			System.out.println("湲��쓣 �닔�젙�뻽�뒿�땲�떎.");
		else
			System.out.println("湲��쓣 �닔�젙�븯吏� 紐삵뻽�뒿�땲�떎.");
	}

	/**
	 * 湲� �궘�젣
	 */
	public void deleteArticle() {
		if (articleDao.deleteArticle("8") > 0)
			System.out.println("湲��쓣 �궘�젣�뻽�뒿�땲�떎.");
		else
			System.out.println("湲��쓣 �궘�젣�븯吏� 紐삵뻽�뒿�땲�떎.");
	}
}

