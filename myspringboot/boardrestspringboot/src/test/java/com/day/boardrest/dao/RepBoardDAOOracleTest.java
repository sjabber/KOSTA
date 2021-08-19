package com.day.boardrest.dao;

import com.day.boardrest.dao.RepBoardDAO;
import com.day.boardrest.dto.RepBoard;
import com.day.exception.FindException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RepBoardDAOOracleTest {

    @Autowired
    RepBoardDAO dao;

    @Test
    void test() throws FindException {
        RepBoard repBoard = dao.selectByNo(17);
        String expectedName = "제목1";
        assertEquals(expectedName, repBoard.getBoardTitle());
    }
}