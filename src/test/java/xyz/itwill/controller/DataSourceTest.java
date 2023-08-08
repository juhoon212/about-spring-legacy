package xyz.itwill.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DataSourceTest {
	
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testDataSource() throws SQLException {
		log.info("DataSource = {}", dataSource);
		Connection conn = dataSource.getConnection();
		log.info("Connection = {}", conn);
		conn.close();
	}
	
}
