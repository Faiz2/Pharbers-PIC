package pha.com.annotation;  
  
import java.lang.annotation.*;  
  
/** 
 *自定义注解 拦截service 
 */  
  
@Target({ElementType.PARAMETER, ElementType.METHOD})  
@Retention(RetentionPolicy.RUNTIME)  
@Documented  
public  @interface SystemControllerLog {  
    String description()  default "";  
} 