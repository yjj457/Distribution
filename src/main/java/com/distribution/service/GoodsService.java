package com.distribution.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.distribution.controller.LoginLogoutController;
import com.distribution.dao.OrgInvMapper;
import com.distribution.dao.ProMapper;
import com.distribution.entity.OrgInvEntity;
import com.distribution.entity.ProEntity;

@Service
public class GoodsService {
	
	private static final Logger logger = LoggerFactory.getLogger(GoodsService.class);
	
	@Autowired
	private ProMapper proMapper;
	
	@Autowired
	private OrgInvMapper orgInvMapper;
	
	
	@Transactional
	public void uploadExcel(ArrayList<HashMap<String,String>> goodsInfo){
		ArrayList<String> pro_ids = new ArrayList<String>();
		Iterator<HashMap<String,String>> itGoods = goodsInfo.iterator();
		while(itGoods.hasNext()){pro_ids.add(itGoods.next().get("pro_id"));}

		orgInvMapper.uploadExcel(pro_ids);
		proMapper.uploadExcel(goodsInfo);
	}
	
	public List<ProEntity> getPro(){
		return proMapper.getPro();
	}
	
	@Transactional
	public void buy(List<Map<String, String>> list){
		Iterator<Map<String, String>> buy = list.iterator();
		while(buy.hasNext()){
			Map<String,String> buyInfo = buy.next();
			buyInfo.put("org_id", buyInfo.get("org_id"));
			buyInfo.put("pro_id", buyInfo.get("pro_id"));
			buyInfo.put("inv_qty", buyInfo.get("inv_qty"));
			logger.info(buyInfo.toString());
			orgInvMapper.buy(buyInfo);
		}
		
	}
	
}
