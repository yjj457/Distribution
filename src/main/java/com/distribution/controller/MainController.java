package com.distribution.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("main")
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	@RequestMapping(value="common", method = RequestMethod.GET)
	public String mainView(){
		
		logger.info("common");
		return "Distribution/common";
		
	}
	
	@RequestMapping(value="")
	public ModelAndView shopView(){
		
		return null;
	}
}
