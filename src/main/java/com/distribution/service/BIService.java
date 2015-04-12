package com.distribution.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yjj.common.util.Date;

import com.distribution.entity.TableReport;
import com.distribution.dao.BIMapper;

@Service
public class BIService {
	private static final Logger logger = LoggerFactory.getLogger(BIService.class);
	
	@Autowired
	BIMapper biMapper;
	
	public List<TableReport> getTableReport(){
		return biMapper.getTableReport("20150412");//biMapper.getTableReport(Date.getDateyyyyMMdd());
	}
	
	/**
	 * 获取销售总量
	 * @return
	 */
	public String getTotalSalAmt(){
		logger.info("totalSal:{}",biMapper.getTotalSalAmt());
		return biMapper.getTotalSalAmt();
	}
}
