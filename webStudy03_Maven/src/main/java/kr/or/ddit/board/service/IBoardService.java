package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.enums.ServiceResult;
import kr.or.ddit.vo.Attatch2VO;
import kr.or.ddit.vo.Board2VO;
import kr.or.ddit.vo.PagingInfoVO;

public interface IBoardService {
	
	public ServiceResult createBoard(Board2VO board);
	public Board2VO retrieveBoard(Board2VO board);
	public int retrieveBoardCount(PagingInfoVO<Board2VO> pagingVO);
	public List<Board2VO> retrieveBoardList(PagingInfoVO<Board2VO> pagingVO);
	
	public ServiceResult modifyBoard(Board2VO board);
	
	public ServiceResult removeBoard(Board2VO board);
	public Attatch2VO downloadAttatch(int att_no);
	public ServiceResult incrementLike(int bo_no);
}









