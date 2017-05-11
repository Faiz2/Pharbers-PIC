package pha.com.annotation;  
  
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import pha.com.code.log.login.model.LoginLog;
import pha.com.code.log.login.service.LoginLogService;
import pha.com.code.system.model.UserInfo;
import pha.com.code.system.service.UserInfoService;
import pha.com.common.util.DateUtil;
  
/** 
 * 切点类 
 * @author liwei 
 * @since 2015-12-15 Pm 20:35 
 * @version 1.0 
 */  
@Aspect  
@Component  
public  class SystemLogAspect {  
    //注入Service用于把日志保存数据库  
    @Resource  
    private LoginLogService loginLogService;//登录Service 
    
//    @Resource  
//    private LoginLogService loginLogService;//登录Service  
//    
//    @Resource  
//    private LoginLogService loginLogService;//登录Service  
    //本地异常日志记录对象  
     private  static  final Logger logger = LoggerFactory.getLogger(SystemLogAspect. class);  
  
    //Service层切点  
    @Pointcut("@annotation(pha.com.annotation.SystemServiceLog)")  
     public  void serviceAspect() {  
    }  
  
    //Controller层切点  
    @Pointcut("@annotation(pha.com.annotation.SystemControllerLog)")  
     public  void controllerAspect() {  
    }
    
    //Controller执行结束后切点  
    @Pointcut("@annotation(pha.com.annotation.SystemControllerAfterLog)")  
     public  void controllerAfterAspect() {  
    } 
  
    /** 
     * 前置通知 用于拦截Controller层记录用户的操作 
     * 
     * @param joinPoint 切点 
     */  
    @Before("controllerAspect()")  
     public  void doBefore(JoinPoint joinPoint) {  
    	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();  
    	//UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getSession().getAttribute("user");
    	LoginLog loginLogsession = (LoginLog)SecurityUtils.getSubject().getSession().getAttribute("loginLogsession");
	   	String ip = request.getRemoteAddr();  
	   	try {  
            //*========控制台输出=========*//  
            System.out.println("=====前置通知开始=====");  
            System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));  
            System.out.println("方法描述:" + getControllerMethodDescription(joinPoint));  
            System.out.println("请求人:" + loginLogsession.getLoginname());  
            System.out.println("请求IP:" + ip);  
            //*========数据库日志=========*//
            if(getServiceMthodDescription(joinPoint).equals("用户登出")){
            	//*========数据库日志=========*//
  	       	  	LoginLog loginLog = new LoginLog();
  	       	  	loginLog.setIp(ip);
  	       	  	loginLog.setLoginname(loginLogsession.getLoginname());//userInfo.getLoginName()
  	       	  	loginLog.setLoginstart(loginLogsession.getLoginstart());
  	       	  	loginLog.setLoginend(new Date());
  	       	  	loginLog.setLogintype("0");
  	       	  	loginLog.setDescinfo("登录日志");
  	       	  	//保存数据库  
  	       	  	loginLogService.updateByNameSelective(loginLog);
            }
            System.out.println("=====前置通知结束=====");  
        }  catch (Exception e) {  
            //记录本地异常日志  
            logger.error("==前置通知异常==");  
            logger.error("异常信息:{}", e.getMessage());  
        }
    }
    
    @After("controllerAfterAspect()")
    public  void doAfter(JoinPoint joinPoint) {  
    	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();  
    	//UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipals();
    	String userName = request.getAttribute("loginName").toString();
	   	String ip = request.getRemoteAddr();  
	       try {  
	          //*========控制台输出=========*//  
	          System.out.println("=====前置通知开始=====");  
	          System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));  
	          System.out.println("方法描述:" + getControllerAfterMethodDescription(joinPoint));  
	          System.out.println("请求人:" + userName);  
	          System.out.println("请求IP:" + ip);
	          //*========数据库日志=========*//
	          if(getControllerAfterMethodDescription(joinPoint).equals("用户登入")){
	        	  LoginLog loginLog = new LoginLog();
	        	  Map<String, Object> map = new HashMap<String,Object>();
	        	  map.put("loginname", userName);
	        	  map.put("check", "check");
	        	  List<LoginLog> list = loginLogService.queryByParameters(map);
	        	  if(list.size() > 0 && "1".equals(list.get(0).getLogintype()) && list.get(0).getLoginend() == null){
	        		  loginLog.setId((long)list.get(0).getLogid());
	        		  loginLog.setLogintype("0");
	        		  loginLog.setLoginend(DateUtil.getAfterDate(list.get(0).getLoginstart(), 30));
	        		  loginLogService.saveOneSelective(loginLog);
	        	  }
	        	  loginLog.setId(null);
	        	  loginLog.setLoginend(null);
		       	  loginLog.setIp(ip);
		       	  loginLog.setLoginname(userName);
		       	  loginLog.setLoginstart(new Date());
		       	  loginLog.setLogintype("1");
		       	  loginLog.setDescinfo("登录日志");
		       	  SecurityUtils.getSubject().getSession().setAttribute("loginLogsession", loginLog);
		          //保存数据库  
		          loginLogService.saveOneSelective(loginLog);
	          }
	          System.out.println("=====前置通知结束=====");  
	      }  catch (Exception e) {  
	          //记录本地异常日志  
	          logger.error("==前置通知异常==");  
	          logger.error("异常信息:{}", e.getMessage());  
	      }
   }
   
    /** 
     * 异常通知 用于拦截service层记录异常日志 
     * 
     * @param joinPoint 
     * @param e 
     */  
    /* @AfterThrowing(pointcut = "serviceAspect()", throwing = "e")
     public  void doAfterThrowing(JoinPoint joinPoint, Throwable e) {  
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();  
        HttpSession session = request.getSession();
        //读取session中的用户  
        String username = "";
        if(session.getAttribute("username") != null){
        	username = session.getAttribute("username").toString();
        	//获取请求ip  
            String ip = request.getRemoteAddr();  
            //获取用户请求方法的参数并序列化为JSON格式字符串  
            String params = "";  
            if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {  
                 for ( int i = 0; i < joinPoint.getArgs().length; i++) {  
                    //params += JSONUtil.toJsonString(joinPoint.getArgs()[i]) + ";";  
                	 params += joinPoint.getArgs()[i];
                }  
            }
             try {  
                //========控制台输出========= 
                System.out.println("=====异常通知开始=====");  
                System.out.println("异常代码:" + e.getClass().getName());  
                System.out.println("异常信息:" + e.getMessage());  
                System.out.println("异常方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));  
                System.out.println("方法描述:" + getServiceMthodDescription(joinPoint));  
                System.out.println("请求人:" + username);  
                System.out.println("请求IP:" + ip);  
                System.out.println("请求参数:" + params);  
               // ==========数据库日志=========  
                Log log = new Log();
                log.setDescription(getServiceMthodDescription(joinPoint));  
                log.setExceptioncode(e.getClass().getName());  
                log.setType("2");  
                log.setExceptiondetail(e.getMessage());
                log.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));  
                log.setParams(params);  
                log.setCreateby(username);
                log.setCreatedate(new Date());  
                log.setRequestip(ip);  
                //保存数据库  
                logService.saveOneSelective(log); 
                System.out.println("=====异常通知结束=====");  
            }  catch (Exception ex) {  
                //记录本地异常日志  
                logger.error("==异常通知异常==");  
                logger.error("异常信息:{}", ex.getMessage());  
            }
             //==========记录本地异常日志==========  
             logger.error("异常方法:{}异常代码:{}异常信息:{}参数:{}", joinPoint.getTarget().getClass().getName() + joinPoint.getSignature().getName(), e.getClass().getName(), e.getMessage(), params);
        }
    }  */
  
  
    /** 
     * 获取注解中对方法的描述信息 用于service层注解 
     * 
     * @param joinPoint 切点 
     * @return 方法描述 
     * @throws Exception 
     */  
     public  static String getServiceMthodDescription(JoinPoint joinPoint) throws Exception {  
        String targetName = joinPoint.getTarget().getClass().getName();  
        String methodName = joinPoint.getSignature().getName();  
        Object[] arguments = joinPoint.getArgs();  
        Class targetClass = Class.forName(targetName);  
        Method[] methods = targetClass.getMethods();  
        String description = "";  
         for (Method method : methods) {  
             if (method.getName().equals(methodName)) {  
                Class[] clazzs = method.getParameterTypes();  
                 if (clazzs.length == arguments.length) {  
                    description = method.getAnnotation(SystemServiceLog. class).description();  
                     break;  
                }  
            }  
        }  
         return description;  
    }  
  
    /** 
     * 获取注解中对方法的描述信息 用于Controller层注解 
     * 
     * @param joinPoint 切点 
     * @return 方法描述 
     * @throws Exception 
     */  
     public  static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {  
        String targetName = joinPoint.getTarget().getClass().getName();  
        String methodName = joinPoint.getSignature().getName();  
        Object[] arguments = joinPoint.getArgs();  
        Class targetClass = Class.forName(targetName);  
        Method[] methods = targetClass.getMethods();  
        String description = "";  
         for (Method method : methods) {  
             if (method.getName().equals(methodName)) {  
                Class[] clazzs = method.getParameterTypes();  
                 if (clazzs.length == arguments.length) {  
                    description = method.getAnnotation(SystemControllerLog. class).description();  
                     break;  
                }  
            }  
        }  
         return description;  
    }
     
     /** 
      * 获取注解中对方法的描述信息 用于Controller层注解 
      * 
      * @param joinPoint 切点 
      * @return 方法描述 
      * @throws Exception 
      */  
      public  static String getControllerAfterMethodDescription(JoinPoint joinPoint) throws Exception {  
         String targetName = joinPoint.getTarget().getClass().getName();  
         String methodName = joinPoint.getSignature().getName();  
         Object[] arguments = joinPoint.getArgs();  
         Class targetClass = Class.forName(targetName);  
         Method[] methods = targetClass.getMethods();  
         String description = "";  
          for (Method method : methods) {  
              if (method.getName().equals(methodName)) {  
                 Class[] clazzs = method.getParameterTypes();  
                  if (clazzs.length == arguments.length) {  
                     description = method.getAnnotation(SystemControllerAfterLog. class).description();  
                      break;  
                 }  
             }  
         }  
          return description;  
     }
}  