package com.day.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	@RequestMapping("/") //get과 post를 구분하지 않는다.
	public String index() {
		return "semantic_css_jq";
	}
}
