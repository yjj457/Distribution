package com.distribution.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("main")
public class MainController {
	
	@RequestMapping(value="common", method = RequestMethod.GET)
	public ModelAndView mainView(){
		
		
		return new ModelAndView("common");
		
	}
	
	@RequestMapping(value="")
	public ModelAndView shopView(){
		
		return null;
	}
}
