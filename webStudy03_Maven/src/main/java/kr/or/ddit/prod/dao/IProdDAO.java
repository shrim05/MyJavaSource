package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.vo.PagingInfoVO;
import kr.or.ddit.vo.ProdVO;

/**
 *  상품관리  Persistence Layer
 *
 */
public interface IProdDAO {
	public int insertProd(ProdVO pv);
	public List<ProdVO> selectProdList(PagingInfoVO pagingVO);
	public ProdVO selectProd(String prod_id);
	public int updateProd(ProdVO pv);
	public int selectProdCount(PagingInfoVO pagingVO);
	
}
