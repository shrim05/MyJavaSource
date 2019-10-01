package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.annotation.CommandHandler;
import kr.or.ddit.mvc.annotation.URIMapping;
import kr.or.ddit.vo.MemberVO;


@CommandHandler
public class MyPageController extends HttpServlet {
	
	IMemberService service = MemberServiceImpl.getInstance();  
	@URIMapping("/mypage")		
	public String mypage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String viewName=null;
		if(session.isNew()) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		MemberVO authMember = (MemberVO)session.getAttribute("authMember");
		if(authMember==null) {
			String message = "마이페이지는 로그인이 필요함";
			session.setAttribute("message", message);
			viewName = "redirect:/login"; 
		}else {
			MemberVO savedMember = service.retrieveMember(authMember);
			request.setAttribute("savedMember", savedMember);
			viewName = "member/mypage";
		}
		return viewName;
		
	}
	

}
