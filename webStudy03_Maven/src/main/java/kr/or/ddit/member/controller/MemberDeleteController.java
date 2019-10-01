package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.enums.ServiceResult;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.annotation.CommandHandler;
import kr.or.ddit.mvc.annotation.HttpMethod;
import kr.or.ddit.mvc.annotation.URIMapping;
import kr.or.ddit.vo.MemberVO;

@CommandHandler
public class MemberDeleteController {
	IMemberService service = MemberServiceImpl.getInstance();
	
	@URIMapping(value="/member/memberDelete.do", method=HttpMethod.POST)
	public String doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO authMember = (MemberVO)session.getAttribute("authMember");
		String password = request.getParameter("password");
		if(session.isNew() || authMember==null||StringUtils.isBlank(password)) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		String viewName=null;
		MemberVO member = new MemberVO(authMember.getMem_id(),password);
		viewName = "/login"; 
		String message = null;
		ServiceResult result = service.removeMember(member);
		switch(result) {
		case INVALIDPASSWORD:
			message ="비번오류";
			viewName = "/mypage";
			session.setAttribute("message", message);
			break;
		case FAILED:
			message = "서버오류";
			viewName = "/mypage";
			session.setAttribute("message", message);
			break;
		default:
			viewName = "/";
			session.invalidate();
			break;
		}
		String tmp = "redirect:";
		return tmp+viewName;
	}
}
