package com.day.boardrest.control;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.day.boardrest.control.RepBoardController;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;

//@WebMvcTest(RepBoardController.class) // Controller내에서 사용하는 @Service빈, @Repository빈 객체 생성주입 불가.
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK) //모의객체에 컨트롤러 주입해서 테스트
@AutoConfigureMockMvc
class RepBoardControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("상세게시물 검색")
    void test() throws Exception {
        MockMultipartHttpServletRequestBuilder requestBuilder;
        MockMvcRequestBuilders.get("/aaaa");
        //requestBuilder.param();
        //perform()
        //result확인
        

    }
    
}