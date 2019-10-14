package kr.or.ddit.board.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.Attatch2VO;
import kr.or.ddit.vo.Board2VO;

public class Attatch2DAOImpl implements IAttatch2DAO {
	SqlSessionFactory sqlSessionFactory =
			CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public int insertAttatches(Board2VO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertAttatches(Board2VO board, SqlSession sqlSession) {
		IAttatch2DAO mapper = sqlSession.getMapper(IAttatch2DAO.class);
		return mapper.insertAttatches(board);
	}

	@Override
	public Attatch2VO selectAttatch(int att_no) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();	
		){
			IAttatch2DAO mapper = sqlSession.getMapper(IAttatch2DAO.class);
			return mapper.selectAttatch(att_no);
		}
	}

	@Override
	public int deleteAttatches(Board2VO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAttatches(Board2VO board, SqlSession sqlSession) {
		IAttatch2DAO mapper = sqlSession.getMapper(IAttatch2DAO.class);
		return mapper.deleteAttatches(board);
	}

	@Override
	public int updateDowncount(int att_no) {
		// TODO Auto-generated method stub
		return 0;
	}

}
