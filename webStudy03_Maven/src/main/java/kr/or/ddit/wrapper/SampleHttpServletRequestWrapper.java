package kr.or.ddit.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class SampleHttpServletRequestWrapper extends HttpServletRequestWrapper{

	public SampleHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		if("who".equals(name)) {
			return "b001";
		}
		return super.getParameter(name);
	}
}
