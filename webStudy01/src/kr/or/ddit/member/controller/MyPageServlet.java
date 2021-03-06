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
import kr.or.ddit.vo.MemberVO;


@WebServlet("/mypage")
public class MyPageServlet extends HttpServlet {
	
	IMemberService service = MemberServiceImpl.getInstance();  
			
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.isNew()) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		MemberVO authMember = (MemberVO)session.getAttribute("authMember");
		String viewName=null;
		boolean redirect = false;
		if(authMember==null) {
			String message = "마이페이지는 로그인이 필요함";
			session.setAttribute("message", message);
			viewName = "/login"; 
			redirect =true;
		}else {
			MemberVO savedMember = service.retrieveMember(authMember);
			request.setAttribute("savedMember", savedMember);
			viewName = "member/mypage";
		}
		if(redirect) {
			response.sendRedirect(request.getContextPath()+viewName);
		}else {
			String prefix = "/WEB-INF/views/";
			String suffix = ".jsp";
			viewName = prefix + viewName + suffix;
			request.getRequestDispatcher(viewName).forward(request, response);
		}
	}

}
