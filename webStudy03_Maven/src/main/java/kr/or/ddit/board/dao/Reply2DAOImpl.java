package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.PagingInfoVO;
import kr.or.ddit.vo.Reply2VO;

public class Reply2DAOImpl implements IReply2DAO {
	SqlSessionFactory sqlSessionFactory =
			CustomSqlSessionFactoryBuilder.getSqlSessionFactory();

	@Override
	public int insertReply(Reply2VO reply) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();	
		){
			IReply2DAO mapper = sqlSession.getMapper(IReply2DAO.class);
			int cnt = mapper.insertReply(reply);
			sqlSession.commit();
			return cnt;
		}
	}

	@Override
	public int selectReplyCount(PagingInfoVO<Reply2VO> pagingVO) {
		try(
				SqlSession sqlSession = sqlSessionFactory.openSession();	
			){
				IReply2DAO mapper = sqlSession.getMapper(IReply2DAO.class);
				return mapper.selectReplyCount(pagingVO);
			}
	}

	@Override
	public List<Reply2VO> selectReplyList(PagingInfoVO<Reply2VO> pagingVO) {
		try(
				SqlSession sqlSession = sqlSessionFactory.openSession();	
			){
				IReply2DAO mapper = sqlSession.getMapper(IReply2DAO.class);
				return mapper.selectReplyList(pagingVO);
			}
	}

	@Override
	public int updateReply(Reply2VO reply) {
		try(
				SqlSession sqlSession = sqlSessionFactory.openSession();	
			){
				IReply2DAO mapper = sqlSession.getMapper(IReply2DAO.class);
				int cnt = mapper.updateReply(reply);
				sqlSession.commit();
				return cnt;
			}
	}

	@Override
	public int deleteReply(Reply2VO reply) {
		try(
				SqlSession sqlSession = sqlSessionFactory.openSession();	
			){
				IReply2DAO mapper = sqlSession.getMapper(IReply2DAO.class);
				int cnt = mapper.deleteReply(reply);
				sqlSession.commit();
				return cnt;
			}
	}

}
