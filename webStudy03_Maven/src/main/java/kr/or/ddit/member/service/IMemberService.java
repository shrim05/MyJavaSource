package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.enums.ServiceResult;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PagingInfoVO;

/**
 *  회원 관리를 위한 Business Logic Layer
 *  CRUD
 */
public interface IMemberService {

	/**
	 *  신규 등록
	 * @param mv
	 * @return  아이디중복(PKDUPLICATED), 성공(OK) , 실패(FAILED)
	 */
	public ServiceResult createMember(MemberVO mv);
	
	/**
	 * 회원 정보 상세 조회
	 * @param member 조회할 회원에 대한 조건을 가진 VO
	 * @return 조건에 맞는 회원이 없는 경우 , UserNotFoundException 발생
	 */
	public MemberVO retrieveMember(MemberVO mv);
	
	/**
	 * 회원목록조회
	 * @param pagingVO TODO
	 * @return 조건에 맞는 회원이 없는 경우 ,size()==0
	 */
	public List<MemberVO> retrieveMemberList(PagingInfoVO pagingVO);
	
	public int retrieveMemberCount(PagingInfoVO<MemberVO> pagingVO);

	/**
	 * 회원정보수정
	 * @param mv 수정할 정보를 가진 VO
	 * @return UserNotFoundException , INVALIDPASSWORD (인증실패), 성공(OK), 실패(FAILED),  
	 */
	public ServiceResult modifyMember(MemberVO mv);
	
	/**
	 *  회원정보삭제
	 * @param mv
	 * @return UserNotFoundException , INVALIDPASSWORD (인증실패), 성공(OK), 실패(FAILED),  
	 */
	public ServiceResult removeMember(MemberVO mv);
}
