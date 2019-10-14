package kr.or.ddit.board.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.enums.ServiceResult;
import kr.or.ddit.mvc.annotation.CommandHandler;
import kr.or.ddit.mvc.annotation.HttpMethod;
import kr.or.ddit.mvc.annotation.URIMapping;
import kr.or.ddit.vo.Board2VO;

@CommandHandler
public class BoardDeleteController {
	IBoardService service = new BoardServiceImpl();
	@URIMapping(value="/board/boardDelete.do", method=HttpMethod.POST)
	public String boardView(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String bo_noParam = req.getParameter("bo_no");
		String bo_pass = req.getParameter("bo_pass");
		if(!StringUtils.isNumeric(bo_noParam) || StringUtils.isBlank(bo_pass)) {
			resp.sendError(400);
			return null;
		}
		ServiceResult result = service.removeBoard(new Board2VO(Integer.parseInt(bo_noParam), bo_pass));
		String viewName = "redirect:/board/boardView.do?what="+bo_noParam;
		String message = null;
		switch (result) {
			case INVALIDPASSWORD:
				message = "비번 오류";
				break;
			case FAILED:
				message = "서버 오류";
				break;
	
			default:
				viewName = "redirect:/board/boardList.do";
				break;
		}
		req.getSession().setAttribute("message", message);
		return viewName;
	}
}



