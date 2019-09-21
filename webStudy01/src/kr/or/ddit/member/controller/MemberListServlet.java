package kr.or.ddit.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.utils.MarshallingUtils;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/member/memberList.do")
public class MemberListServlet extends HttpServlet {
	IMemberService service;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accept = request.getHeader("Accept");
		service = MemberServiceImpl.getInstance();
		List<MemberVO> lmv = service.retrieveMemberList();
		if(accept.contains("json")) {
			response.setContentType("application/json;charset=UTF-8");
			String json = new MarshallingUtils().marshallingListToJson(lmv);
			try(
					PrintWriter out = response.getWriter();
			){
				out.print(json);
			}
		}else {
			String viewName ="/WEB-INF/views/member/memberList.jsp";
			request.getRequestDispatcher(viewName).forward(request, response);
		}
		
	}
}
