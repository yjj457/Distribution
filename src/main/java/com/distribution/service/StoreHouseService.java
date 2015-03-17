package com.distribution.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.distribution.dao.OrgInvMapper;
import com.distribution.entity.InvSearchEntity;

@Service
public class StoreHouseService {
	private static final Logger logger = LoggerFactory.getLogger(StoreHouseService.class);
	
	@Autowired
	private OrgInvMapper orgInvMapper;
	
	
	public String selectInvNum(String org_id){
		logger.info("org_id:{}",org_id);
		logger.info(orgInvMapper.selectInvNum(org_id));
		return orgInvMapper.selectInvNum(org_id);
	}
	public List<InvSearchEntity> selectInv(String org_id){
		logger.info(orgInvMapper.selectInv(org_id).toString());
		return orgInvMapper.selectInv(org_id);
	}
	
	
	
	public String selectOrgIn2InvNum(String org_id){
		logger.info("org_id:{}",org_id);
		logger.info(orgInvMapper.selectOrgIn2InvNum(org_id));
		return orgInvMapper.selectOrgIn2InvNum(org_id);
	}
	public List<InvSearchEntity> selectOrgIn2Inv(String org_id){
		logger.info("org_id:{}",org_id);
		logger.info(orgInvMapper.selectOrgIn2Inv(org_id).toString());
		return orgInvMapper.selectOrgIn2Inv(org_id);
	}
	
	public String selectOrgOut4InvNum(String org_id){
		logger.info("org_id:{}",org_id);
		logger.info(orgInvMapper.selectOrgOut4InvNum(org_id));
		return orgInvMapper.selectOrgOut4InvNum(org_id);
	}
	public List<InvSearchEntity> selectOrgOut4Inv(String org_id){
		logger.info("org_id:{}",org_id);
		logger.info(orgInvMapper.selectOrgOut4Inv(org_id).toString());
		return orgInvMapper.selectOrgOut4Inv(org_id);
	}
	@Transactional
	public void in2StoreDo(List<Map<String, String>> goods){
		Iterator<Map<String, String>> it = goods.iterator();
		while(it.hasNext()){
			Map<String, String> good = (Map<String, String>) it.next();
			logger.info("进仓:{}",good.toString());
			orgInvMapper.in2StoreDo(good);
		}
	}
	@Transactional
	public void out4StoreDo(List<Map<String, String>> goods){
		Iterator<Map<String, String>> it = goods.iterator();
		while(it.hasNext()){
			orgInvMapper.out4StoreDo(it.next());
		}
	}
}
