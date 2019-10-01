package kr.or.ddit.mvc.annotation;

import java.lang.reflect.Method;

public class URIMappingInfo {
	private URIMappingCondition mappingCondition;
	private Object commandHandler;
	private Method handlerMethod;

	public URIMappingInfo(URIMappingCondition mappingCondition, Object commandHandler, Method handlerMethod) {
		super();
		this.mappingCondition = mappingCondition;
		this.commandHandler = commandHandler;
		this.handlerMethod = handlerMethod;
	}

	public URIMappingCondition getMappingCondition() {
		return mappingCondition;
	}

	public Object getCommandHandler() {
		return commandHandler;
	}

	public void setHandlerMethod(Method handlerMethod) {
		this.handlerMethod = handlerMethod;
	}
	

	public Method getHandlerMethod() {
		return handlerMethod;
	}

	@Override
	public String toString() {
		return "URIMappingInfo [mappingCondition=" + mappingCondition + ", commandHandler=" + commandHandler.getClass().getName()
				+ "." + handlerMethod.getName() + "]";
	}

	
	
}
