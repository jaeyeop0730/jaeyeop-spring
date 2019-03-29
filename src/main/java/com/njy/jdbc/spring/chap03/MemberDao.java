package com.njy.jdbc.spring.chap03;

import java.util.HashMap;
import java.util.Map;

/**
 * p.62 [����Ʈ 3.5] MemberDao ����<br>
 * ȸ�� ���̺��� �����ϴ� Data Access Object
 * 
 * @author Jacob
 */
public class MemberDao {

	/**
	 *  ȸ������ �� (ȸ�� ���̺�)
	 */
	Map<String, Member> map = new HashMap<>();

	/**
	 * �̸��Ϸ� ȸ�� ���� ������
	 */
	public Member selectByEmail(String email) {
		return map.get(email);
	}

	/**
	 * ȸ������ ����
	 */
	public void insert(Member member) {
		map.put(member.getEmail(), member);
	}
}