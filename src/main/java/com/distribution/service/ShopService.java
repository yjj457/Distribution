package com.distribution.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.distribution.dao.OrderMapper;
import com.distribution.dao.OrgInvMapper;

@Service
public class ShopService {
	private static final Logger logger = LoggerFactory.getLogger(ShopService.class);

	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private OrgInvMapper orgInvMapper;
	
	@Transactional
	public String saleProduct(ArrayList<HashMap<String, Object>> proInfos){
		logger.info("service:saleProduct");
		Iterator<HashMap<String, Object>> it = proInfos.iterator();
		while(it.hasNext()){
			HashMap<String, Object> proInfo = (HashMap<String, Object>) it.next();
			
			
			logger.info("service:{}",proInfo.get("org_id"));
			logger.info("service:{}",proInfo.get("pro_id"));
			logger.info("service:{}",proInfo.get("pro_nm"));
			logger.info("service:{}",proInfo.get("sal_qty"));
			logger.info("service:{}",proInfo.get("sal_amt"));
			logger.info("service:{}",proInfo.get("ord_id"));
			
			//销售才改变库存 退货不改变库存
			if(Integer.parseInt((String) proInfo.get("sal_qty")) > 0) 
				orgInvMapper.updateOrgSal(proInfo);
		}
		
		//插入订单表 order_info
		orderMapper.saleProduct(proInfos);
		
		//操作店仓表 
		
		return "success";
	}
	
	
	/**
	 * 获取订单后四位数字
	 * @param org_id
	 * @return 订单后四位数字
	 */
	public String getOrder(String org_id){
		return orderMapper.getOrder(org_id);
	}

	public void shopAdd(Map<String,String> goods){
		orgInvMapper.shopAdd(goods);
	}
	

}
