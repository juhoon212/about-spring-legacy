package xyz.itwill07.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class ExecutionTimeAdvice {
	
	//타겟메소드의 명령이 실행되는 처리시간을 계산하여 기록하기 위한 메소드 - Around Advice Method
	
	
	public Object timeWatchLog(ProceedingJoinPoint joinPoint) throws Throwable {
		// 타겟메소드의 명령 실행전에 동작될 명령 작성
		long startTime = System.currentTimeMillis();
		
		// 타겟메소드의 명령 실행 - 타겟메소드 호
		Object returnValue = joinPoint.proceed();
		
		// 타겟메소드의 명령 실행 후에 동작될 명령 작
		long endTime = System.currentTimeMillis();
		
		String className = joinPoint.getTarget().getClass().getSimpleName();
		String methodName = joinPoint.getSignature().getName();
		long resultTime = endTime - startTime;
		
		System.out.println(className + "클래스의" + methodName + "() 메소드 실행 시간 = " + resultTime + "ms");
		System.out.println(resultTime);
		
		return returnValue;
	}
	
	
//	public Object timeWatchLog(ProceedingJoinPoint joinPoint) throws Throwable {
//		
//		StopWatch stopWatch = new StopWatch();
//		
//		
//		// 타겟메소드의 명령 실행전에 동작될 명령 작성
//		long startTime = System.currentTimeMillis();
//		
//		// 타겟메소드의 명령 실행 - 타겟메소드 호
//		Object returnValue = joinPoint.proceed();
//		
//		// 타겟메소드의 명령 실행 후에 동작될 명령 작
//		stopWatch.stop();
//		
//		long endTime = System.currentTimeMillis();
//		String className = joinPoint.getTarget().getClass().getSimpleName();
//		String methodName = joinPoint.getSignature().getName();
//		long resultTime = endTime - startTime;
//		
//		System.out.println(className + "클래스의" + methodName + "() 메소드 실행 시간 = " + stopWatch.getTotalTimeMillis() + "ms");
//		
//		return returnValue;
//	}
	
	
	
}
