package cn.lmu.ssm.utils;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogUtils {
	@Before("execution(public *  cn.lmu.ssm.service.ProductServiceImpl.*(..))")
	public static void logStart(JoinPoint joinPoint) {
		// 获取到目标方法运行是使用的参数
		Object[] args = joinPoint.getArgs();
		// 获取到方法签名
		Signature signature = joinPoint.getSignature();
		String name = signature.getName();
		System.out.println("【" + name + "】方法开始执行，用的参数列表【" + Arrays.asList(args) + "】");
	}

	@After("execution(public *  cn.lmu.ssm.service.*.*(..))")
	private int logAfter(JoinPoint joinPoint) {
		System.out.println("【" + joinPoint.getSignature().getName() + "】方法最终结束了");
		return 0;
	}

	@AfterReturning(value = "execution(public *  cn.lmu.ssm.service.*.*(..))", returning = "result")
	public static void logReturn(JoinPoint joinPoint, Object result) {
		Signature signature = joinPoint.getSignature();
		String name = signature.getName();
		System.out.println("【" + name + "】方法正常执行完成，计算结果是：" + result);
	}

	@AfterThrowing(value = "execution(public *  cn.lmu.ssm.service.*.*(..))", throwing = "exception")
	public static void logException(JoinPoint joinPoint, Exception exception) {
		System.out.println(
				"【" + joinPoint.getSignature().getName() + "】方法执行出现异常了，异常信息是【" + exception + "】：；这个异常已经通知测试小组进行排查");
	}
}
