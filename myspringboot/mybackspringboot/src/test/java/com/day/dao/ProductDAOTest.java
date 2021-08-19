package com.day.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import com.day.dto.Product;
import com.day.exception.FindException;

@SpringBootTest
public class ProductDAOTest {
	@Autowired
	ProductDAO dao;
	@Test
	void test() throws FindException {
		Product p = dao.selectByNo("C0001");
		String expectedName = "아메리카노";
		assertEquals(expectedName, p.getProd_name());
	}
}
