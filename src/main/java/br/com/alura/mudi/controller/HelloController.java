package br.com.alura.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@GetMapping("/hello")
	public ModelAndView hello() {
		ModelAndView modelAndView = new ModelAndView("hello");
		modelAndView.addObject("nome", "World!");
		return modelAndView;
	}
}
