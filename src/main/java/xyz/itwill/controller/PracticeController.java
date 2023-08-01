package xyz.itwill.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
public class PracticeController {
	
	@GetMapping("/ok") 
	public String ok() {
		log.info("ok");
		return "ok";
	}
	
	
	
	
	
	
	
	
}
