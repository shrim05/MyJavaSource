package kr.or.ddit.board.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.vo.Attatch2VO;
import kr.or.ddit.vo.Board2VO;

public interface IAttatch2DAO {
	public int insertAttatches(Board2VO board);
	public int insertAttatches(Board2VO board, SqlSession sqlSession);
	public Attatch2VO selectAttatch(int att_no);
	// 추가
	public int updateDowncount(int att_no);
	
	public int deleteAttatches(Board2VO board);
	public int deleteAttatches(Board2VO board, SqlSession sqlSession);
}
