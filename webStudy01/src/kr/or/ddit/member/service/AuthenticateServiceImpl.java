package kr.or.ddit.member.service;

import kr.or.ddit.member.dao.IMemberDAO;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.member.exception.NotAuthenticatedException;
import kr.or.ddit.member.exception.UserNotFoundException;
import kr.or.ddit.vo.MemberVO;

public class AuthenticateServiceImpl implements IAuthenticateService {
	IMemberDAO dao = MemberDAOImpl.getInstance();
	
	@Override
	public MemberVO authenticate(MemberVO member) {
		MemberVO savedMember = dao.selectMember(member);
		if(savedMember == null) {
			throw new UserNotFoundException("아이디가 잘못됐습니다");
		}
		if(!savedMember.getMem_pass().equals(member.getMem_pass())) {
			throw new NotAuthenticatedException("비밀번호가 잘못됐음");
		}
		return savedMember;
	}

}
