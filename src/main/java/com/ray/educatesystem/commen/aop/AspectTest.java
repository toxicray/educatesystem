package com.ray.educatesystem.commen.aop;

import com.ray.educatesystem.commen.annotation.Audit;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

/**
 * Package:com.ray.educatesystem.commen.aop
 * *Author:ray
 * *version:...
 * *Created in 2019/7/21  23:43
 **/
@Aspect
@Component
public class AspectTest {

	@Pointcut("@annotation(com.ray.educatesystem.commen.annotation.Audit)")
	private void pt(){

	};


	@Around("pt()&&@annotation(anno1)")
	public void aroundTest(ProceedingJoinPoint pjp, Audit anno1){
		//String str= JSON.toJSONString(pjp);
		//System.out.println(str);
		Object rtValue=null;
		Object[] args = pjp.getArgs();//得到方法执行所需的参数


		System.out.println("Logger类中的aroundPringLog方法开始记录日志了。。。前置2");
		System.out.println(anno1.name()+"----"+anno1.action());
		try {
			rtValue = pjp.proceed(args);//明确调用业务层方法（切入点方法）
			//System.out.println(rtValue.toString()+"-------2");
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
	}


}
