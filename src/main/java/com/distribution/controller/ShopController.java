package com.distribution.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import yjj.common.util.Date;
import yjj.springSecurity.util.Session;

import com.distribution.service.ShopService;
import com.distribution.service.UserService;


@Controller
@RequestMapping(value="shopOwner")
public class ShopController extends DistributionBaseController{
	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="showSale")
	public ModelAndView showSale(){
		logger.info("打开销售页面");
		logger.info("org_id:{}" ,getOrgIdByUserNm());
		Map<String,String> model = new HashMap<String,String>();
		model.put("org_id", getOrgIdByUserNm());
		return new ModelAndView(folder() + "shopOwnerShowSale",model);
	}
	
	@RequestMapping(value="showReturn")
	public ModelAndView showReturn(){
		logger.info("打开退货页面");
		logger.info("org_id:{}" ,getOrgIdByUserNm());
		Map<String,String> model = new HashMap<String,String>();
		model.put("org_id", getOrgIdByUserNm());
		return new ModelAndView(folder() + "shopOwnerShowReturn",model);
	}
	@RequestMapping(value="showIn")
	public ModelAndView showIn(){
		logger.info("打开进货页面");
		logger.info("org_id:{}" ,getOrgIdByUserNm());
		Map<String,String> model = new HashMap<String,String>();
		model.put("org_id", getOrgIdByUserNm());
		return new ModelAndView(folder() + "shopOwnerShowIn",model);
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
	 * 店长从仓库进货
	 */
	
	@RequestMapping(value="inProduct")
	@ResponseBody
	public void inProduct(HttpServletRequest request, HttpServletResponse response){
		Map<String,String> goods = new HashMap<String,String>();
		goods.put("org_id", getOrgIdByUserNm());
		goods.put("inv_id", request.getParameter("inv_id1"));
		goods.put("pro_id", request.getParameter("pro_id1"));
		goods.put("inv_qty", request.getParameter("sal_qty1"));
		shopService.shopAdd(goods);
		
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
		String ord_id = request.getParameter("org_id") + Date.getDateyyyyMMdd() + shopService.getOrder(request.getParameter("org_id"));
		logger.info("销售！:{}",ord_id);
		ArrayList<HashMap<String, Object>> proInfos = new ArrayList<HashMap<String, Object>>();
		for(int i=1;;i++){
			HashMap<String, Object> proInfo = new HashMap<String,Object>();
			proInfo.put("org_id", request.getParameter("org_id") + "");
			proInfo.put("ord_id", ord_id);
			proInfo.put("pro_id", request.getParameter("pro_id" + i) + "");
		//	proInfo.put("pro_nm", request.getParameter("pro_nm" + i) + "");
			if(status.equals("-"))
				proInfo.put("sal_qty", (0 - Integer.parseInt(request.getParameter("sal_qty" + i)) + ""));
			else
				proInfo.put("sal_qty", Integer.parseInt(request.getParameter("sal_qty" + i) + ""));
			proInfo.put("sal_amt", Integer.parseInt(request.getParameter("sal_amt" + i) + ""));
			proInfos.add(proInfo);
			logger.info("{}:{},{},{},{}",request.getParameter("org_id"),request.getParameter("pro_id" + i),request.getParameter("pro_nm" + i),request.getParameter("sal_qty" + i),request.getParameter("sal_amt" + i));
			if(request.getParameter("pro_id" + (i+1)) == null){break;}
		}
		logger.info("service:saleProduct之前");
		shopService.saleProduct(proInfos);
		
		return ord_id;
	}
	
	
	
}
