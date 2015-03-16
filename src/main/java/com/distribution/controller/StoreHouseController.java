package com.distribution.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="storeHouse")
public class StoreHouseController extends DistributionBaseController{
	private static final Logger logger = LoggerFactory.getLogger(StoreHouseController.class);
	
	@RequestMapping(value="showIn")
	public String showIn(){
		logger.info("打开进仓确认页面");
		return folder() + "storeHouseShowIn";
	}
	
	@RequestMapping(value="showOut")
	public String showOut(){
		logger.info("打开出仓确认页面");
		return folder() + "storeHouseShowOut";
	}
	
	@RequestMapping(value="showSearch")
	public ModelAndView showSearch(){
		logger.info("打开仓库查询页面");
		logger.info("org_id:{}" ,getOrgIdByUserNm());
		Map<String,String> model = new HashMap<String,String>();
		model.put("org_id", getOrgIdByUserNm());
		return new ModelAndView(folder() + "storeHouseShowSearch",model);
	}
	
	
	@RequestMapping(value="searchStore")
	@ResponseBody
	public Map<String,Object> searchStore(){
		//TODO 获取仓库数据的json:{"total":"10","rows":[{"id":"185303","firstname":"fanrio","lastname":"last","phone":"0","email":"x@x.com"},{"id":"185305","firstname":"yutryrt","lastname":"fghgfhgfh","phone":"345345345","email":""},{"id":"185306","firstname":"sssssssss","lastname":"hhhhhhhhhhh","phone":"4444444444","email":""},{"id":"185307","firstname":"hfghfgfhgfh","lastname":"565ghfhghgfh","phone":"4444444444444","email":""},{"id":"185308","firstname":"ghjghjghjghj","lastname":"ghjghjghj","phone":"45645645645","email":""},{"id":"185309","firstname":"ee","lastname":"e","phone":"e","email":"e@c.pcd"},{"id":"185310","firstname":"erert","lastname":"erterter","phone":"erte","email":"rtert@sdghfs.ksdh"},{"id":"185311","firstname":"kj","lastname":"lk","phone":"","email":""},{"id":"185312","firstname":"kj","lastname":"lk","phone":"","email":""},{"id":"185313","firstname":"def","lastname":"test","phone":"12365478","email":"def@def.com"}]}
		return null;
	}
	
}
