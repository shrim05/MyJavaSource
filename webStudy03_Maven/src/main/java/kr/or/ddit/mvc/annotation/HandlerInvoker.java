package kr.or.ddit.mvc.annotation;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandlerInvoker implements IHandlerInvoker {

	@Override
	public String invokeHandler(URIMappingInfo mappingInfo, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Object handler = mappingInfo.getCommandHandler();
		Method handlerMtd = mappingInfo.getHandlerMethod();
		String logicalViewName = (String) handlerMtd.invoke(handler,req,resp);
		return logicalViewName;
	}

}
