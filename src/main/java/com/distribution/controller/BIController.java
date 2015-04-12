package com.distribution.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.distribution.entity.TableReport;
import com.distribution.service.BIService;

@Controller
@RequestMapping(value="BI")
public class BIController extends BIBaseController{
	private static final Logger logger = LoggerFactory.getLogger(BIController.class);
	
	@Autowired
	BIService biService;

	@RequestMapping(value="tableReport")
	public String getTableReport(Model model){
		List<TableReport> results = biService.getTableReport();
		logger.info("tableReport:{}",results.toString());
		model.addAttribute("results", results);
		return folder() + "tableReport";
	}
	
	
	@RequestMapping(value="histogram")
	public String getHistogram(Model model){
		List<TableReport> results = biService.getTableReport();
		logger.info("histogram:{}",results.toString());
		model.addAttribute("results", results);
		return folder() + "histogram";
	}
	
	@RequestMapping(value="dash")
	public String getDash(Model model){
		String totalSal = biService.getTotalSalAmt();
		logger.info("dash:{}",totalSal);
		model.addAttribute("results", totalSal);
		return folder() + "dash";
	}
	
}