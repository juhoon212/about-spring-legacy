package xyz.itwill.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@Slf4j
public class StudentControllerTest {
	
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mvc;
	
	@Before
	public void setup() {
		//MockMvcBuilders.webAppContextSetup(WebApplicationContext context)
		// => MockMvcBuilder 객체를 생성하여 반환하기 위한 메소드
		//MockMvcBuilder.build() : MockMvc 객체를 생성하여 반환하기 위한 메소드
		mvc=MockMvcBuilders.webAppContextSetup(context).build();
		log.info("MockMvc 객체 생성");
	}
	
	@Test
	public void testStudentDisplay() throws Exception {
		//MockMvcRequestBuilders.get(String url) : 매개변수로 요청 URL 주소를 전달받아 GET
		//방식으로 웹프로그램을 요청하는 메소드
		// => 요청 페이지에 대한 요청 관련 정보(리퀘스트 메세지)가 저장한 RequestBuilder 객체를 반환
		//MockMvc.perform(Builder requestBuilder) : 가상으로 페이지를 요청하는 메소드
		// => 매개변수에 전달받은 RequestBuilder 객체의 저장된 정보를 이용하여 페이지 요청
		// => Controller 클래스의 요청 처리 메소드 호출
		// => 요청에 대한 처리결과가 저장된 ResultActions 객체 반환
		//ResultActions.andReturn() : 요청 처리 메소드의 실행결과를 MvcResult 객체로 반환하는 메소드
		MvcResult result=mvc.perform(MockMvcRequestBuilders.get("/student/display")).andReturn();
		
		//MvcResult.getModelAndView() : 요청 처리 메소드에 의해 제공된 ModelAndView 객체를 반환하는 메소드
		log.info(result.getModelAndView().getViewName());
		log.info(result.getModelAndView().getModel().toString());
	}
}
