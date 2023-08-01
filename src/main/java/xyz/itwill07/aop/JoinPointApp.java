package xyz.itwill07.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JoinPointApp {
	
	public static void main(String[] args) {
		ApplicationContext context  = new ClassPathXmlApplicationContext("07-2_param.xml");
		JoinPointBean bean = context.getBean("joinPointBean", JoinPointBean.class);
		bean.add();
		bean.modify(1000, "홍길동");
		bean.getName();
		bean.calc(20, 10);
		((ClassPathXmlApplicationContext)context).close();
	}
}
