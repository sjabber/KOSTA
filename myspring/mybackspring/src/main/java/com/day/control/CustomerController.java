package com.day.control;

import com.day.dto.Customer;
import com.day.exception.AddException;
import com.day.exception.FindException;
import com.day.service.CustomerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService service;
    private Logger log = Logger.getLogger(CustomerController.class);

	@PostMapping("/login")
    public String login(String id, String pwd, HttpSession session) {
		//private Logger log = Logger.getLogger(CustomerController.class);
		System.out.println(id + " : " + pwd);
	    session.removeAttribute("loginInfo");
	    try {
            Customer loginInfo = service.login(id, pwd);
            session.setAttribute("loginInfo", loginInfo);
            return "success";

        } catch (Exception e) {
	        e.printStackTrace();
            return "fail";
        }
    }

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "success";
	}

    @GetMapping("/iddupchk")
    public void idDupChk(String id, Model model) {
        try {
            Customer c = service.findById(id);
            model.addAttribute("result", "1");
        }catch(FindException e) {
            model.addAttribute("result", "0");
        }
    }

    @PostMapping("/signup")
    public void signup(Customer c, Model model) {
        log.info(c);
        try {
            service.signup(c);
            model.addAttribute("result", "1");
        }catch (AddException e) {
            e.printStackTrace();
            model.addAttribute("result", "0");
        }
    }

}
