package kr.or.ddit.servlet01;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet이란 
 * : 웹상에서 동작할 수 있는 자바 객체에 대한 모든 정의를 가진 스펙.
 * 서블릿 스펙에 따라 모듈을 개발하는 단계(전형적인 방법-이클립스없이 할때)
 * 1. HttpServlet 하위 구현체 정의
 * 		: 필요한 callback 메소드 overriding
 * 		 callback 메소드란 : 특정 이벤트가 발생한 경우 , 시스템에 의해 자동 호출되는 구조
 * 2. 컴파일 -> 해당 컨텍스트의 classpath에 배치 (/WEB-INF/classes)
 * 
 * 3. web.xml 에 등록 / 매핑
 * 		@WebServlet(servlet 3.0 이후부터 어노테이션 맵핑 지원)
 * 		**등록 설정 종류
 *		1)loadOnStartUp : 기본적으로 최초 요청 시 객체 생성하지만, 
 *			해당 설정해주면 설정된 순서에 따라 서버가 구동되면 자동으로 서블릿 객체가 생성됨
 *		2) init-param : 서블릿 객체 생성 후 초기화 시점에 파라미터를 전달
 *		
 * 4. 서버(WAS, Servlet Container)를 재구동 
 * 
 * ** 서블릿 콜백 메소드 종류
 * 1. lifecycle callback : 생명주기안에서 단 한번씩만 실행되는 메서드(생성시 init, 소멸시 destroy)
 *  (destroy 메서드는 서버를 끄더라도 실행된다는 보장이 없음)
 * 2. request callback : template method pattern (SOLID S:단일책임
 * 		1) service : 요청을 받고, 요청의 조건(request method)를 판단하여, 해당 callback(doXXX) 메소드를 호출하는 역할
 * 		(template method) 
 * 		(do 계열의 메서드를 실행시켜주는 역할)
 * 
 * 		2) doXXX : 단일책임의 원칙을 적용하여 메소드 구조를 분리함.
 * 		(hook method)
 *
 * 	** Servlet Container (Web Application Server, tomcat)
 * 		: Servlet 의 lifecycle를 관리하며, 매핑된 요청이 발생하면 해당 서블릿의 콜백을 호출하여 요청에 대한 처리를 하는 주체
 * 
 *  ** JSP Container(WAS, tomcat)
 * 		: JSP 의 lifecycle를 관리하며, 매핑된 요청이 발생하면 해당 서블릿의 콜백을 호출하여 요청에 대한 처리를 하는 주체
 *  
 */
//@WebServlet("/desc")
public class DescriptionServlet extends HttpServlet{
	@Override
	public void destroy() {
		super.destroy();
		System.out.printf("%s 객체 소멸", getClass().getName());
	}
	
	public DescriptionServlet() {
		super();
		System.out.printf("%s 생성\n", this.getClass().getName());
	}
	
	String paramValue;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		paramValue = config.getInitParameter("param");
	}
	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println(getServletContext().hashCode());
		System.out.println("Service메서드 실행 시작");
		super.service(arg0, arg1);
		System.out.println("Service메서드 실행 종료");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.printf("%s 쓰레드 실행중\n", Thread.currentThread().getName());
		System.out.printf("%s => 전달된 초기화 파라미터 값\n", paramValue);
	}
	
}
