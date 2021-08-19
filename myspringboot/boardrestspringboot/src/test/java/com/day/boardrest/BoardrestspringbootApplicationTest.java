package com.day.boardrest;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class BoardrestspringbootApplicationTest {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ApplicationContext context;
	
	@Test
	void contextLoads() {
		assertNotNull(context.getBean("repBoardController"));
		//assertNotNull(context.getBean("customerController"));
	}

}
