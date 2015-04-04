package com.distribution.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.distribution.entity.ProEntity;

public interface ProMapper {
	
	/**
	 * 通过Excel提交新产品
	 * @param goodsInfo
	 */
	public void uploadExcel(ArrayList<HashMap<String,String>> goodsInfo);
	
	/**
	 * 取出产品列表
	 */
	public List<ProEntity> getPro();
	
	
}
