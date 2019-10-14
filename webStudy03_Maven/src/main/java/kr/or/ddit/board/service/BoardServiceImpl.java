package kr.or.ddit.board.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.board.dao.Attatch2DAOImpl;
import kr.or.ddit.board.dao.Board2DAOImpl;
import kr.or.ddit.board.dao.IAttatch2DAO;
import kr.or.ddit.board.dao.IBoard2DAO;
import kr.or.ddit.db.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.enums.ServiceResult;
import kr.or.ddit.exception.CommonException;
import kr.or.ddit.vo.Attatch2VO;
import kr.or.ddit.vo.Board2VO;
import kr.or.ddit.vo.PagingInfoVO;

public class BoardServiceImpl implements IBoardService {
	IBoard2DAO boardDAO = new Board2DAOImpl();
	IAttatch2DAO attatchDAO = new Attatch2DAOImpl();
	SqlSessionFactory sqlSessionFactory =
			CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	File saveFolder = new File("d:/saveFiles");
	private int processAttatch(Board2VO board, SqlSession sqlSession) {
		List<Attatch2VO> attatchList = board.getAttatchList();
		int cnt = 0;
		if(attatchList!=null) {
			cnt = attatchDAO.insertAttatches(board, sqlSession);
			for(Attatch2VO attatch : attatchList) {
//				if(1==1) throw new RuntimeException("강제 발생 예외");
				try {
					attatch.saveFile(saveFolder);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return cnt;
	}
	
	private int deleteAttatch(Board2VO board, SqlSession sqlSession) {
		Integer[] delAtts = board.getDelAttatches();
		int cnt = 0;
		if(delAtts!=null && delAtts.length>0) {
			for(int delNo : delAtts) {
				Attatch2VO attatch = attatchDAO.selectAttatch(delNo);
				FileUtils.deleteQuietly(
						new File(saveFolder, attatch.getAtt_savename()));
			}
			cnt  += attatchDAO.deleteAttatches(board, sqlSession);
		}
		return cnt;
	}
	
	@Override
	public ServiceResult createBoard(Board2VO board) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			int cnt = boardDAO.insertBoard(board, sqlSession);
			cnt += processAttatch(board, sqlSession);
			ServiceResult result = null;
			if(cnt > 0) result = ServiceResult.OK;
			else result = ServiceResult.FAILED;
			sqlSession.commit();
			return result;
		}
	}

	@Override
	public Board2VO retrieveBoard(Board2VO board) {
		Board2VO savedBoard = boardDAO.selectBoard(board);
		if(savedBoard==null) throw new CommonException(board.getBo_no()+", 해당 글이 없음.");
		boardDAO.updateBoardHit(board);
		return savedBoard;
	}

	@Override
	public int retrieveBoardCount(PagingInfoVO<Board2VO> pagingVO) {
		return boardDAO.selectBoardCount(pagingVO);
	}

	@Override
	public List<Board2VO> retrieveBoardList(PagingInfoVO<Board2VO> pagingVO) {
		return boardDAO.selectBoardList(pagingVO);
	}

	@Override
	public ServiceResult modifyBoard(Board2VO board) {
		Board2VO savedBoard = retrieveBoard(board);
		ServiceResult result = null;
		if(savedBoard.getBo_pass().equals(board.getBo_pass())){
			try(
				SqlSession sqlSession = sqlSessionFactory.openSession();	
			){
				int cnt = boardDAO.updateBoard(board, sqlSession);
				cnt += processAttatch(board, sqlSession);
				cnt += deleteAttatch(board, sqlSession);
				if(cnt>0) {
					sqlSession.commit();
					result = ServiceResult.OK;
				}else {
					result = ServiceResult.FAILED;
				}
			}
		}else {
			result = ServiceResult.INVALIDPASSWORD;
		}
		return result;
	}

	

	@Override // AOP
	public ServiceResult removeBoard(Board2VO board) {
		Board2VO savedBoard = retrieveBoard(board);
		ServiceResult result = null;
		if(savedBoard.getBo_pass().equals(board.getBo_pass())){
			List<Attatch2VO> attatchList = savedBoard.getAttatchList();
			try(
				SqlSession sqlSession = sqlSessionFactory.openSession();	
			){
				int cnt = 0;
				if(attatchList!=null && attatchList.size()>0) {
					// meta delete
					cnt += attatchDAO.deleteAttatches(savedBoard, sqlSession);
				}
				// board delete
				cnt += boardDAO.deleteBoard(savedBoard, sqlSession);
				if(cnt>0) {
					if(attatchList!=null) { 
						// binary delete
						for(Attatch2VO attatch : attatchList) {
							FileUtils.deleteQuietly(
									new File(saveFolder, 
									attatch.getAtt_savename()));
						}
					}
					sqlSession.commit();
					result = ServiceResult.OK;
				}else {
					result = ServiceResult.FAILED;
				}
			}
		}else {
			result = ServiceResult.INVALIDPASSWORD;
		}
		return result;
	}

	@Override
	public Attatch2VO downloadAttatch(int att_no) {
		Attatch2VO attatch = attatchDAO.selectAttatch(att_no);
		if(attatch==null) throw new CommonException(att_no+"파일 없음.");
		attatchDAO.updateDowncount(att_no);
		return attatch;
	}

	@Override
	public ServiceResult incrementLike(int bo_no) {
		int cnt = boardDAO.updateBoLike(new Board2VO(bo_no));
		ServiceResult result = null;
		if(cnt>0) result = ServiceResult.OK;
		else result = ServiceResult.FAILED;
		return result;
	}

}
