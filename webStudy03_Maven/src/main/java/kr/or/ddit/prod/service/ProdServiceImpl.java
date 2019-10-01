package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.enums.ServiceResult;
import kr.or.ddit.exception.CommonException;
import kr.or.ddit.prod.dao.IProdDAO;
import kr.or.ddit.prod.dao.ProdDAOImpl;
import kr.or.ddit.vo.PagingInfoVO;
import kr.or.ddit.vo.ProdVO;

public class ProdServiceImpl implements IProdService {
	
	IProdDAO dao = new ProdDAOImpl();
	
	@Override
	public ServiceResult createProd(ProdVO pv) {
		ServiceResult result = null;
		int cnt = dao.insertProd(pv);
		if(cnt >0 ) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

	@Override
	public List<ProdVO> retrieveProdList(PagingInfoVO pagingVO) {
		return dao.selectProdList(pagingVO);
	}

	@Override
	public ProdVO retrieveProd(String prod_id) {
		ProdVO pv = dao.selectProd(prod_id);
		if(pv==null) {
			throw new CommonException(prod_id+"해당 품목 없음");
		}
		return pv;
	}

	@Override
	public ServiceResult modifyProd(ProdVO pv) {
		ServiceResult result = null;
		retrieveProd(pv.getProd_id());
		int cnt = dao.updateProd(pv);
		if(cnt>0) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

	@Override
	public int retrieveProdCount(PagingInfoVO pagingVO) {
		return dao.selectProdCount(pagingVO);
		
	}


}
