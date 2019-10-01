package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.enums.ServiceResult;
import kr.or.ddit.exception.CommonException;
import kr.or.ddit.vo.PagingInfoVO;
import kr.or.ddit.vo.ProdVO;

/**
 * 상품관리 Business Logic Layer
 *
 */
public interface IProdService {
	/**
	 * @param pv
	 * @return OK , FAILED
	 */
	public ServiceResult createProd(ProdVO pv);
	public int retrieveProdCount(PagingInfoVO pagingVO);
	public List<ProdVO> retrieveProdList(PagingInfoVO pagingVO);
	public ProdVO retrieveProd(String prod_id);
	/**
	 * @param pv
	 * @return CommonException, OK, FAILED
	 */
	public ServiceResult modifyProd(ProdVO pv);
	
}
