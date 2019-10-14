package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.vo.Board2VO;
import kr.or.ddit.vo.PagingInfoVO;

public interface IBoard2DAO {
	public int insertBoard(Board2VO board);
	public int insertBoard(Board2VO board, SqlSession sqlSession);
	public int updateBoardHit(Board2VO board);
	public Board2VO selectBoard(Board2VO board);
	public int selectBoardCount(PagingInfoVO<Board2VO> pagingVO);
	public List<Board2VO> selectBoardList(PagingInfoVO<Board2VO> pagingVO);
	public int updateBoard(Board2VO board);
	public int updateBoard(Board2VO board, SqlSession sqlSession);
	public int deleteBoard(Board2VO board);
	public int deleteBoard(Board2VO board, SqlSession sqlSession);
	public int updateBoLike(Board2VO board);
}












