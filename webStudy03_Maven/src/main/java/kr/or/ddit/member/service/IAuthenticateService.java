package kr.or.ddit.member.service;

import kr.or.ddit.vo.MemberVO;

public interface IAuthenticateService {
	public MemberVO authenticate(MemberVO member);
}
