package com.distribution.dao;

public interface ShopMapper {
	
	/**
	 * 获取订单流水号
	 * @return 订单流水号
	 */
	public String getOrder(String org_id);
}
