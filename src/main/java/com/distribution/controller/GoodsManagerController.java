package com.distribution.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="goodsManager")
public class GoodsManagerController {
	
	private static final Logger logger = LoggerFactory.getLogger(GoodsManagerController.class);
	
	@RequestMapping(value="showManage")
	public String showManage(){
		logger.info("打开货品管理页面");
		return "Distribution/goodsManagerShowManage";
	}
	
	@RequestMapping(value="showBuy")
	public String showBuy(){
		logger.info("打开进货页面");
		return "Distribution/goodsManagerShowBuy";
	}
}
