package com.distribution.dao;

import java.util.List;

import com.distribution.entity.TableReport;

public interface BIMapper {
	/**
	 * 表格报表
	 * @return
	 */
	public List<TableReport> getTableReport(String pdate);
	
	/**
	 * 获取销售总量
	 * @return
	 */
	public String getTotalSalAmt();
	
	
}
