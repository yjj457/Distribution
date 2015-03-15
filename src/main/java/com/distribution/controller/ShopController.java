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
import com.distribution.service.ShopService;


@Controller
@RequestMapping(value="shopOwner")
public class ShopController extends DistributionBaseController{
	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
	
	@Autowired
	private ShopService shopService;
	
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
	
	
	/**
	 * 下单
	 * @param request
	 * @param response
	 * @return ord_id 订单号
	 */
	@RequestMapping(value="saleProduct")
	@ResponseBody
	public String saleProduct(HttpServletRequest request, HttpServletResponse response){
		return doProduct("",request,response);
	}
	
	/**
	 * 退货
	 * @param request
	 * @param response
	 * @return ord_id 退单号
	 */
	@RequestMapping(value="returnProduct")
	@ResponseBody
	public String returnProduct(HttpServletRequest request, HttpServletResponse response){
		return doProduct("-",request,response);
	}
	
	
	
	/**
	 * 定退单实际操作方法
	 * @param status 订货为 "" 退货为"-"
	 * @param request
	 * @param response
	 * @return ord_id 订单号
	 */
	private String doProduct(String status,HttpServletRequest request, HttpServletResponse response){
		//获取订(退)单号
		String ord_id = request.getParameter("org_id") + new Date().getDateyyyyMMdd() + shopService.getOrder(request.getParameter("org_id"));
		
		ArrayList<HashMap<String, Object>> proInfos = new ArrayList<HashMap<String, Object>>();
		for(int i=1;;i++){
			HashMap<String, Object> proInfo = new HashMap<String,Object>();
			proInfo.put("org_id", request.getParameter("org_id") + "");
			proInfo.put("ord_id", ord_id);
			proInfo.put("pro_id", request.getParameter("pro_id" + i) + "");
		//	proInfo.put("pro_nm", request.getParameter("pro_nm" + i) + "");
			proInfo.put("sal_qty", Integer.parseInt(status + request.getParameter("sal_qty" + i) + ""));
			proInfo.put("sal_amt", Integer.parseInt(request.getParameter("sal_amt" + i) + ""));
			proInfos.add(proInfo);
			logger.info("{}:{},{},{},{}",request.getParameter("org_id"),request.getParameter("pro_id" + i),request.getParameter("pro_nm" + i),request.getParameter("sal_qty" + i),request.getParameter("sal_amt" + i));
			if(request.getParameter("pro_id" + (i+1)) == null){break;}
		}
		shopService.saleProduct(proInfos);
		
		return ord_id;
	}
	
}
