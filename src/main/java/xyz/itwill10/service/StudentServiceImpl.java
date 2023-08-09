package xyz.itwill10.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dao.StudentDAO;
import xyz.itwill10.dto.Student;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
	private final StudentDAO studentDAO;

	@Override
	public void addStudent(Student student) {
		studentDAO.insertStudent(student);
		
	}

	@Override
	public List<Student> getstudentList() {
		return studentDAO.selectStudentList();
	}
	
	
}
