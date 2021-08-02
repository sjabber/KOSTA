package com.day.control;

import com.day.dto.Customer;
import com.day.exception.AddException;
import com.day.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

//@Controller
public class CustomerController {
    @Autowired
    private CustomerService service;

    @PostMapping("/login")
    @ResponseBody
    public Object login(String id, String pwd, HttpSession session) {
        HashMap<String, Object> map = new HashMap<>();
        session.removeAttribute("loginInfo");
        try {
            Customer loginInfo = service.login(id, pwd);
            session.setAttribute("loginInfo", loginInfo);
            map.put("status", 1);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status", 0);
            map.put("msg", e.getMessage());
            return map;
        }
    }

    @GetMapping("/logout")
    @ResponseBody
    public void logout(HttpSession session) {
        session.invalidate();
    }

    @PostMapping("/signup")
    @ResponseBody
    public Map<String, Object> signup(Customer c) {
        Map<String, Object> map = new HashMap<>();
        try {
            service.signup(c);
            map.put("result", 1);
            return map;
        }catch (AddException e) {
            e.printStackTrace();
            map.put("result", 0);
            map.put("msg", e.getMessage());
            return map;
        }
    }

}
