package xyz.itwill10.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

/*
CREATE TABLE fileboard(
		idx	NUMBER PRIMARY KEY, - 번호
		writer varchar2(20), 	- 작성자
		subject varchar2(100),  - 제목 
		origin varchar2(100),   - 사용자로부터 입력받은 파일명
		upload varchar(100)		- 서버에 저장된 파일명
	);

	CREATE SEQUENCE fileboard_seq;
*/

//DTO 클래스 - 전달값을 저장된 Command 객체를 표현하기 위한 클래스
// => 전달값을 저장된 Command 객체를 표현하기 위한 클래스의 기능
@Data
public class FileBoard {
	private int idx;
	private String writer;
	private String subject;
	private String origin;
	private String upload;
	
	// 사용자로부터 입력되어 전달된 파일정보를 저장하기 위한 필드
	private MultipartFile multipartFile;
	
}
