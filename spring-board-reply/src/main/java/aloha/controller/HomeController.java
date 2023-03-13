package aloha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@GetMapping({"", "/"})
	public String home(Model model) {
		log.info("Main Page...");
		model.addAttribute("author", "ALOHA CLASS");
		return "index";
	}

}
