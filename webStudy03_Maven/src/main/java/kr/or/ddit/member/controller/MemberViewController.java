package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.annotation.CommandHandler;
import kr.or.ddit.mvc.annotation.URIMapping;
import kr.or.ddit.vo.MemberVO;

@CommandHandler
public class MemberViewController {
   IMemberService service = MemberServiceImpl.getInstance();
   
   @URIMapping("/member/memberView.do")
   public String memberView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String who = req.getParameter("who");
      if(StringUtils.isBlank(who)) {
         resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "누구를 조회함?");
         return null;
      }
      MemberVO saved = service.retrieveMember(new MemberVO(who, null));
      
      req.setAttribute("member", saved);
      
      String viewName = "member/memberView";
      return viewName;
      
   }
}