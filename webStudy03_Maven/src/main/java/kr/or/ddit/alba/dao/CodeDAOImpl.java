package kr.or.ddit.alba.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.mybatis.CustomSqlSessionFactoryBuilder;

public class CodeDAOImpl implements ICodeDAO {
	SqlSessionFactory sessionFactory = 
			CustomSqlSessionFactoryBuilder.getSqlSessionFactory();

	@Override
	public List<Map<String, String>> selectLicense() {
		try(
			SqlSession sqlSession = sessionFactory.openSession();
		){
			return sqlSession.getMapper(ICodeDAO.class).selectLicense();
		}
	}

	@Override
	public List<Map<String, String>> selectGrades() {
		try(
			SqlSession sqlSession = sessionFactory.openSession();
		){
			return sqlSession.getMapper(ICodeDAO.class).selectGrades();
		}
	}

}
