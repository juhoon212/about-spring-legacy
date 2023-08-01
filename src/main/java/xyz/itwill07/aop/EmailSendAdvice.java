package xyz.itwill07.aop;




import org.aspectj.lang.JoinPoint;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailSendAdvice {
	// Before Advice Method
	public void accessLog(JoinPoint joinPoint) {
		String email = (String)joinPoint.getArgs()[0];
		String subject = (String)joinPoint.getArgs()[1];
		
		log.info(email + "님에게 <" + subject + "> 제목의 이메일을 전송합니다.");
		
	}
	
	public void successLog(String email) {
		log.info(email + "님에게 이메일을 성공적으로 전송 하였습니다.");
	}
	
	public void errorLog(Exception exception) {
		log.info("이메일 전송 실패 = " + exception);
	}
}
