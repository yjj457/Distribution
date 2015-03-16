<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../resource/plugins/jquery-easyui-1.4.1/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="../resource/plugins/jquery-easyui-1.4.1/themes/icon.css">
<script type="text/javascript" src="../resource/js/jquery.min.js"></script>
<script type="text/javascript" src="../resource/plugins/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script>

	var global = 0;
	
	$(function(){
		init();
	});
	
	
	//初始化页面
	function init(){
		var value = '<c:forEach items="${org_id}" var="node"><c:out value="${node}"></c:out></c:forEach>';
		$("form").html("");
    	global = 0;
    	var targetObj = $("form").append('店铺代号:<input id="shopid" type="text" name="org_id" value="' + value + '" readonly />');
		$.parser.parse(targetObj);
    	addGoods();
	}
	
	function addGoods(){
		global++;
		var targetObj = $("form").append('<div class="sale"><div style="margin-bottom:10px"><div>货号:</div><input class="easyui-textbox" name="pro_id' + global + '" style="width:100%;height:20px"></div><div style="margin-bottom:10px"><div>货名:</div><input class="easyui-textbox" name="pro_nm' + global + '" style="width:100%;height:20px"></div><div style="margin-bottom:10px"><div>数量:</div><input class="easyui-textbox" name="sal_qty' + global + '" style="width:100%;height:20px"></div><div style="margin-bottom:10px"><div>单价:</div><input class="easyui-textbox" name="sal_amt' + global + '" style="width:100%;height:20px"></div></div><hr />');
		$.parser.parse(targetObj);
	}
	
	function sale(){
	//	alert($("form").serialize());
		$.ajax({
            type: "POST",
            url: "./../shopOwner/saleProduct",
            data: $("form").serialize(),
         // dataType: "json",
            success: function(data){
            	//data中返回订单号
				alert("下单成功,单号为:" + data);
            	
            	//初始化页面
				init();
            }
        });
	}
	
</script>
</head>
<body>

<div class="easyui-panel" style="width:400px;padding:30px 60px"><form></form></div>
<div>
	<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="addGoods();">添加商品</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="sale();">下单</a>
</div>
    
</body>
</html>