package kr.or.ddit.utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ClassUtils;

/**
 * Marshalling : 특정언어로 표현된 데이터(java object) 를 범용 방식(xml/json)으로 변환하는 작업.
 * 
 */
public class MarshallingUtils {
	public String marshalling(Object target) {
		//기본형은 값만 가지고 있는 형태는 마샬링 안됨
		if(ClassUtils.isPrimitiveWrapper(target.getClass())||CharSequence.class.isAssignableFrom(target.getClass())) {
			throw new IllegalArgumentException("변환불가 타입 데이터");
		}
		
		return marshallingObjectToJson(target);
	}

	private String marshallingObjectToJson(Object target) {
		//"문자열", 42, true ,'c' , {}.[] 
		if(target==null) return null;
		Class<?> targetType = target.getClass();
		String value = null;
		if(CharSequence.class.isAssignableFrom(targetType)||
				ClassUtils.isAssignable(targetType, Character.class, true)) {
			value = String.format("\"%s\"", target);
		}else if(ClassUtils.isPrimitiveOrWrapper(targetType)) {
			value = target.toString();
		}else if(targetType.isArray()) {
//			Object[] array = (Object[]) target;
			value = marshallingArrayToJson(target);
		}else if(target instanceof List) {
			value = marshallingListToJson(target);
		}else if(target instanceof Map) {
			Map map =(Map)target;
			value = marshallingMapToJson(map);
		}else {
			StringBuffer json = new StringBuffer("{");
			Field[] fields = targetType.getDeclaredFields();
			for(Field tmp:fields) {
				String name = tmp.getName();
				try {
					PropertyDescriptor pd = new PropertyDescriptor(name, targetType);
					Object propValue = pd.getReadMethod().invoke(target);
					json.append(
					String.format(PROPERTYPATTERN, name, marshallingObjectToJson(propValue))
					);
				} catch (IntrospectionException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					System.err.println(e.getMessage());
					continue;
				}
			}
			int lastIndex = json.lastIndexOf(",");
			if(lastIndex==json.length()-1) {json.deleteCharAt(lastIndex);}
			value = json.append("}").toString();
		}
		return value;
	}
	private final String PROPERTYPATTERN = "\"%s\":%s,";
	
	private String marshallingMapToJson(Map map) {
		if (map==null)return null;
		Iterator keys =  map.keySet().iterator();
		StringBuffer json = new StringBuffer("{") ;
		while(keys.hasNext()) {
			Object key = (Object) keys.next();
			Object value = map.get(key);
			json.append(String.format(PROPERTYPATTERN, key, marshallingObjectToJson(value)));
		}
		int lastIndex = json.lastIndexOf(",");
		if(lastIndex==json.length()-1) {
			json.deleteCharAt(lastIndex);
		}
		json.append("}");
		return json.toString();
	}
	
	public String marshallingArrayToJson(Object array) {
		StringBuffer json = new StringBuffer("[");
		if(array!=null) {
			int length = Array.getLength(array);
			for (int i = 0; i < length; i++) {
				json.append(marshallingObjectToJson(Array.get(array, i))+",");
			}
			int lastIndex = json.lastIndexOf(",");
			if(lastIndex==json.length()-1) {
				json.deleteCharAt(lastIndex);
			}
		}
		json.append("]");
		return json.toString();
	}
	public String marshallingListToJson(Object target) {
		StringBuffer json = new StringBuffer("[");
		if(target!=null) {
			List list = (List) target;
			Object[] array = list.toArray();
			int length = Array.getLength(array);
			for (int i = 0; i < length; i++) {
				json.append(marshallingObjectToJson(list.get(i))+",");
			}
			int lastIndex = json.lastIndexOf(",");
			if(lastIndex==json.length()-1) {
				json.deleteCharAt(lastIndex);
			}
		}
		json.append("]");
		return json.toString();
	}
}
