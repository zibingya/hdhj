package com.hxzy.aop;

import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.hxzy.entity.SystemLog;
import com.hxzy.service.SystemLogService;

import net.sf.json.JSONArray;

@Aspect
@Component
public class SystemLogAop {

	@Resource(name = "systemLogServiceImpl")
	private SystemLogService systemLogService;

	// 定义切点 @Pointcut
	// 在注解的位置切入代码
	@Pointcut("execution(public * com.hxzy.controller.*.*(..)) && @annotation(com.hxzy.aop.SystemLogAn)")
	public void logPintCut() {
	}

	// 切面 配置通知
	//@AfterReturning("logPintCut()")
	//@Around("logPintCut()")
	@AfterReturning(returning = "ret", pointcut = "logPintCut()") 
	public void saveLog(JoinPoint joinPoint,Object ret) {
		// 创建日志对象
		SystemLog log = new SystemLog();
		// 从切面织入点处通过反射机制获取织入点处的方法
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		// 获取切入点所在的方法
		Method method = signature.getMethod();
		// 获取操作
		SystemLogAn myLog = method.getAnnotation(SystemLogAn.class);
		if (myLog != null) {
			String value = myLog.value();
			log.setOperation(value);// 保存获取的操作
		}
		// 获取请求的类名
		String className = joinPoint.getTarget().getClass().getName();
		// 获取请求的方法名
		String methodName = method.getName();
		log.setMethod(className + "." + methodName);
		// 请求的参数
		Object[] args = joinPoint.getArgs();
		// 将参数所在的数组转换成json
		String params = JSONArray.fromObject(args).toString();
		log.setParams(params);
		//设置时间
		SimpleDateFormat newsdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String date = newsdf.format(new Date());
		log.setCreateDate(date);
		
		// 获取用户名
//        log.setUsername(ShiroUtils.getUserEntity().getUsername());
		// 获取用户ip地址
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
        log.setIp(LoggerUtils.getCliectIp(request));
        //获取请求类型
        log.setType(LoggerUtils.getRequestType(request));
        //获取方法返回值
        log.setReturninfo(ret.toString());
		//调用service保存
        systemLogService.addSystemLog(log);
	}
}