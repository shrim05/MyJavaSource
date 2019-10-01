package kr.or.ddit;
import  java.util.ArrayList;

//qualified name: classpath이후의 경로를 절대경로 형태로 표기한 이름
//classpath : 패키지나 클래스등의 리소스를 검색할 위치
public class HelloJava extends ArrayList{
	public static void main(String[] args){
		HelloJava instance = new HelloJava();
			System.out.println("Hello Java"+instance.size());
	}
		
}
