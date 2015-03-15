package com.distribution.dao;

import java.util.ArrayList;
import java.util.HashMap;

public interface OrderMapper {
	
	/**
	 * 获取订单流水号
	 * @param 店铺ID
	 * @return 订单流水号
	 */
	public String getOrder(String org_id);
	
	
	/**
	 * 销售退货 qty为正数时是销售 负数时是退货
	 * @param 销售退货数据
	 */
	public void saleProduct(ArrayList<HashMap<String, Object>> proInfos);

	
}
