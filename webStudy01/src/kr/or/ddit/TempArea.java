package kr.or.ddit;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import kr.or.ddit.vo.MemberVO;

public class TempArea {
	public static void main(String[] args) {

//		Class<MemberVO> tmpType = MemberVO.class;
//		Method[] md= tmpType.getDeclaredMethods();
////		for(Method m : md) {
////			System.out.println(m.getName());
////		}
////		
//		Method[] m2 = MemberVO.class.getDeclaredMethods();
//		PropertyDescriptor pd;
//		try {
//			pd = new PropertyDescriptor("mem_id", tmpType);
//			System.out.println(pd.getReadMethod().getName());
//		} catch (IntrospectionException e) {
//			e.printStackTrace();
//		}
////		for(Method m : m2) {
////			System.out.println(m.getName());
////		}
		
		MemberVO mv = new MemberVO();
		MemberVO mv2 = new MemberVO();
		mv.setMem_id("tm");
		Class<MemberVO> voType = MemberVO.class;
		Field[] fds = voType.getDeclaredFields();
		for(Field tmp : fds) {
			String name = tmp.getName();
			try {
				PropertyDescriptor pd = new PropertyDescriptor(name, voType);
				Method getter = pd.getReadMethod();
				Method setter = pd.getWriteMethod();
				setter.invoke(mv2, getter.invoke(mv));
				
			} catch (IntrospectionException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(mv2.getMem_id());
		
		
	}
}
