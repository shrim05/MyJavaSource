package kr.or.ddit.mvc.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//문서화 시 포함
@Documented
//sourc 사람대상, 컴파일 시 사라짐. Class컴파일러(이후에도 살아있음), runtime(실행시점)
@Retention(RetentionPolicy.RUNTIME)
//SingleValue annotation(속성명을 생략가능 즉 value= 생략가능)
@Target(value=ElementType.TYPE)
public @interface CommandHandler {
	
}
//marker annotation