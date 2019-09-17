package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.enums.ServiceResult;
import kr.or.ddit.member.dao.IMemberDAO;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.member.exception.UserNotFoundException;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl implements IMemberService{
	
	private static MemberServiceImpl instance;
	//결합력 최상 -> HCLC 지향 -> FactoryObject pattern ,  Strategy pattern (DI)
	private IMemberDAO dao = MemberDAOImpl.getInstance();

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResult modifyMember(MemberVO mv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResult removeMember(MemberVO mv) {
		// TODO Auto-generated method stub
		return null;
	}

}
