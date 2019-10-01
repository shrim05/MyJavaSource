package kr.or.ddit.prod.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.BuyerVO;

public class OthersDAOImpl implements IOtherDAO{
	
	private SqlSessionFactory sqlSessionFactory = 
			CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public List<Map<String, Object>> selectLprodList() {
		try(
						SqlSession sqlSession = sqlSessionFactory.openSession();
						){
					IOtherDAO mapper = sqlSession.getMapper(IOtherDAO.class);
					return mapper.selectLprodList();
				}
	}

	@Override
	public List<BuyerVO> selectBuyerList(String prod_lgu) {
		try(
				SqlSession sqlSession = sqlSessionFactory.openSession();
				){
			IOtherDAO mapper = sqlSession.getMapper(IOtherDAO.class);
			return mapper.selectBuyerList(prod_lgu);
		}
	}

}
