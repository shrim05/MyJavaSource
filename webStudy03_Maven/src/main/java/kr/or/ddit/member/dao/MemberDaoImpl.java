package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PagingInfoVO;

public class MemberDaoImpl implements IMemberDAO {
	private SqlSessionFactory sqlSessionFactory =
			CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	@Override
	public int insertMember(MemberVO mv) {
		//insert , update, delete 의 경우  commit 직접해주거나 오토커밋 설정 필요
		try(
				SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			IMemberDAO mapper = sqlSession.getMapper(IMemberDAO.class);
			int cnt = mapper.insertMember(mv);
			sqlSession.commit();
			return cnt;
		}
	}

	@Override
	public int selectMemberCount(PagingInfoVO<MemberVO> pagingVO) {
		try(
						SqlSession sqlSession = sqlSessionFactory.openSession();
						){
			IMemberDAO mapper = sqlSession.getMapper(IMemberDAO.class);
				return mapper.selectMemberCount(pagingVO);
				}
	}

	
	@Override
	public List<MemberVO> selectMemberList(PagingInfoVO pagingVO) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		)
		{	
//			return sqlSession.selectList("kr.or.ddit.member.dao.IMemberDao.selectMemberList");
			IMemberDAO mapper = sqlSession.getMapper(IMemberDAO.class);
			return mapper.selectMemberList(pagingVO);
		}
	}

	@Override
	public MemberVO selectMember(MemberVO mv) {
		try(
				SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			IMemberDAO mapper = sqlSession.getMapper(IMemberDAO.class);
			return mapper.selectMember(mv);
		}
	}

	@Override
	public int updateMember(MemberVO mv) {
		try(
				SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			IMemberDAO mapper = sqlSession.getMapper(IMemberDAO.class);
			int cnt =  mapper.updateMember(mv);
			sqlSession.commit();
			return cnt;
		}
	}

	@Override
	public int deleteMember(MemberVO mv) {
		try(
				SqlSession sqlSession = sqlSessionFactory.openSession();
				){
			IMemberDAO mapper = sqlSession.getMapper(IMemberDAO.class);
			int cnt =  mapper.deleteMember(mv);
			sqlSession.commit();
			return cnt;
		}
	}


}
