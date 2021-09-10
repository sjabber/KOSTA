package com.day.control;

import com.day.dto.Customer;
import com.day.exception.AddException;
import com.day.exception.FindException;
import com.day.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService service;
    //private Logger log = Logger.getLogger(CustomerController.class);

	@PostMapping("/login")
    public String login(@RequestBody Customer c, HttpSession session) {
		//private Logger log = Logger.getLogger(CustomerController.class);
		System.out.println(c.getId() + " : " + c.getPwd());
	    session.removeAttribute("loginInfo");
	    try {
            Customer loginInfo = service.login(c.getId(), c.getPwd());
            session.setAttribute("loginInfo", loginInfo);
            return "success";

        } catch (Exception e) {
	        e.printStackTrace();
            return "fail";
        }
    }

    @GetMapping("/logincheck")
    public ResponseEntity<Map<String, String>> loginCheck(HttpSession session) {

        Customer m = (Customer) session.getAttribute("loginInfo");
        ResponseEntity<Map<String, String>> responseEntity;

        Map<String, String> map = new HashMap<>();

        if (m == null) {
            responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        } else {
            System.out.println(m.toString());
            map.put("name", m.getName());
            responseEntity = new ResponseEntity<>(map, HttpStatus.OK);
        }
        return responseEntity;
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
        //log.info(c);
        try {
            service.signup(c);
            model.addAttribute("result", "1");
        }catch (AddException e) {
            e.printStackTrace();
            model.addAttribute("result", "0");
        }
    }

}
