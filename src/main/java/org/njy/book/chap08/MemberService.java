package org.njy.book.chap08;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.njy.book.chap03.Member;

/**
 * p.204 [由ъ뒪�듃 8.13]瑜� Main怨� Service濡� 遺꾨━�븳 Service 遺�遺�
 * 
 * @author Jacob
 */
public class MemberService {

	Logger logger = LogManager.getLogger();

	MemberDao memberDao = null;

	/**
	 * memberDao setter for injection
	 */
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void selectAll() {
		List<Member> members = memberDao.selectAll(0, 100);
		logger.debug(members);
	}

	public void updateMember() {
		Member member = memberDao.selectByEmail("sunha0822@naver.com");
		member.setPassword("b");
		memberDao.update(member);
		logger.debug("Update complete.");
	}

	public void insertMember() {
		Member member = new Member();
		member.setEmail("main7310@naver.com");
		member.setPassword("123456");
		member.setName("�굹�옱�뿽");
		memberDao.insert(member);
		logger.debug("Insert complete.");
	}
}