package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.Board2VO;
import kr.or.ddit.vo.PagingInfoVO;

public class Board2DAOImpl implements IBoard2DAO {
	
	SqlSessionFactory sqlSessionFactory =
			CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	@Override
	public int insertBoard(Board2VO board) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();	
			){
		IBoard2DAO mapper = sqlSession.getMapper(IBoard2DAO.class);
		int cnt = mapper.insertBoard(board);
		sqlSession.commit();
		return cnt;
	}
	}

	@Override
	public int insertBoard(Board2VO board, SqlSession sqlSession) {
		IBoard2DAO mapper = sqlSession.getMapper(IBoard2DAO.class);
		return mapper.insertBoard(board);
	}

	@Override
	public int updateBoardHit(Board2VO board) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();	
			){
			IBoard2DAO mapper = sqlSession.getMapper(IBoard2DAO.class);
			int cnt = mapper.updateBoardHit(board);
			sqlSession.commit();
			return cnt;
		}
	}

	@Override
	public Board2VO selectBoard(Board2VO board) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();	
		){
			IBoard2DAO mapper = sqlSession.getMapper(IBoard2DAO.class);
			return mapper.selectBoard(board);
		}
	}

	@Override
	public int selectBoardCount(PagingInfoVO<Board2VO> pagingVO) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();	
		){
			IBoard2DAO mapper = sqlSession.getMapper(IBoard2DAO.class);
			return mapper.selectBoardCount(pagingVO);
		}
	}

	@Override
	public List<Board2VO> selectBoardList(PagingInfoVO<Board2VO> pagingVO) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();	
		){
			IBoard2DAO mapper = sqlSession.getMapper(IBoard2DAO.class);
			return mapper.selectBoardList(pagingVO);
		}
	}

	@Override
	public int updateBoard(Board2VO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBoard(Board2VO board, SqlSession sqlSession) {
		IBoard2DAO mapper = sqlSession.getMapper(IBoard2DAO.class);
		return mapper.updateBoard(board);
	}

	@Override
	public int deleteBoard(Board2VO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(Board2VO board, SqlSession sqlSession) {
		IBoard2DAO mapper = sqlSession.getMapper(IBoard2DAO.class);
		return mapper.deleteBoard(board);
	}

	@Override
	public int updateBoLike(Board2VO board) {
		try(
						SqlSession sqlSession = sqlSessionFactory.openSession();
						){
					IBoard2DAO mapper = sqlSession.getMapper(IBoard2DAO.class);
					int cnt = mapper.updateBoLike(board);
					sqlSession.commit();
					return cnt;
				}
	}

}
