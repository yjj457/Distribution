package com.distribution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.distribution.entity.TableReport;
import com.distribution.service.BIService;

@Controller
@RequestMapping(value="BI")
public class BIController extends BIBaseController{

	@Autowired
	BIService biService;

	
	
	@RequestMapping(value="tableReport")
	public String getTableReport(Model model){
		List<TableReport> results = biService.getTableReport();
		model.addAttribute("results", results);
		return folder() + "tableReport";
	}
	
}