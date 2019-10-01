package kr.or.ddit.utils;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReflectionUtils {
	
	public static List<Method> getMethodsAtClassWithAnnotation(Class<?> clz, Class<? extends Annotation> annotationType, Class<?> returnType, Class<?>...parameterTypes) {
		List<Method> mtdList = getMethodsAtClass(clz, returnType, parameterTypes);
		for(int idx=mtdList.size()-1; idx>=0; idx--) {
			Annotation annotation = mtdList.get(idx).getAnnotation(annotationType);
			if(annotation==null) mtdList.remove(idx);
		}
		return mtdList;
	}
	
	public static List<Method> getMethodsAtClass(Class<?> clz, Class<?> returnType, Class<?>...parameterTypes){
		Method[] methods = clz.getDeclaredMethods();
		List<Method> mtdList = new ArrayList<Method>();
		for(Method tmp : methods) {
			Class<?> retType = tmp.getReturnType();
			Class<?>[] paramTypes = tmp.getParameterTypes();
			if((retType==null || retType.equals(returnType)) && 
				 (paramTypes==null || Arrays.deepEquals(paramTypes, parameterTypes))) {
				mtdList.add(tmp);
			}
		}
		return mtdList;
	}
	
	public static List<Class<?>> getClassesAtBasePackageWithAnnotation(String basePackage, Class<? extends Annotation> annotationType){
		List<Class<?>> clzList = getClassesAtBasePackage(basePackage);
		List<Class<?>> clzListWithAnnotation = new ArrayList<Class<?>>();
		for(Class<?> tmp : clzList) {
			Annotation annotation = tmp.getAnnotation(annotationType);
			if(annotation!=null) clzListWithAnnotation.add(tmp);
		}
		return clzListWithAnnotation;
	}
	public static List<Class<?>> getClassesAtBasePackage(String basePackage){
		ClassLoader classLoader = ReflectionUtils.class.getClassLoader();
		String classpathRelativePath = basePackage.replaceAll("\\.", "/");
		URL basePackageURL =  classLoader.getResource(classpathRelativePath);
		URL classPathURL = classLoader.getResource("");
		File classPath = new File(classPathURL.getFile());
		try {
			Path start = Paths.get(basePackageURL.toURI()); 
			List<File> listFiles = new ArrayList<File>();
			Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					if(file.getFileName().toString().endsWith(".class")) {
						listFiles.add(new File(file.toString()));
					}
					return super.visitFile(file, attrs);
				}
			});
			List<Class<?>> clzList = new ArrayList<Class<?>>();
			for(File tmp : listFiles) {
				String tempPath = tmp.getAbsolutePath().substring(classPath.getAbsolutePath().length()+1);
				tempPath = tempPath.substring(0, tempPath.lastIndexOf('.'));
				String qualifiedName = tempPath.replaceAll("\\\\", ".");
				// kr.or.ddit.vo.Alba
				try {
					Class clz = Class.forName(qualifiedName);
					clzList.add(clz);
				} catch (ClassNotFoundException e) {
					throw new RuntimeException(e);
				}
			}
			return clzList;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
