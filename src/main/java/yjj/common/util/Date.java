package yjj.common.util;

import java.text.SimpleDateFormat;

import org.junit.Test;

public class Date {
	public static String getDateyyyyMMdd(){
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		return format.format(new java.util.Date()).toString();
	}
	
	@Test
	public void test(){
		System.out.println(getDateyyyyMMdd());
		
	}
}
