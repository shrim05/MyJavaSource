package kr.or.ddit.alba.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.alba.service.AlbaServiceImpl;
import kr.or.ddit.alba.service.IAlbaService;
import kr.or.ddit.enums.ServiceResult;
import kr.or.ddit.mvc.annotation.CommandHandler;
import kr.or.ddit.mvc.annotation.URIMapping;

@CommandHandler
public class AlbaDeleteController{
	IAlbaService service = new AlbaServiceImpl();
	@URIMapping("/alba/albaDelete.do")
	public String doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String who = req.getParameter("who");
		if(StringUtils.isBlank(who)){
			resp.sendError(400);
			return null;
		}
		String view = "/alba/albaView.do";
		ServiceResult result = service.removeAlba(who);
		if(ServiceResult.OK.equals(result)){
			view = "redirect:/alba/albaList.do";
		}else{
			req.getSession().setAttribute("message", "삭제 실패, 다시 하라.");
			view = "redirect:/alba/albaView.do?who="+who;
		}
		
		return view;
	}
}
