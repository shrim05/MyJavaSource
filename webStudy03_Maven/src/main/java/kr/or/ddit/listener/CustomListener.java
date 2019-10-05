package kr.or.ddit.listener;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import kr.or.ddit.vo.MemberVO;

@WebListener
public class CustomListener implements ServletContextListener, HttpSessionAttributeListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		Set<MemberVO> userList = new HashSet<>();
		sce.getServletContext().setAttribute("userList", userList);
		sce.getServletContext().setAttribute("cPath", sce.getServletContext().getContextPath());
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		//접속자 리스트(로그인 add, 로그아웃 remove)
		String attrname = event.getName();
		if(!"authMember".equals(attrname)) return;
		ServletContext application =  event.getSession().getServletContext();
		Set<MemberVO> userList = (Set<MemberVO>) application.getAttribute("userList");
		MemberVO authMember = (MemberVO) event.getValue();
		userList.add(authMember);
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		//접속자 리스트(로그인 add, 로그아웃 remove)
		String attrname = event.getName();
		if(!"authMember".equals(attrname)) return;
		ServletContext application =  event.getSession().getServletContext();
		Set<MemberVO> userList = (Set<MemberVO>) application.getAttribute("userList");
		MemberVO authMember = (MemberVO) event.getValue();
		userList.remove(authMember);
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}


}
