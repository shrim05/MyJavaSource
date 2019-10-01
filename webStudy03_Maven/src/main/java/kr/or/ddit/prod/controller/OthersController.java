package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.Marshaller;

import kr.or.ddit.mvc.annotation.CommandHandler;
import kr.or.ddit.mvc.annotation.URIMapping;
import kr.or.ddit.prod.dao.IOtherDAO;
import kr.or.ddit.prod.dao.OthersDAOImpl;
import kr.or.ddit.utils.MarshallingUtils;
import kr.or.ddit.vo.BuyerVO;

@CommandHandler
public class OthersController {
	IOtherDAO othersDAO = new OthersDAOImpl();
	@URIMapping(value="/prod/getLprodList.do")
	public String getLprodListForAjax(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<Map<String,Object>> lprodList = othersDAO.selectLprodList();
		resp.setContentType("application/json ; charset=UTF-8");
		String json = new MarshallingUtils().marshallingListToJson(lprodList);
		try(
			PrintWriter out = resp.getWriter();
		){
			out.println(json);
		}
		return null;
	}
	
	@URIMapping(value="/prod/getBuyerList.do")
	public String getBuyerListForAjax(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<BuyerVO> buyerList = othersDAO.selectBuyerList(null);
		resp.setContentType("application/json ; charset=UTF-8");
		String json = new MarshallingUtils().marshallingListToJson(buyerList);
		try(
			PrintWriter out = resp.getWriter();
		){
			out.println(json);
		}
		return null;
	}
}
