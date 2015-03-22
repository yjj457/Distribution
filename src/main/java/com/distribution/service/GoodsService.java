package com.distribution.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.distribution.dao.OrgInvMapper;
import com.distribution.dao.ProMapper;

@Service
public class GoodsService {
	
	@Autowired
	private ProMapper proMapper;
	
	@Autowired
	private OrgInvMapper orgInvMapper;
	
	
	@Transactional
	public void uploadExcel(ArrayList<HashMap<String,String>> goodsInfo){
		proMapper.uploadExcel(goodsInfo);
		ArrayList<String> pro_ids = new ArrayList<String>();
		Iterator<HashMap<String,String>> itGoods = goodsInfo.iterator();
		while(itGoods.hasNext()){pro_ids.add(itGoods.next().get("pro_id"));}
		
		orgInvMapper.uploadExcel(pro_ids);
		proMapper.uploadExcel(goodsInfo);
	}
	
}
