package xyz.itwill08.dao;

import lombok.Data;

/*
 * CREATE TABLE student (
	NO NUMBER primary KEY,
	name varchar(20), 
	phone varchar2(100),
	address varchar2(150),
	birthday varchar2(100)
)
 */


@Data
public class Student {
	
	private int no;
	private String name;
	private String phone;
	private String address;
	private String birthday;
}
