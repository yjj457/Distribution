package com.distribution.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.distribution.entity.TableReport;
import com.distribution.dao.BIMapper;

@Service
public class BIService {
	@Autowired
	BIMapper biMapper;
	
	public List<TableReport> getTableReport(){
		return biMapper.getTableReport();
	}
	
}
