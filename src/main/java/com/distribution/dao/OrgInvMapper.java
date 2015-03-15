package com.distribution.dao;

import java.util.Map;

public interface OrgInvMapper {
	
	/**
	 * 下订单时产生库存变动
	 */
	public void updateOrgSal(Map<String,Object> proInfo);
	
	/**
	 * 仓库管理人员确认进仓
	 */
	public void updateOrgIn2Inv();
	/**
	 * 仓库管理人员确认出仓
	 */
	public void updateOrgOut4Inv();
	/**
	 * 仓库管理人员查询仓库现状
	 */
	public void SelectInv();
	
	/**
	 * 货管添加货品在仓库中记录
	 */
	public void InsertIn2Inv();
	
	
}
