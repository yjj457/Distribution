package com.distribution.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShopOwnerService {
	private static final Logger logger = LoggerFactory.getLogger(ShopOwnerService.class);
	
	@Transactional
	public String saleProduct(ArrayList<HashMap<String, String>> proInfos){
		
		Iterator it = proInfos.iterator();
		int i = 0;
		while(it.hasNext()){
			i++;
			HashMap<String, String> proInfo = (HashMap<String, String>) it.next();
			logger.info("service:{}",proInfo.get("org_id"));
			logger.info("service:{}",proInfo.get("pro_id"));
			logger.info("service:{}",proInfo.get("pro_nm"));
			logger.info("service:{}",proInfo.get("sal_qty"));
			logger.info("service:{}",proInfo.get("sal_amt"));
		}
		
		return null;
	}
}
