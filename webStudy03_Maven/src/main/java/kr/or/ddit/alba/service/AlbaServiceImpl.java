package kr.or.ddit.alba.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.alba.dao.AlbaDAOImpl;
import kr.or.ddit.alba.dao.IAlbaDAO;
import kr.or.ddit.enums.ServiceResult;
import kr.or.ddit.vo.AlbaVO;
import kr.or.ddit.vo.LicAlbaVO;
import kr.or.ddit.vo.PagingInfoVO;

public class AlbaServiceImpl implements IAlbaService {
	IAlbaDAO albaDAO = new AlbaDAOImpl();
	
	SqlSessionFactory sessionFactory = 
			kr.or.ddit.db.mybatis.CustomSqlSessionFactoryBuilder.getSqlSessionFactory();

	@Override
	public ServiceResult createAlba(AlbaVO albaVO) {
		try (SqlSession sqlSession = sessionFactory.openSession();) {
			int rowCnt = albaDAO.insertAlba(albaVO);
			List<LicAlbaVO> licAlbaList = albaVO.getLicenseList();
			if(licAlbaList!=null && licAlbaList.size()>0){
				albaDAO.insertLicenses(albaVO, sqlSession);
			}
			ServiceResult result = ServiceResult.FAILED;
			if (rowCnt > 0) {
				result = ServiceResult.OK;
				sqlSession.commit();
			}
			return result;
		}
	}

	@Override
	public AlbaVO retrieveAlba(String al_id) {
		AlbaVO albaVO = albaDAO.selectAlba(al_id);
		if (albaVO == null)
			throw new RuntimeException(al_id + " 알바생이 없음.");
		return albaVO;
	}

	@Override
	public int retrieveAlbaCount(PagingInfoVO<AlbaVO> pagingVO) {
		return albaDAO.selectAlbaCount(pagingVO);
	}

	@Override
	public List<AlbaVO> retrieveAlbaList(PagingInfoVO<AlbaVO> pagingVO) {
		return albaDAO.selectAlbaList(pagingVO);
	}

	@Override
	public ServiceResult modifyAlba(AlbaVO albaVO) {
		try (SqlSession sqlSession = sessionFactory.openSession();) {
			int rowCnt = albaDAO.updateAlba(albaVO, sqlSession);
			List<LicAlbaVO> licAlbaList = albaVO.getLicenseList();
			if(albaVO.getDeleteLic_codes()!=null) {
				rowCnt += albaDAO.deleteLicenses(albaVO, sqlSession);
			}
			if(licAlbaList!=null && licAlbaList.size()>0){
				rowCnt += albaDAO.insertLicenses(albaVO, sqlSession);
			}
			ServiceResult result = ServiceResult.FAILED;
			if (rowCnt > 0) {
				result = ServiceResult.OK;
				sqlSession.commit();
			}
			return result;
		}
	}

	@Override
	public ServiceResult removeAlba(String al_id) {
		try (SqlSession sqlSession = sessionFactory.openSession();) {
			AlbaVO albaVO = new AlbaVO();
			albaVO.setAl_id(al_id);
			// ******** 보유 라이센스 제거 후 개인정보 삭제
			int rowCnt = albaDAO.deleteLicenses(albaVO, sqlSession);
			rowCnt += albaDAO.deleteAlba(al_id, sqlSession);
			ServiceResult result = ServiceResult.FAILED;
			if (rowCnt > 0) {
				result = ServiceResult.OK;
				sqlSession.commit();
			}
			return result;
		}
	}
	
	@Override
	public LicAlbaVO retrieveLicense(LicAlbaVO licAlba) {
		return albaDAO.selectLicense(licAlba);
	}

}








