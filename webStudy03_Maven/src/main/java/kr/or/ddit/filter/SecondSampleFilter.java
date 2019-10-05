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


public class SecondSampleFilter implements Filter{
	private static Logger logger = LoggerFactory.getLogger(SecondSampleFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("{} 필터생성", getClass().getSimpleName());
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//요청 필터링 (chain.doFilter 메서드 이전)
		HttpServletRequest req = (HttpServletRequest) request;
		logger.info("{} 에서 요청 필터링",getClass().getSimpleName());
		chain.doFilter(request, response);
		//응답필터링
		logger.info("{} 에서 응답 필터링",getClass().getSimpleName());
	}

	@Override
	public void destroy() {
		logger.info("{} 필터소멸", getClass().getSimpleName());
		
	}

	
}
