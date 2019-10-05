package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.wrapper.MultipartRequestWapper;

public class MultipartRequestCheckFilter implements Filter {
	private static Logger logger = LoggerFactory.getLogger(MultipartRequestCheckFilter.class);
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("{} 필터 생성", getClass().getSimpleName());

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		//1. 파일 업로드 여부 확인
		String bodyMime = req.getContentType();
		if(bodyMime!=null && bodyMime.startsWith("multipart")) {
			//2. 업로드된 파일에 대한 전처리 담당 Wrapper 생성
			MultipartRequestWapper requestWrapper = new MultipartRequestWapper(req);
			chain.doFilter(requestWrapper, response);
		}else {
			chain.doFilter(request, response);
		}
		
	}

	@Override
	public void destroy() {
		logger.info("{} 필터 생성", getClass().getSimpleName());

	}

}
