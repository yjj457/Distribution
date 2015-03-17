package com.distribution.dao;

import java.util.List;
import java.util.Map;

import com.distribution.entity.InvSearchEntity;

public interface OrgInvMapper {
	
	/**
	 * 下订单时产生库存变动
	 */
	public void updateOrgSal(Map<String,Object> proInfo);
	/**
	 * 店长请求进货
	 * 存储过程 添加org的数量 减少inv的0增加inv的2
	 */
	public void shopAdd(Map<String, String> goods);
	
	/**
	 * 仓库管理人员确认进仓
	 */
	public List<InvSearchEntity> selectOrgIn2Inv(String org_id);
	public String selectOrgIn2InvNum(String org_id);
	public void in2StoreDo(Map<String, String> good);
	/**
	 * 仓库管理人员确认出仓
	 */
	public List<InvSearchEntity> selectOrgOut4Inv(String org_id);
	public String selectOrgOut4InvNum(String org_id);
	public void out4StoreDo(Map<String,String> goods);
	/**
	 * 仓库管理人员查询仓库现状
	 */
	public List<InvSearchEntity> selectInv(String org_id);
	public String selectInvNum(String org_id);
	
	
	/**
	 * 货管添加货品在仓库中记录
	 * 存储过程 在org中添加0 inv中添加0 1 2 数量为0
	 */
	public void goodsInOrg();
	
	/**
	 * 货管进货
	 * 制定仓库添加
	 * @param 仓id 货数量 update进1
	 */
	public void GoodsInInv1(Map<String, String> goods);
}
