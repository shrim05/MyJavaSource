package kr.or.ddit.member.dao;

import java.util.List;

import kr.or.ddit.vo.MemberVO;

/**
 *  회원관리를 위한 Persistence layer
 * CRUD
 */
public interface IMemberDAO {
	
	/**
	 *  신규등록
	 * @param mv
	 * @return 등록성공(>0), 실패(<=0)
	 */
	public int insertMember(MemberVO mv);
	
	/**
	 * 회원목록조회
	 * @return 조건에 맞는 회원이 없는 경우 ,size()==0
	 */
	public List<MemberVO> selectMemberList();
	
	/**
	 * 회원 상세 조회
	 * @param member 조회할 회원에 대한 조건을 가진 VO
	 * @return 조건에 맞는 회원이 없는 경우 null 반환
	 */
	public MemberVO selectMember(MemberVO mv);

	/**
	 * 회원정보수정
	 * @param mv 수정할 정보를 가진 VO
	 * @return 수정 성공 실패여부를 확인할 row count
	 */
	public int updateMember(MemberVO mv);
	
	/**
	 *  회원정보삭제
	 * @param mv
	 * @return 삭제 성공 실패여부를 확인할 row count
	 */
	public int deleteMember(MemberVO mv);
}
