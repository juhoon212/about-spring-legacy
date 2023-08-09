package xyz.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dto.Student;
import xyz.itwill10.service.StudentService;

@Controller
@RequiredArgsConstructor
public class StudentController {
	private final StudentService studentService;
	
	@RequestMapping(value = "/student/add", method = RequestMethod.GET)
	public String add() {
		return "student/student_add";
	}
	
	//전달값(학생정보)를 제공받아 STUDENT 테이블에 학생정보를 삽입하고 학생목록을 출력하는 
	//JSP 문서의 뷰이름을 반환하는 요청 처리 메소드
	// => Service 클래스의 객체로 메소드를 호출하여 데이타 처리 기능 구현 
	@RequestMapping(value = "/student/add", method = RequestMethod.POST)
	public String add(@ModelAttribute Student student, Model model) {
		try {
			//Service 클래스의 메소드 호출시 예외 발생 - 중복된 학생번호가 전달되어 PK 제약조건 위반 
			studentService.addStudent(student);
		} catch (Exception e) {
			model.addAttribute("message", "이미 사용중인 학생번호를 입력 하였습니다.");
			return "student/student_add";//포워드 이동
		}
		return "redirect:/student/display";//라디이렉트 이동
	}
	
	//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 속성값으로 저장하고 학생목록을 출력하는
	//JSP 문서의 뷰이름을 반환하는 요청 처리 메소드
	@RequestMapping("/student/display")
	public String display(Model model) {
		model.addAttribute("studentList", studentService.getstudentList());
		return "student/student_display";
	}
}
