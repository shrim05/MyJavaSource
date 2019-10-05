package kr.or.ddit.filter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 인증형 서비스를 요청하는 경우
 * 현재 요청을 발생시킨 유저의 인증 여부를 확인
 * 
 */
public class AuthentificationFilter implements Filter{
	private Map<String,String[]> securedMap; 
	public static final String ATTRNAME = "securedMap";
	private String securedPath;
	private static Logger logger = LoggerFactory.getLogger(AuthentificationFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		securedPath = filterConfig.getInitParameter("securedPath");
		Properties props = new Properties();
		try(
				InputStream is = getClass().getResourceAsStream(securedPath);
			){
				props.loadFromXML(is);
		} catch (IOException e) {
			throw new ServletException(e);
		}
		securedMap = new HashMap<String, String[]>();
		Iterator<Object> it = props.keySet().iterator();
		while (it.hasNext()) {
			String uri = (String) it.next();
			String value = props.getProperty(uri).trim();
			String[] roles = value.split(",");
			Arrays.sort(roles);
			securedMap.put(uri,roles);
			logger.info("인가정보 - {}:{}",uri,Arrays.toString(roles));
		}
		filterConfig.getServletContext().setAttribute(ATTRNAME, securedMap);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		uri = uri.substring(req.getContextPath().length());
		uri = uri.split(";")[0];
		boolean pass = true;
		if(securedMap.containsKey(uri)) {
			Object authMember = req.getSession().getAttribute("authMember");
			if(authMember==null) {
				pass = false;
			}
			
		}
		if(pass) {
			chain.doFilter(request, response);
		}else {
			req.getSession().setAttribute("message","인증형 서비스는 로그인이 필요합니다");
			resp.sendRedirect(req.getContextPath()+"/login");
		}
	}

	@Override
	public void destroy() {
		
	}

}
