package org.njy.book.chap07;

import java.util.List;

import org.njy.book.chap03.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * �씤�꽣�럹�씠�뒪 MemberDao�쓽 援ы쁽泥�. SpringJdbc瑜� �궗�슜�빐�꽌 援ы쁽
 * 
 * @author Jacob
 */
@Repository("memberDao")
public class MemberDaoImplUsingSpringJdbc implements MemberDao {

	static final String SELECT_BY_EMAIL = "SELECT memberId, email, name FROM member WHERE email=?";

	static final String INSERT = "INSERT member(email, password, name) VALUES(?, sha2(?,256), ?)";

	static final String UPDATE = "UPDATE member SET email=?, password=sha2(?,256), name=? WHERE memberId=?";

	static final String SELECT_ALL = "SELECT memberId, email, name FROM member ORDER BY memberId desc LIMIT ?,?";
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * jdbcTemplate setter for injection
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * p.194�쓽 memberRowMapper<br>
	 * Member �삤釉뚯젥�듃�� member �뀒�씠釉붿쓽 �븳 �뻾�쓣 留ㅽ븨�븯�뒗 rowMapper
	 */
	RowMapper<Member> memberRowMapper = new BeanPropertyRowMapper<>(
			Member.class);

	/**
	 * p.192 [由ъ뒪�듃 8.8]�쓽 selectByEmail() 硫붿꽌�뱶 �닔�젙
	 */
	@Override
	public Member selectByEmail(String email) {
		return jdbcTemplate.queryForObject(SELECT_BY_EMAIL, memberRowMapper,
				email);
	}

	/**
	 * p.201 [由ъ뒪�듃 8.12]�쓽 insert() 硫붿꽌�뱶 �닔�젙
	 */
	@Override
	public void insert(Member member) {
		jdbcTemplate.update(INSERT, member.getEmail(), member.getPassword(),
				member.getName());
	}

	/**
	 * p.198 [由ъ뒪�듃 8.11]�쓽 update() 硫붿꽌�뱶 �닔�젙
	 */
	@Override
	public void update(Member member) {
		jdbcTemplate.update(UPDATE, member.getEmail(), member.getPassword(),
				member.getName(), member.getMemberId());
	}

	/**
	 * p.195 [由ъ뒪�듃 8.9] selectAll() 硫붿꽌�뱶 �닔�젙
	 */
	@Override
	public List<Member> selectAll(int offset, int count) {
		return jdbcTemplate.query(SELECT_ALL, memberRowMapper, 0, 100);
	}
}