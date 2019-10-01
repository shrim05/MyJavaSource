package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.enums.ServiceResult;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/member/memberInsert.do")
public class MemberInsertServlet extends HttpServlet{
   IMemberService service = MemberServiceImpl.getInstance();
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req.getRequestDispatcher("/WEB-INF/views/member/memberForm.jsp").forward(req, resp);
   }
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   
      req.setCharacterEncoding("UTF-8");
      MemberVO member = new MemberVO();

      req.setAttribute("member", member);
   
      try {
         BeanUtils.populate(member, req.getParameterMap());
      } catch (IllegalAccessException | InvocationTargetException e) {
         throw new RuntimeException(e);
      }
      
      Map<String, String> errors = new HashMap<String, String>();
      
      req.setAttribute("errors", errors);
      
      boolean valid = validate(member, errors);
      String viewName = "member/memberForm";
      String message = null;
      boolean redirect = false;
      
      if(valid) {
         ServiceResult result = service.createMember(member);
         switch (result) {
         case PKDUPLICATED:
            message = "아이디 중복";
            viewName = "member/memberForm";
            break;
         case FAILED:
            message = "서버 오류";
            viewName = "member/memberForm";
            break;
         default:
            message = "회원가입 성공";
            redirect = true;
            viewName = "/";
            break;
         }
      }else {
         viewName = "member/memberForm";
      }
      
      req.setAttribute("message", message);
      
      if(redirect) {
         resp.sendRedirect(req.getContextPath()+viewName);
      }else {
         String prefix = "/WEB-INF/views/";
         String suffix = ".jsp";
         viewName = prefix + viewName + suffix;
         req.getRequestDispatcher(viewName).forward(req, resp);
      }
   }

   private boolean validate(MemberVO member, Map<String, String> errors) {
      boolean valid = true;
      if (StringUtils.isBlank(member.getMem_id())) {
         valid = false;
         errors.put("mem_id", "회원아이디 누락");
      }
      if (StringUtils.isBlank(member.getMem_pass())) {
         valid = false;
         errors.put("mem_pass", "비밀번호 누락");
      }
      if (StringUtils.isBlank(member.getMem_name())) {
         valid = false;
         errors.put("mem_name", "이름 누락");
      }
      if (StringUtils.isBlank(member.getMem_zip())) {
         valid = false;
         errors.put("mem_zip", "우편번호 누락");
      }
      if (StringUtils.isBlank(member.getMem_add1())) {
         valid = false;
         errors.put("mem_add1", "주소1 누락");
      }
      if (StringUtils.isBlank(member.getMem_add2())) {
         valid = false;
         errors.put("mem_add2", "주소2 누락");
      }
      if (StringUtils.isBlank(member.getMem_mail())) {
         valid = false;
         errors.put("mem_mail", "이메일 누락");
      }
      return valid;
   }
}