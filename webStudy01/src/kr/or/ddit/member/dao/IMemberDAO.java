package kr.or.ddit.member.dao;

import java.sql.SQLException;

import kr.or.ddit.vo.MemberVO;

public interface IMemberDAO {
	public MemberVO selectMember(MemberVO member);
}
