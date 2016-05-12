package day22;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // 给什么类型的定义注解
@Retention(RetentionPolicy.RUNTIME) // 有效时候有效
public @interface Type_Annotation {
	String value();
	int[] countArraylist();
}

/*
 * 注解中的方法 方法名 = 返回值
 */
