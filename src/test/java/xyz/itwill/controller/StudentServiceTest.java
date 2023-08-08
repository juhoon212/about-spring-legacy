package xyz.itwill.controller;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import xyz.itwill10.dto.Student;
import xyz.itwill10.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
// @WebAppConfiguration : 스프링 컨테이너 
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@Slf4j
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class StudentServiceTest {
	
	@Autowired
	private StudentService studentService;
	
//	@Test
//	public void testAddStudent() {
//		
////		Student student = new Student();
////		student.setNo(7000);
////		student.setName("로빈훗");
////		student.setPhone("010-7841-3454");
////		student.setBirthday("2000-09-10");
//		
//		// Student 클래스의 StudentBuilder 클래스로 Student 객체를 생성하여 반환받아 생성
//		Student student = Student.builder()
//				.no(7000)
//				.name("로빈훗")
//				.address("010-7841-3454")
//				.birthday("2000-09-10")
//				.build();
//		
//		studentService.addStudent(student);
//	}
	
	
	@Test
	public void testGetStudentList() {
		List<Student> studentList = studentService.getstudentList();
		
		studentList.stream().forEach(x -> System.out.println(x.toString()));
	}
}
