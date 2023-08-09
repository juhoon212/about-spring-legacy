package xyz.itwill.controller.dto;



import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Item {
	
	
	@NotEmpty(message = "공백은 안돼요")
	private String name;
	
	
}
