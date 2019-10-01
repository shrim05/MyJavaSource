package kr.or.ddit.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewProcessor implements IViewProcessor {
	private String prefix;
	private String suffix;
	private static final String REDIRECT= "redirect:";
	@Override
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	@Override
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	@Override
	public void viewProcess(String viewName, HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		if(viewName.startsWith(REDIRECT)) {
			viewName = viewName.substring(REDIRECT.length());
			resp.sendRedirect(req.getContextPath()+viewName);
		}else {
			req.getRequestDispatcher(prefix+viewName+suffix).forward(req, resp);;
		}
	}

}
