package com.day.boardrest.service;

import static org.junit.jupiter.api.Assertions.*;

import com.day.boardrest.dto.RepBoard;
import com.day.exception.FindException;
import com.day.boardrest.service.RepBoardService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RepBoardServiceTest {
    @Autowired
    RepBoardService service;

    @Test
    void test() throws FindException {
        assertNotNull(service);
        RepBoard r = service.findByNo(19);
        assertEquals("제목1", r.getBoardTitle());
    }
}