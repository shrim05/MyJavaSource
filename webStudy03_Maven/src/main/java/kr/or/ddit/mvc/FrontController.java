package kr.or.ddit.mvc;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.mvc.annotation.HandlerInvoker;
import kr.or.ddit.mvc.annotation.HandlerMapper;
import kr.or.ddit.mvc.annotation.IHandlerInvoker;
import kr.or.ddit.mvc.annotation.IHandlerMapper;
import kr.or.ddit.mvc.annotation.URIMappingInfo;

public class FrontController extends HttpServlet {
	private IHandlerMapper handlerMapper;
	private IHandlerInvoker handlerInvoker;
	private IViewProcessor viewProcessor;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String packages = config.getInitParameter("basePackages");
		String[] basePackages = packages.split("\\s+");
		handlerMapper = new HandlerMapper(basePackages);
		handlerInvoker = new HandlerInvoker();
		viewProcessor = new ViewProcessor();
		viewProcessor.setPrefix(config.getInitParameter("prefix"));
		viewProcessor.setSuffix(config.getInitParameter("suffix"));
	}
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		URIMappingInfo handlerInfo =null;
		try {
			handlerInfo = handlerMapper.findCommandHandler(req);
		}catch(IllegalArgumentException e) {
			resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, e.getMessage());
			return;
		}
		if(handlerInfo==null) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND, "제공하지 않는 서비스임");
			return;
		}
		String viewName = null;
		try {
			viewName = handlerInvoker.invokeHandler(handlerInfo, req, resp);
			if(viewName==null && !resp.isCommitted()) {
				resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"viewName이 없음");
				return;
			}else if(viewName!=null) {
				viewProcessor.viewProcess(viewName, req, resp);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}
	
}
