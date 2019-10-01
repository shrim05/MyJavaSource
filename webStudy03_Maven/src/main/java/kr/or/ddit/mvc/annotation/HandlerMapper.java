package kr.or.ddit.mvc.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.utils.ReflectionUtils;

public class HandlerMapper implements IHandlerMapper {
	private static Logger logger = LoggerFactory.getLogger(HandlerMapper.class);
	
	public Map<URIMappingCondition, URIMappingInfo> handlerMap;
	
	
	public HandlerMapper(String[] basePackages) {
		handlerMap = new LinkedHashMap<>();
		List<Class<?>> classes = new ArrayList<Class<?>>();
		for(String basePackage : basePackages) {
			classes.addAll(ReflectionUtils.getClassesAtBasePackageWithAnnotation(basePackage.trim(), CommandHandler.class));
		}
		for(Class<?> tmp :classes) {
			List<Method> methods = ReflectionUtils.getMethodsAtClassWithAnnotation(tmp, URIMapping.class, 
					String.class, HttpServletRequest.class, HttpServletResponse.class);
			Object handler;
			try {
				handler = tmp.newInstance();
				for(Method method: methods) {
//					URIMappingCondition : URIMappingInfo
					URIMapping mapping = method.getAnnotation(URIMapping.class);
					URIMappingCondition key = new URIMappingCondition(mapping.value(), mapping.method());
					URIMappingInfo info = new URIMappingInfo(key, handler , method);
					handlerMap.put(key,info);
					logger.info("{} 핸들러 : {}", key, info);
				} 
			} catch (InstantiationException | IllegalAccessException e) {
				System.err.println(e.getMessage());
				continue;
			}
		}
	}


	@Override
	public URIMappingInfo findCommandHandler(HttpServletRequest req) {
		String uri = req.getRequestURI();
		uri = uri.substring(req.getContextPath().length());
		uri = uri.split(";")[0];
		HttpMethod method = HttpMethod.valueOf(req.getMethod().toUpperCase());
		URIMappingCondition key =  new URIMappingCondition(uri, method);
		return handlerMap.get(key);
	}

}
