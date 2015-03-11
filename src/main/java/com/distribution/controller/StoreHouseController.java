package com.distribution.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="storeHouse")
public class StoreHouseController {
	private static final Logger logger = LoggerFactory.getLogger(StoreHouseController.class);
	
	@RequestMapping(value="showIn")
	public String showIn(){
		logger.info("打开进仓确认页面");
		return "";
	}
	
	@RequestMapping(value="showOut")
	public String showOut(){
		logger.info("打开出仓确认页面");
		return "";
	}
	
	@RequestMapping(value="showSearch")
	public String showSearch(){
		logger.info("打开仓库查询页面");
		return "";
	}
	
}
