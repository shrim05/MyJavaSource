package kr.or.ddit.prod.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import kr.or.ddit.vo.BuyerVO;

public interface IOtherDAO {
	public List<Map<String,Object>>selectLprodList();
	public List<BuyerVO> selectBuyerList(@Param("prod_lgu") String prod_lgu);
}
