package xyz.itwill08.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataSourceApp {
		
	public static void main(String[] args) throws SQLException {
		
			ApplicationContext context=new ClassPathXmlApplicationContext("08_dao.xml");
			DataSource dataSource=context.getBean("dataSource", DataSource.class);
			System.out.println("==========================================================");
			System.out.println(dataSource);
			Connection connection = dataSource.getConnection();
			System.out.println("connection = "+connection);
			connection.close();
			System.out.println("==========================================================");
			((ClassPathXmlApplicationContext)context).close();
		
		}
}
