package yjj.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

public class Excel {
	public static ArrayList<ArrayList<String>> readFromXLS2003(String filePath){
		File excelFile = null;// Excel文件对象  
        InputStream is = null;// 输入流对象  
        String cellStr = null;// 单元格，最终按字符串处理
        ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();//返回的数据
        try {  
            excelFile = new File(filePath);  
            is = new FileInputStream(excelFile);// 获取文件输入流  
            HSSFWorkbook workbook2003 = new HSSFWorkbook(is);// 创建Excel2003文件对象  
            HSSFSheet sheet = workbook2003.getSheetAt(0);// 取出第一个工作表，索引是0  
            
            // 开始循环遍历行，表头不处理，从1开始  
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {  
            	ArrayList<String> list = new ArrayList<String>();
                HSSFRow row = sheet.getRow(i);// 获取行对象  
                if (row == null) {// 如果为空，不处理  
                    continue;  
                }  
                // 循环遍历单元格  
                for (int j = 0; j < row.getLastCellNum(); j++) {  
                    HSSFCell cell = row.getCell(j);// 获取单元格对象  
                    if (cell == null) {// 单元格为空设置cellStr为空串  
                        cellStr = "";  
                    } else if (cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {// 对布尔值的处理  
                        cellStr = String.valueOf(cell.getBooleanCellValue());  
                    } else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {// 对数字值的处理  
                        cellStr = cell.getNumericCellValue() + "";  
                    } else {// 其余按照字符串处理  
                        cellStr = cell.getStringCellValue();  
                    }  
                    
                    list.add(cellStr);
                }  
                lists.add(list);
            }  
	} catch (IOException e) {  
            e.printStackTrace();  
        } finally {// 关闭文件流  
            if (is != null) {  
                try {  
                    is.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
        return lists;
	}
	
	@Test
	public void test(){
		//String str = readFromXLS2003("/Users/yinjianjun/Workspaces/demo.XLS").toString();
		String str = readFromXLS2003("/Users/yinjianjun/Workspaces/2.xls").toString();
		System.out.println(str);
	}
}
