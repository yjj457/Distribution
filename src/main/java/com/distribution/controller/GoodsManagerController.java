package com.distribution.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.distribution.service.GoodsService;

import yjj.common.util.Excel;

@Controller
@RequestMapping(value="goodsManager")
public class GoodsManagerController extends DistributionBaseController{
	
	private static final Logger logger = LoggerFactory.getLogger(GoodsManagerController.class);
	
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping(value="showManage")
	public String showManage(){
		logger.info("打开货品管理页面");
		return folder() + "goodsManagerShowManage";
	}
	
	@RequestMapping(value="showBuy")
	public String showBuy(){
		logger.info("打开进货页面");
		return folder() + "goodsManagerShowBuy";
	}
	
	@RequestMapping(value="/upExcel", method=RequestMethod.POST)  
    public String uploadExcel(@RequestParam MultipartFile[] excel_uploads, HttpServletRequest request) throws IOException{  
        //如果只是上传一个文件，则只需要MultipartFile类型接收文件即可，而且无需显式指定@RequestParam注解  
        //如果想上传多个文件，那么这里就要用MultipartFile[]类型来接收文件，并且还要指定@RequestParam注解  
        //并且上传多个文件时，前台表单中的所有<input type="file"/>的name都应该是myfiles，否则参数里的myfiles无法获取到所有上传的文件  
        for(MultipartFile excel_upload : excel_uploads){  
            if(excel_upload.isEmpty()){  
            	logger.info("文件未上传");
            }else{ 
            	logger.info("文件长度: {}",excel_upload.getSize());
            	logger.info("文件类型: {}",excel_upload.getContentType());
            	logger.info("文件名称: {}",excel_upload.getName());
            	logger.info("文件原名: {}",excel_upload.getOriginalFilename());
            	logger.info("========================================");  
                //如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\WEB-INF\\upload\\文件夹中  
                String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");  
                //这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉，我是看它的源码才知道的  
                FileUtils.copyInputStreamToFile(excel_upload.getInputStream(), new File(realPath, excel_upload.getOriginalFilename()));  
                ///////////////////////////////////////////////////////////////////////////////////////////////////
                //上面是上传 下面是解析Excel
                ///////////////////////////////////////////////////////////////////////////////////////////////////
                System.out.println("文件名:" + realPath + "/" + excel_upload.getOriginalFilename());
                Excel excel = new Excel();
                ArrayList<HashMap<String,String>> goodsInfo = new ArrayList<HashMap<String,String>>();
                HashMap<String,String> goodInfo = null;
                ArrayList<ArrayList<String>> goodsInfoTemp = excel.readFromXLS2003(realPath + "/" + excel_upload.getOriginalFilename());
                System.out.println(goodsInfoTemp.toString());
                Iterator<ArrayList<String>> itGoods = goodsInfoTemp.iterator();
                while(itGoods.hasNext()){
                	Iterator<String> itGood = itGoods.next().iterator();
                	goodInfo = new HashMap<String,String>();
                	if(itGood.hasNext()) goodInfo.put("pro_id", itGood.next());
                	else goodInfo.put("pro_id", "");
                	if(itGood.hasNext()) goodInfo.put("pro_nm", itGood.next());
                	else goodInfo.put("pro_nm", "");
                	if(itGood.hasNext()) goodInfo.put("pro_prm", itGood.next());
                	else goodInfo.put("pro_prm", "");
                	if(itGood.hasNext()) goodInfo.put("brd_id", itGood.next());
                	else goodInfo.put("brd_id", "");
                	if(itGood.hasNext()) goodInfo.put("brd_nm", itGood.next());
                	else goodInfo.put("brd_nm", "");
                	if(itGood.hasNext()) goodInfo.put("cate_id", itGood.next());
                	else goodInfo.put("cate_id", "");
                	if(itGood.hasNext()) goodInfo.put("cate_nm", itGood.next());
                	else goodInfo.put("cate_nm", "");
                	goodsInfo.add(goodInfo);
                }
                System.out.println(goodsInfo.toString());
                goodsService.uploadExcel(goodsInfo);
            }  
        }  
        
        return "uploadSuccess";
    }  
}
