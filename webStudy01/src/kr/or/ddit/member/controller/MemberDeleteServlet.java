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
import kr.or.ddit.vo.MemberVO;

@WebServlet("/member/memberDelete.do")
public class MemberDeleteServlet extends HttpServlet {
	IMemberService service = MemberServiceImpl.getInstance();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO authMember = (MemberVO)session.getAttribute("authMember");
		String password = request.getParameter("password");
		if(session.isNew() || authMember==null||StringUtils.isBlank(password)) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
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
		response.sendRedirect(request.getContextPath()+viewName);
	}
}
