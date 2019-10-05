package kr.or.ddit.member.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.enums.ServiceResult;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.annotation.CommandHandler;
import kr.or.ddit.mvc.annotation.HttpMethod;
import kr.or.ddit.mvc.annotation.URIMapping;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.wrapper.MultipartRequestWapper;
import kr.or.ddit.wrapper.PartWrapper;

@CommandHandler
public class MemberUpdateController extends HttpServlet {
	IMemberService service = MemberServiceImpl.getInstance();
	@URIMapping(value="/member/memberUpdate.do", method=HttpMethod.POST)
	public String updatePost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		ServiceResult result = null;
		MemberVO mv = new MemberVO();
		HttpSession session = req.getSession();
		try {
			BeanUtils.populate(mv, req.getParameterMap());
//			result = service.modifyMember(mv);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		 if(req instanceof MultipartRequestWapper) {
	    	  PartWrapper partWrapper =  ((MultipartRequestWapper) req).getPartWrapper("mem_image");
	    	  if(partWrapper !=null) {
	    		  mv.setMem_img(partWrapper.getBytes());
	    	  }
	      }
	      
		//2. 분석
		Map<String, String> errors = new HashMap<String, String>();
		boolean valid = validate(mv, errors);
		String viewName="/mypage";
		String message = null;
		if(valid) {
			ServiceResult result = service.modifyMember(mv);
			switch(result) {
			case INVALIDPASSWORD:
				message = "비번오류";
				break;
			case FAILED:
				message = "서버오류";
				break;
			default:
				message = "수정성공";
				break;
			}
		}else {
			
		}
		session.setAttribute("message", message);
		session.setAttribute("errors", errors);
		return "redirect:"+viewName;
//		if(result.equals(ServiceResult.OK)) {
//			session.setAttribute("message", "수정완료");
//		}else if(result.equals(ServiceResult.FAILED)) {
//			session.setAttribute("message", "수정실패, 재시도 또는 관리자 연락");
//		}else if(result.equals(ServiceResult.INVALIDPASSWORD)) {
//			session.setAttribute("message", "비밀번호 틀림");
//		}
//		String viewName=req.getContextPath()+"/mypage";
//		resp.sendRedirect(viewName);
		
	}

	private boolean validate(MemberVO member, Map errors) {
		boolean valid = true;
		if(StringUtils.isBlank(member.getMem_id())){ valid  = false; errors.put("mem_id","회원아이디누락"); }
		if(StringUtils.isBlank(member.getMem_pass())){ valid  = false; errors.put("mem_pass","패스워드누락"); }
		if(StringUtils.isBlank(member.getMem_name())){ valid  = false; errors.put("mem_name","이름누락"); }
		if(StringUtils.isBlank(member.getMem_zip())){ valid  = false; errors.put("mem_zip","우편번호누락"); }
		if(StringUtils.isBlank(member.getMem_add1())){ valid  = false; errors.put("mem_add1","주소1누락"); }
		if(StringUtils.isBlank(member.getMem_add2())){ valid  = false; errors.put("mem_add2","주소2누락"); }
		if(StringUtils.isBlank(member.getMem_mail())){ valid  = false; errors.put("mem_mail","이메일누락"); }
		return valid;
	}
}
//1. 요청받고

//3-1. 통과
//1) 의존성
//2) 로직선택 (ServiceResult modifyMember(memberVO)
// session scope에 메세지 설정
//	-exception(런타임에러->was서버에서 처리가능. 내가 처리안해도 500에러 발생), 
//	-invalidpassword(:redirect ->mypage +msg) , ok(redirect->mypage +msg), failed (dispatch->mypage +msg)
//3-2. 검증 통과안될때