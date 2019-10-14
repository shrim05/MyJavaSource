package kr.or.ddit.alba.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.vo.AlbaVO;
import kr.or.ddit.vo.LicAlbaVO;
import kr.or.ddit.vo.PagingInfoVO;

public interface IAlbaDAO {

	public int insertAlba(AlbaVO albaVO);
 
	public AlbaVO selectAlba(String al_id);
	
	public int selectAlbaCount(PagingInfoVO<AlbaVO> pagingVO);

	public List<AlbaVO> selectAlbaList(PagingInfoVO<AlbaVO> pagingVO);

	public int updateAlba(AlbaVO albaVO, SqlSession sqlSession);

	public int deleteAlba(String al_id, SqlSession sqlSession);

	public int insertLicenses(AlbaVO albaVO, SqlSession sqlSession);
	
	public int deleteLicenses(AlbaVO albaVO, SqlSession sqlSession);
	
	public LicAlbaVO selectLicense(LicAlbaVO licAlba);
}