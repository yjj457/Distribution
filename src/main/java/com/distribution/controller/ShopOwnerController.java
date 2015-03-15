package com.distribution.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.util.Date;
import com.distribution.service.ShopOwnerService;


@Controller
@RequestMapping(value="shopOwner")
public class ShopOwnerController extends DistributionBaseController{
	private static final Logger logger = LoggerFactory.getLogger(ShopOwnerController.class);
	
	@Autowired
	private ShopOwnerService shopOwnerService;
	
	@RequestMapping(value="showSale")
	public String showSale(){
		logger.info("打开销售页面");
		return folder() + "shopOwnerShowSale";
	}
	
	@RequestMapping(value="showReturn")
	public String showReturn(){
		logger.info("打开退货页面");
		return folder() + "shopOwnerShowReturn";
	}
	
	@RequestMapping(value="saleProduct")
	@ResponseBody
	public String saleProduct(HttpServletRequest request, HttpServletResponse response){
		ArrayList<HashMap<String, String>> proInfos = new ArrayList<HashMap<String, String>>();
		for(int i=1;;i++){
			HashMap<String, String> proInfo = new HashMap<String,String>();
			proInfo.put("org_id", request.getParameter("org_id"));
			proInfo.put("pro_id", request.getParameter("pro_id" + i));
			proInfo.put("pro_nm", request.getParameter("pro_nm" + i));
			proInfo.put("sal_qty", request.getParameter("sal_qty" + i));
			proInfo.put("sal_amt", request.getParameter("sal_amt" + i));
			proInfos.add(proInfo);
			logger.info("{}:{},{},{},{}",request.getParameter("org_id"),request.getParameter("pro_id" + i),request.getParameter("pro_nm" + i),request.getParameter("sal_qty" + i),request.getParameter("sal_amt" + i));
			if(request.getParameter("pro_id" + (i+1)) == null){break;}
		}
		shopOwnerService.saleProduct(proInfos);
		
		return request.getParameter("org_id") + new Date().getDateyyyyMMdd() + "";
	}
	
}
