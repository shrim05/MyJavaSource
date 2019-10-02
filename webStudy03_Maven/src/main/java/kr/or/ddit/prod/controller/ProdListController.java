package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.mvc.annotation.CommandHandler;
import kr.or.ddit.mvc.annotation.URIMapping;
import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.vo.PagingInfoVO;
import kr.or.ddit.vo.ProdVO;
//POJO
@CommandHandler
public class ProdListController {
	private static Logger logger = LoggerFactory.getLogger(ProdListController.class); 
	IProdService service = new ProdServiceImpl();
	@URIMapping(value="/prod/prodList.do")
	public String prodList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ProdVO searchVO = new ProdVO();
		try {
			BeanUtils.populate(searchVO, req.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			logger.error("검색 중 문제 발생",e);
		}
		String pageParam = req.getParameter("page");
		int currentPage = 1;
		if(StringUtils.isNumeric(pageParam)) {
			currentPage = Integer.parseInt(pageParam);
		}
		PagingInfoVO<ProdVO> pagingVO = new PagingInfoVO<>(5,3);
		pagingVO.setSearchVO(searchVO);
		int totalRecord = service.retrieveProdCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		pagingVO.setCurrentPage(currentPage);
		List<ProdVO> lpv = service.retrieveProdList(pagingVO);
		pagingVO.setDataList(lpv);
		if(lpv==null) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		req.setAttribute("pagingVO", pagingVO);
		
		return "/prod/prodList";
	}
}
