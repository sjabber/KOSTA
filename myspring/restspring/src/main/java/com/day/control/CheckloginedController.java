package com.day.control;

import com.day.dto.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

//@Controller
public class CheckloginedController {

    @GetMapping("/checklogined")
    @ResponseBody
    public Map<String, Object> CheckLogined(HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        Customer c = (Customer) session.getAttribute("loginInfo");
        int status;
        if (c == null) {
            status = 0;
        } else {
            status = 1;
        }
        map.put("status", status);
        return map;
    }

}
