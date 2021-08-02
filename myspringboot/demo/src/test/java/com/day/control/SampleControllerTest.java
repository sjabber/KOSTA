package com.day.control;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(SampleController.class)
public class SampleControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void testSayHello() throws Exception {
		MockHttpServletRequestBuilder requestBuilder;
		requestBuilder = MockMvcRequestBuilders.get("/hello");
		requestBuilder.accept(MediaType.APPLICATION_JSON); //accept: 클라이언트가 처리할 수 있는 컨텐트 타입을정보 요청형식: "application/json"
		ResultActions resultActions = mockMvc.perform(requestBuilder); //요청테스트
		
		ResultMatcher matcher = MockMvcResultMatchers.status().isOk(); //예상되는 응답상태코드값은 200
		resultActions.andExpect(matcher); // 테스트
		
		ContentResultMatchers contentMatchers = MockMvcResultMatchers.content();
		String expectedContent = "hi"; // 예상되는 응답내용은 "hi"
		ResultMatcher matcher1 = contentMatchers.string(expectedContent);
		resultActions.andExpect(matcher1); // 테스트
	}
	
	@Test
	void testAdd() throws Exception {
		MockHttpServletRequestBuilder requestBuilder;
		requestBuilder = MockMvcRequestBuilders.post("/add");
		requestBuilder.accept(MediaType.APPLICATION_JSON); //클라이언트가 처리할 수 있는 컨텐트 타입 정보 : accept
		requestBuilder.contentType(MediaType.APPLICATION_JSON); //요청형식: contentType
		requestBuilder.content("{\"id\":\"id1\"}");
		ResultActions resultActions = mockMvc.perform(requestBuilder); //요청테스트
		
		ResultMatcher matcher = MockMvcResultMatchers.status().isOk(); //예상되는 응답상태코드값은 200
		resultActions.andExpect(matcher); // 테스트
		
		ContentResultMatchers contentMatchers = MockMvcResultMatchers.content();
		String expectedContent = "id1"; // 예상되는 응답내용은 "hi"
		ResultMatcher matcher1 = contentMatchers.string(expectedContent);
		resultActions.andExpect(matcher1); // 테스트
	}
}
