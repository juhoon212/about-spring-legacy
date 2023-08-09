package xyz.itwill10.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
	
	private int no;
	private String name;
	private String phone;
	private String address;
	private String birthday;
}

