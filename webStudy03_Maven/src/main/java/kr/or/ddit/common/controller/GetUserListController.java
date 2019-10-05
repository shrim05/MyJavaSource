package kr.or.ddit.common.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.mvc.annotation.CommandHandler;
import kr.or.ddit.mvc.annotation.URIMapping;
import kr.or.ddit.vo.MemberVO;

@CommandHandler
public class GetUserListController  {
	
	@URIMapping("/getUserList.do")
	public String getuserList(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		Set<MemberVO> userList = (Set<MemberVO>) req.getServletContext().getAttribute("userList");
		resp.setContentType("application/json; charset=UTF-8");
		ObjectMapper mapper = new ObjectMapper();
		try(PrintWriter out = resp.getWriter()){
			mapper.writeValue(out, userList);
		}
		return null;
	}
}
