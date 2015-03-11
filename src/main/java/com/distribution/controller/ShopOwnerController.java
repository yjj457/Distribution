package com.distribution.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value="shopOwner")
public class ShopOwnerController {
	private static final Logger logger = LoggerFactory.getLogger(ShopOwnerController.class);
	
	@RequestMapping(value="showSale")
	public String showSale(){
		logger.info("打开销售页面");
		return "";
	}
	
	@RequestMapping(value="showReturn")
	public String showReturn(){
		logger.info("打开退货页面");
		return "";
	}
}
