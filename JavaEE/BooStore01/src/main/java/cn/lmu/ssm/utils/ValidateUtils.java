package cn.lmu.ssm.utils;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidateUtils {
	// 想在执行目标方法之前运行；写切入点表达式
	// execution(访问权限符 返回值类型 方法签名)
	@Before("execution(public * cn.lmu.ssm.service.ProductServiceImpl.*(..))")
	public static void logStart(JoinPoint joinPoint) {
		// 获取到目标方法运行是使用的参数
		Object[] args = joinPoint.getArgs();
		// 获取到方法签名
		Signature signature = joinPoint.getSignature();
		String name = signature.getName();
		System.out.println("【" + name + "】方法开始验证，用的参数列表【" + Arrays.asList(args) + "】");
	}
}
