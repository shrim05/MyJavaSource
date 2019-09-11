package kr.or.ddit.servlet03;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.member.exception.NotAuthenticatedException;
import kr.or.ddit.member.exception.UserNotFoundException;
import kr.or.ddit.member.service.AuthenticateServiceImpl;
import kr.or.ddit.member.service.IAuthenticateService;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/login")
public class LoginControllerServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewName = "/WEB-INF/views/login/loginForm.jsp";
		request.getRequestDispatcher(viewName).forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mem_id = request.getParameter("mem_id");
		String mem_pass = request.getParameter("mem_pass");
		HttpSession session = request.getSession(false);
		if(StringUtils.isBlank(mem_id)||StringUtils.isBlank(mem_pass)) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST,"아이디나 비번 누락");
			return;
		}
		try {
			IAuthenticateService service = new AuthenticateServiceImpl();
			MemberVO savedMember = service.authenticate(new MemberVO(mem_id,mem_pass));
			session.setAttribute("authMember", savedMember);
			//이동 방식 => 해당 리퀘스트 객체 활용 끝났으니 redirect
			response.sendRedirect(request.getContextPath()+"/");
		}catch(UserNotFoundException | NotAuthenticatedException e) {
			session.setAttribute("message", e.getMessage());
			//이동방식 (인증절차이므로 기존 request 삭제)
			response.sendRedirect(request.getContextPath()+"/login");
			//메세지 전달 방식
		}
		//아이디와 비번일 동일하면 성공
		//getSession(false) -> 세션이 있으면 session 리턴 없으면 null
		//getSession() -> 없으면 session 만들어서 반환
		//ui먼저 호출되기 때문에 정상적으로 로그인 절차를 거쳤다면 이미 session 이 만들어져있음. 
		if(session==null || session.isNew()) {
			response.sendError(400,"로그인 절차 문제");
			return;
		}
	}
}
