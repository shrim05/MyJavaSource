package kr.or.ddit.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IViewProcessor {
	public void setPrefix(String prefix);
	public void setSuffix(String suffix);
	/**
	 * @param viewName : viewName이 "redirect"으로 시작하면 redirect 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	public void viewProcess(String viewName, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException;
	
}

