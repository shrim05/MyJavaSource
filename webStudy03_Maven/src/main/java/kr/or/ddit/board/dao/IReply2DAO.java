package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.vo.PagingInfoVO;
import kr.or.ddit.vo.Reply2VO;

public interface IReply2DAO {
	public int insertReply(Reply2VO reply);
	public int selectReplyCount(PagingInfoVO<Reply2VO> pagingVO);
	public List<Reply2VO> selectReplyList(PagingInfoVO<Reply2VO> pagingVO);
	public int updateReply(Reply2VO reply);
	public int deleteReply(Reply2VO reply);
}







