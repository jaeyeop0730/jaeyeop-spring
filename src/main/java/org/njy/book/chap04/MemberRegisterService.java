package org.njy.book.chap04;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.njy.book.chap03.DuplicateMemberException;
import org.njy.book.chap03.Member;
import org.njy.book.chap03.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * p.55 [由ъ뒪�듃 3.1] MemberRegisterService �닔�젙<br>
 * �쉶�썝�쓣 �벑濡앺븯�뒗 �꽌鍮꾩뒪
 * 
 * @author Jacob
 */
@Service
public class MemberRegisterService {

	@Autowired
	private MemberDao memberDao;

	static Logger logger = LogManager.getLogger();

	/**
	 * �쉶�썝 �벑濡�
	 * 
	 * @param req �궗�슜�옄媛� �엯�젰�븳 �쉶�썝 �젙蹂�
	 * @throws DuplicateMemberException �씠硫붿씪�씠 以묐났�맆 寃쎌슦�뿉 諛쒖깮
	 */
	public void regist(RegisterRequest req) {
		logger.debug(req);
		Member member = memberDao.selectByEmail(req.getEmail());

		// �쉶�썝�씠 �씠誘� 議댁옱�븯硫� �삁�쇅 諛쒖깮
		if (member != null) {
			throw new DuplicateMemberException("�씠硫붿씪 以묐났 " + req.getEmail());
		}

		// �쉶�썝�젙蹂� ���옣
		Member newMember = new Member(req.getEmail(), req.getPassword(),
				req.getName());
		memberDao.insert(newMember);
		logger.debug("회원 정보를 저장했습니다.");
	}
}