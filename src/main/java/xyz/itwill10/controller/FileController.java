package xyz.itwill10.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import lombok.RequiredArgsConstructor;
import xyz.itwill10.dto.FileBoard;
import xyz.itwill10.service.FileBoardService;


// 파일을 전달받아 서버 디렉토리에 업로드 처리하기 위한 방법
// 1.commons-fileupload 라이브러리를 프로젝트에 빌드 처리 - 메이븐 : pom.xml
// 2.Spring Bean Configuration file(Servlet-context.xml)에 파일 업로드 처리 기능을 제공하는 클래스를 등록

@Controller
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {
	
	private final WebApplicationContext context;
	private final FileBoardService fileBoardService;
	
	
	@GetMapping("/upload1")
	public String uploadOne() {
		return "file/file_form";
	}
	
	@PostMapping("/upload1")
	public String uploadOne(@RequestParam String uploaderName
			, @RequestParam MultipartFile uploadFile, Model model) throws IOException {
		//전달받은 파일에 대한 검증 작성
		if(uploadFile.isEmpty() || !uploadFile.getContentType().equals("image/jpeg")) {
			return "file/upload_fail";
		}
		
		//전달파일을 저장하기 위한 서버 디렉토리의 시스템 경로를 반환받아 저장
		String uploadDirectory=context.getServletContext().getRealPath("/resources/images/upload");
		
		//전달파일을 서버 디렉토리에 저장될 업로드 파일정보가 저장된 File 객체 생성
		// => 서버 디렉토리에 저장된 파일이름은 중복되지 않는 이름으로 사용되도록 변경
		//UUID.randomUUID() : 36Byte의 문자열로 구현된 식별자를 생성하여 반환하는 메소드
		String uploadFilename=UUID.randomUUID()+"_"+uploadFile.getOriginalFilename();
		File file=new File(uploadDirectory, uploadFilename);
		
		//전달파일을 서버 디렉토리에 저장 - 업로드 처리
		uploadFile.transferTo(file);
		
		model.addAttribute("uploaderName", uploaderName);
		model.addAttribute("uploadFilename", uploadFilename);
		
		return "file/upload_success";
	}
	
	@GetMapping("/upload2")
	public String uploadTwo() {
		return "file/file_form2";
	}
	
	@PostMapping("/upload2")
	public String uploadTwo(@RequestParam String uploaderName
			, @RequestParam("uploadFile") List<MultipartFile> uploadFileList, Model model) throws IOException {
		
		String uploadDirectory = context.getServletContext().getRealPath("/resources/images/upload");
		List<String> fileNameList = new ArrayList<>();
		
		for (MultipartFile multipartFile : uploadFileList) {
			if(multipartFile.isEmpty() || !multipartFile.getContentType().equals("/image/jpeg")) {
				return "file/upload_fail";
			}
			
			String uploadFileName = UUID.randomUUID().toString() + "_" + multipartFile.getOriginalFilename();
			File file = new File(uploadDirectory, uploadFileName);
			
			multipartFile.transferTo(file);
			
			fileNameList.add(uploadFileName);
		}
		
		model.addAttribute("uploaderName", uploaderName);
		model.addAttribute("filenameList", fileNameList);
	
		return "file/upload_success_two";
	}
	
	@GetMapping("/write")
	public String fileBoardWrite() {
		return "board_write";
	}
	
	@PostMapping("/write")
	public String fileBoardWrite(@ModelAttribute FileBoard fileBoard) throws IOException {
		if(fileBoard.getMultipartFile().isEmpty()) {
			return "file/board_write";
		}
		
		String uploadDirectory = context.getServletContext().getRealPath("/WEB-INF/upload");
		
		// 사용자로부터 입력받아 전달받은 파일의 이름을 반환받아 Command 객체의 필드값 변경
		String origin = fileBoard.getMultipartFile().getOriginalFilename();
		fileBoard.setOrigin(origin);
		
		// => 중복되지 않는 고유값을 시스템의 현재 날짜와 시간에 대한 정수값(TimeStamp)으로 사용
		String upload = System.currentTimeMillis() + "";
		
		fileBoard.setUpload(upload);
		
		// 파일 업로드 처리
		fileBoard.getMultipartFile().transferTo(new File(uploadDirectory, upload));
		
		fileBoardService.addFileBoard(fileBoard);
		
		
		return "redirect:/file/list";
	}
	
	@GetMapping("/list")
	public String fileBoardList(Model model) {
		model.addAttribute("fileBoardList", fileBoardService.getFileBoardList());
		return "file/board_list";
	}
	
	

}
