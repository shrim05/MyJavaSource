package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.enums.ServiceResult;
import kr.or.ddit.member.dao.IMemberDAO;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.member.exception.NotAuthenticatedException;
import kr.or.ddit.member.exception.UserNotFoundException;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl implements IMemberService{
	
	private static MemberServiceImpl instance;
	//결합력 최상 -> HCLC 지향 -> FactoryObject pattern ,  Strategy pattern (DI)
	private IMemberDAO dao = MemberDAOImpl.getInstance();
	private IAuthenticateService service = new AuthenticateServiceImpl();
	private MemberServiceImpl() {}
	
	public static MemberServiceImpl getInstance() {
		if(instance==null) {
			instance = new MemberServiceImpl();
		}
		return instance;
	}
	
	@Override
	public ServiceResult createMember(MemberVO mv) {
		MemberVO member = dao.selectMember(mv);
		if(member!=null) {
			return ServiceResult.PKDUPLICATED;
		}
		int result = dao.insertMember(mv);
		if(result<=0) {
			return ServiceResult.FAILED;
		}
		return ServiceResult.OK;
	}

	@Override
	public MemberVO retrieveMember(MemberVO mv) {
		MemberVO member = null;
		member = dao.selectMember(mv);
		if(member==null) {
			throw new UserNotFoundException("해당 유저 없음");
		}
		return member;
	}

	@Override
	public List<MemberVO> retrieveMemberList() {
		return dao.selectMemberList();
	}

	@Override
	public ServiceResult modifyMember(MemberVO mv) {
		ServiceResult sr = ServiceResult.FAILED;
		try {
			service.authenticate(mv);
			int result = 0;
			result = dao.updateMember(mv);
			if(result>0) {
				sr=ServiceResult.OK;
			}else if(result<=0) {
				sr=ServiceResult.FAILED;
			}
		}catch(NotAuthenticatedException e) {
			sr= ServiceResult.INVALIDPASSWORD;
		}
		return sr;
	}

	@Override
	public ServiceResult removeMember(MemberVO mv) {
		ServiceResult sr = ServiceResult.FAILED;
		try {
			service.authenticate(mv);
			int result = 0;
			result = dao.deleteMember(mv);
			if(result>0) {
				sr=ServiceResult.OK;
			}else if(result<=0) {
				sr=ServiceResult.FAILED;
			}
		}catch(NotAuthenticatedException e) {
			sr= ServiceResult.INVALIDPASSWORD;
		}
		return sr;
	}

}
