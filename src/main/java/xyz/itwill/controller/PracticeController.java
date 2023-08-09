package xyz.itwill.controller;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import xyz.itwill.controller.dto.Item;


@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/item")
public class PracticeController {
	
	private final ItemRepository itemRepository;
	
	@GetMapping
	public String showItems() {
		return "item-form";
	}
	
	
	@PostMapping("/save")
	public String save(@Validated @ModelAttribute Item item, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "/";
		}
		log.info("bindingResult = {}", bindingResult.toString());
		itemRepository.save(item);
		return "items";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
