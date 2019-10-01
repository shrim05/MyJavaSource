package kr.or.ddit.prod.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.mvc.annotation.CommandHandler;
import kr.or.ddit.mvc.annotation.HttpMethod;
import kr.or.ddit.mvc.annotation.URIMapping;
import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.vo.ProdVO;

@CommandHandler
public class ProdViewController {
	IProdService service = new ProdServiceImpl();
	
	@URIMapping(value="/prod/prodView.do", method=HttpMethod.GET)
	public String prodviewGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		String prod_id = req.getParameter("prod_id");
		if(StringUtils.isBlank(prod_id)) {
			resp.sendError(400);
			return null;
		}
		ProdVO pv = service.retrieveProd(prod_id);
		req.setAttribute("prod", pv);
		return "/prod/prodView";
	}
	
	
}
